package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.user_loginDao;
import model.LoginUser;
import model.Result;
import model.user_login;

/**
 * Servlet implementation class User_LoginServlet
 */
@WebServlet("/User_LoginServlet")
public class User_LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//int user_id = Integer.parseInt(request.getParameter("USER_ID"));

		String user_name = request.getParameter("ID"); //jspのidを指定する
		String user_pw = request.getParameter("PW");

		// ログイン処理を行う
		user_loginDao lDao = new user_loginDao();

		if (lDao.isLoginOK(user_name, user_pw)) {	// ログイン成功

			user_login resultid = lDao.select_session(user_name, user_pw);

			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("user_id", new LoginUser(resultid.getUser_id()));

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/Checker_man/User_TopPageServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",
			new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/Checker_man/User_LoginServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
