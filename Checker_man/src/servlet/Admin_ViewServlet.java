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

import dao.User_loginDao;
import dao.s_answerDao;
import dao.s_questionDao;
import dao.s_resultDao;
import model.User_login;
import model.s_answer;
import model.s_question;
import model.s_result;

/**
 * Servlet implementation class Admin_ViewServlet
 */
@WebServlet("/Admin_ViewServlet")
public class Admin_ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
//		if (session.getAttribute("admin_id") == null) {
//			response.sendRedirect("/Checker_man/Admin_LoginServlet");
//			return;
//		}

		//URL（Admin_ViewServlet?user_id = ○）から、○の数値を取得
		int user_id =  Integer.parseInt(request.getParameter("user_id"));

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
		s_answerDao aDao = new s_answerDao();
		List<s_answer> answerList = null;
		answerList = aDao.select(new s_answer(0, 0, user_id, ""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("answerList", answerList);

		//検索処理を行う（アイコン、受講者コメント、管理者コメント）
		s_resultDao rDao = new s_resultDao();
		s_result resultList = rDao.select1(new s_result(0, "", "", "", "", user_id));
		User_loginDao rDao2 = new User_loginDao();
		User_login result = rDao2.select_username(new User_login(user_id, "", "" ));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("resultList", resultList);
		request.setAttribute("result", result);

		// 閲覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin_view.jsp");
		dispatcher.forward(request, response);


	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
//		if (session.getAttribute("admin_id") == null) {
//			response.sendRedirect("/Checker_man/Admin_LoginServlet");
//			return;
//		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		String admin_comment = request.getParameter("admin_message");
		int user_id = Integer.parseInt(request.getParameter("user_id"));

		// 登録処理を行う
		s_resultDao rDao = new s_resultDao();
		rDao.update_admincomment(new s_result(0, null, null, null, admin_comment, user_id));

		// 結果ページにフォワードする

		response.sendRedirect("/Checker_man/Admin_ViewServlet?user_id="+ user_id);
	}
}
