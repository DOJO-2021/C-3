package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.s_resultDao;
import model.user_toppage;


@WebServlet("/User_TopPageServlet")
public class User_TopPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	//	 もしもログインしていなかったらログインサーブレットにリダイレクトする
//				HttpSession session = request.getSession();
//				if (session.getAttribute("user_id") == null) {
//					response.sendRedirect("/Checker_man/User_LoginServlet");
//					return;
//				}

		// カレンダーの検索処理を行う
				s_resultDao calenderDao = new s_resultDao();
				//session.getAttribute("user_id") = user_id;
				List<user_toppage> calenderlist = calenderDao.select_calender(new user_toppage("", "",1));

		// カレンダーの処理をリクエストスコープに格納する
		request.setAttribute("calenderlist", calenderlist);

		// ユーザートップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_toppage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("user_id") == null) {
//			response.sendRedirect("/Checker_man/User_LoginServlet");
//			return;
//		}




	}


}
