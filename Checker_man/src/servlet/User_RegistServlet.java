package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User_loginDao;
import model.Result;
import model.User_login;

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
		String name = request.getParameter("NAME");
		String pw = request.getParameter("PW");

		//パスワードが一致するかチェックする
		String pw1 = request.getParameter("PW");
		String pw2 = request.getParameter("CH-PW");


		System.out.println(pw1.equals(pw2));

		//パスワードが不一致の場合、エラーを表示して同じ画面を表示する
		if(!(pw1.equals(pw2))) {
			System.out.println("パスワードが一致していません");
			response.sendRedirect("/Checker_man/User_RegistServlet");
			return;
		}


		//登録する
		User_loginDao lDao = new User_loginDao();
		if (lDao.insert(new User_login(name, pw))) {	// 登録成功
			request.setAttribute("result",
			new Result("登録成功！", "登録が完了しました。", "/Checker_man/User_TopPageServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "登録できませんでした。", "/Checker_man/User_RegistServlet"));
		}


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
		dispatcher.forward(request, response);

	}
}
