package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.s_answerDao;
import dao.s_questionDao;
import dao.s_resultDao;
import model.LoginUser;
import model.s_answer;
import model.s_question;
import model.s_result;

/**
 * Servlet implementation class User_ResultServlet
 */
@WebServlet("/User_ResultServlet")
public class User_ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/Checker_man/User_LoginServlet");
			return;
		}

		//検索処理を行う（質問内容）
		s_questionDao qDao = new s_questionDao();
		List<s_question> questionList = null;
		try {
			questionList = qDao.select(null);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("questionList", questionList);

		//検索処理を行う（回答）
		LoginUser user_id = (LoginUser)session.getAttribute("user_id"); //セッションスコープからデータを入手、JavaBeansと連携させる必要がある

		s_answerDao aDao = new s_answerDao();
		List<s_answer> answerList = null;
		answerList = aDao.select(new s_answer(0, 0, user_id.getuser_id(), ""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("answerList", answerList);



		//検索処理を行う（アイコン、受講者コメント、管理者コメント）
//		LoginUser user_id = (LoginUser)session.getAttribute("user_id"); //セッションスコープからデータを入手、JavaBeansと連携させる必要がある

		s_resultDao rDao = new s_resultDao();
		s_result resultList = rDao.select1(new s_result(0, "", "", "", "", user_id.getuser_id()));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("resultList", resultList);

		// 診断結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_result.jsp");
		dispatcher.forward(request, response);


	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/Checker_man/User_LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		String user_comment = request.getParameter("user_message");
		int user_id = Integer.parseInt(request.getParameter("user_id"));

		// ユーザーのコメント更新処理を行う
		s_resultDao rDao = new s_resultDao();
		rDao.update_usercomment(new s_result(0, null, null, user_comment,null, user_id));

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_result.jsp");
		dispatcher.forward(request, response);
	}
}
