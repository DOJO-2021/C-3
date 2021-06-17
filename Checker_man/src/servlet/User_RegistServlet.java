package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.user_loginDao;
import model.user_login;

/**
 * Servlet implementation class User_LoginServlet
 */
@WebServlet("/User_RegistServlet")
public class User_RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int PW = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 新規登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		//入力値を取ってくる
		String id = request.getParameter("ID");
		String name = request.getParameter("NAME");
		String pw = request.getParameter("PW");

		//パスワードが一致するかチェックする
		String pw1 = request.getParameter("PW");
		String pw2 = request.getParameter("CH-PW");


		System.out.println(pw1.equals(pw2));

		//パスワードが不一致の場合、エラーを表示して同じ画面を表示する
		if(!(pw1.equals(pw2) == true)) {
			System.out.println("パスワードが一致していません");
		response.sendRedirect("/Checker_man/User_RegistServlet");

		//登録する
		} else {
			user_loginDao lDao = new user_loginDao();
			lDao.insert(new user_login(0, pw1, pw2));
			request.setAttribute("pw",
					new pw("登録が完了しました。","Checker_man/User_TopPage"));

		}


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
		dispatcher.forward(request, response);

//		int user_id = Integer.parseInt(request.getParameter("USER_ID"));
//		String user_name = request.getParameter("USER_NAME");
//		String user_pw = request.getParameter("USER_PW");
//
//		// ログイン処理を行う
//		user_loginDao lDao = new user_loginDao();
//		if (lDao.isLoginOK(user_id, user_name, user_pw)) {	// ログイン成功
//			// セッションスコープにIDを格納する
//			HttpSession session = request.getSession();
//			session.setAttribute("user_id", new loginUser(user_id));
//
//			// メニューサーブレットにリダイレクトする
//			response.sendRedirect("/Checker_man/User_TopPageServlet");
//		}
//		else {									// ログイン失敗
//			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
//			request.setAttribute("result",
//			new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/Checker_man/User_LoginServlet"));
//
//			// 結果ページにフォワードする
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_login.jsp");
//			dispatcher.forward(request, response);
//		}
	}
}
