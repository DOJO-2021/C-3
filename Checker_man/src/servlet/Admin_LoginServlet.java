package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Admin_loginDao;
import model.Admin_login;
import model.LoginAdmin;
import model.Result;

/**
 * Servlet implementation class Admin_LoginServlet
 */
@WebServlet("/Admin_LoginServlet")
public class Admin_LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin_login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//int user_id = Integer.parseInt(request.getParameter("USER_ID"));

		String admin_name = request.getParameter("ID"); //jspのidを指定する
		String admin_pw = request.getParameter("PW");

		// ログイン処理を行う
		Admin_loginDao adDao = new Admin_loginDao();
		if (adDao.isLoginOK(admin_name, admin_pw)) {	// ログイン成功

			// セッションスコープにIDを格納する
			Admin_login resultid = adDao.select_session(admin_name, admin_pw); //ユーザーIDをselectするためのDaoメソッド


			HttpSession session = request.getSession();
			session.setAttribute("admin_id", new LoginAdmin(resultid.getAdmin_id()));

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/Checker_man/Admin_TopPageServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",
			new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/Checker_man/Admin_LoginServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin_login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
