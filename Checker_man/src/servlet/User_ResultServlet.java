package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.s_answerDao;
import dao.s_questionDao;
import model.s_answer;
import model.s_question;

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
//		HttpSession session = request.getSession();
//		if (session.getAttribute("result_id") == null) {
//			response.sendRedirect("/Checker_man/User_LoginServlet");
//			return;
//		}

		// 診断結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_result.jsp");
		dispatcher.forward(request, response);

//		//検索処理を行う
//		s_resultDao rDao = new s_resultDao();
//		List<s_result> resultList = rDao.select(new s_result(0, "", "", "", "", 0));
//
//		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("resultList", resultList);

//______________________________________________________________________________________________________

		//検索処理を行う
		s_questionDao qDao = new s_questionDao();
		List<s_question> questionList = qDao.select(0, "");

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("questionList", questionList);


		//検索処理を行う
		s_answerDao aDao = new s_answerDao();
		List<s_answer> answerList = null;
		answerList = aDao.select(new s_answer(0, 0, 0, ""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("answerList", answerList);

//______________________________________________________________________________________________________

		// 診断結果ページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_result.jsp");
//		dispatcher.forward(request, response);



	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/Checker_man/User_LoginServlet");
//			return;
//		}
//
//		// リクエストパラメータを取得する
//		request.setCharacterEncoding("UTF-8");
//		String date = request.getParameter("DATE");
//		String icon = request.getParameter("ICON");
//		String user_comment = request.getParameter("USER_COMMENT");
//		String admin_comment = request.getParameter("ADMIN_COMMENT");
//
//		// 登録処理を行う
//		s_resultDao rDao = new s_resultDao();
//		if (rDao.insert(new s_result(0, date, icon, user_comment, admin_comment, 0))) {	// 登録成功
//			request.setAttribute("result",
//			new Result("登録成功！", "レコードを登録しました。", "/simpleBC/User_ResultServlet"));
//		}
//		else {												// 登録失敗
//			request.setAttribute("result",
//			new Result("登録失敗！", "レコードを登録できませんでした。", "/simpleBC/User_ResultServlet"));
//		}
//
//
//		// 結果ページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_result.jsp");
//		dispatcher.forward(request, response);
//	}
}
