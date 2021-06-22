package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.s_answerDao;
import model.LoginUser;
import model.Result;
import model.s_answer;

@WebServlet("/User_SindanServlet")
public class User_SindanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//		HttpSession session = request.getSession();
		//		if (session.getAttribute("user_id") == null) {
		//			response.sendRedirect("/Checker_man/User_SindanServlet");
		//			return;
		//		}
		//
		//		// リクエストパラメータを取得する
		//		request.setCharacterEncoding("UTF-8");
		//		String question_id = request.getParameter("QUESTION_ID");
		//		String question = request.getParameter("QUESTION");
		//
		//		// 診断項目の処理を行う
		//		s_questionDao bDao = new s_questionDao();
		//		try {
		//			if (bDao.select(new s_question(0, question)) != null) { // 登録成功
		//				request.setAttribute("result",
		//						new Result("登録成功", "レコードを登録しました。", "/Checker_man/User_ResultServlet"));
		//			} else { // 登録失敗
		//				request.setAttribute("result",
		//						new Result("登録失敗", "レコードを登録できませんでした。", "/Checker_man/User_SindanServlet"));
		//			}
		//		} catch (SQLException e) {
		//			e.printStackTrace();
		//		}

		// 診断ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_sindan.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		//		if (session.getAttribute("user_id") == null) {
		//			response.sendRedirect("/Checker_man/User_LoginServlet");
		//			return;
		//		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int sindan1 = Integer.parseInt(request.getParameter("sindan1"));
		LoginUser user = (LoginUser) session.getAttribute("user_id");

		String date = request.getParameter("DATE");

		System.out.println("sindan1;" + sindan1);
		System.out.println("user_id;" + user);

		// 診断結果の登録処理を行う
		s_answerDao bDao = new s_answerDao();
		if (bDao.insert(new s_answer(0, 0, 0, date))) { // 登録成功
			request.setAttribute("result",
					new Result("登録成功", "レコードを登録しました。", "/Checker_man/User_ResultServlet"));
		} else { // 登録失敗
			request.setAttribute("result",
					new Result("登録失敗", "レコードを登録できませんでした。", "/Checker_man/User_SindanServlet"));
		}

		// 診断結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_result.jsp");
		dispatcher.forward(request, response);
	}
}
