package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.s_resultDao;
import model.Result;
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
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/Checker_man/User_LoginServlet");
			return;
		}

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
		String date = request.getParameter("DATE");
		String icon = request.getParameter("ICON");
		String user_comment = request.getParameter("USER_COMMENT");
		String admin_comment = request.getParameter("ADMIN_COMMENT");

		// 登録処理を行う
		s_resultDao rDao = new s_resultDao();
		if (rDao.insert(new s_result(0, date, icon, user_comment, admin_comment, 0))) {	// 登録成功
			request.setAttribute("result",
			new Result("登録成功！", "レコードを登録しました。", "/simpleBC/MenuServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。", "/simpleBC/MenuServlet"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}
}
