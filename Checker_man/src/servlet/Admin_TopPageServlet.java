package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Admin_TopPageServlet")
public class Admin_TopPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	//	 もしもログインしていなかったらログインサーブレットにリダイレクトする
//				HttpSession session = request.getSession();
//				if (session.getAttribute("admin_id") == null) {
//					response.sendRedirect("/Checker_man/Admin_LoginServlet");
//					return;
//				}



//		// カレンダーの検索処理を行う（ユーザID = 1の場合）
//				s_resultDao calenderDao = new s_resultDao();
//				List<user_toppage> calenderlist = calenderDao.select_calender(new user_toppage("", "",1));
//
//		// カレンダーの検索処理を行う
////				HttpSession session = request.getSession();
////				s_resultDao calenderDao = new s_resultDao();
////				int id = (int)session.getAttribute("user_id");
////				List<user_toppage> calenderlist = calenderDao.select_calender(new user_toppage("", "",id));
//
//		// カレンダーの処理をリクエストスコープに格納する
//		request.setAttribute("calenderlist", calenderlist);

		// 管理者トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin_toppage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//	 もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("admin_id") == null) {
//			response.sendRedirect("/Checker_man/Admin_LoginServlet");
//			return;
//		}




	}


}
