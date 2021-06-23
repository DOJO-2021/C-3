package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User_loginDao;
import model.User_login;

/**
 * Servlet implementation class User_LoginServlet
 */
@WebServlet("/User_RegistServlet")
public class User_RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 新規登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		//入力値を取ってくる
		String name = request.getParameter("NAME");
		String pw = request.getParameter("PW");

		//パスワードが一致するかチェックする
		String pw1 = request.getParameter("PW");
		String pw2 = request.getParameter("CH-PW");

		System.out.println(pw1.equals(pw2));

		//ユーザーIDが空の場合、エラーを表示して同じ画面を表示する
		if (name == "") {
		System.out.println("ユーザーIDが入力されていません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//パスワードが空の場合
		if (pw1 == "") {
			System.out.println("パスワードが入力されていません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//確認用パスワードが空の場合
		if (pw2 == "") {
			System.out.println("確認用パスワードが入力されていません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//パスワードが不一致の場合、エラーを表示して同じ画面を表示する
		if (!(pw1.equals(pw2))) {
			System.out.println("パスワードが一致していません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//登録する
		User_loginDao lDao = new User_loginDao();
		if (lDao.insert(new User_login(0,name, pw))) { // 登録成功

		response.sendRedirect("/Checker_man/User_LoginServlet");
		//System.out.println("登録が完了しました。");
		}

		// 登録失敗
		else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
		dispatcher.forward(request, response);
		}


		   }
	  }
