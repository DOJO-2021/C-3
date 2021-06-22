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
import model.admin_toppage;
import model.admin_toppagelist;


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

		//URLでUser_TopPageServlet?user_id=1を実行させるための処理
		//int user_id =  Integer.parseInt(request.getParameter("user_id"));
		//List<user_toppage> calenderlist = calenderDao.select_calender(new user_toppage("", "",user_id));

		// アイコンの数の検索処理を行う
		s_resultDao iconDao = new s_resultDao();
		admin_toppage iconNumber = iconDao.select_toppage_number(new admin_toppage(0, 0, 0, 0 ));
		List<admin_toppagelist> iconList = iconDao.select_toppagelist(new admin_toppagelist(null,null,null,null, 0, 0, 0, 0));

		// リクエストスコープに格納する
		request.setAttribute("iconNumber", iconNumber);
		request.setAttribute("iconList", iconList);

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
