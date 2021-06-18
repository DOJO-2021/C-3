package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.s_resultDao;
import model.admin_toppage;


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


		//LoginUser user_id = (LoginUser)session.getAttribute("user_id"); //セッションスコープからデータを入手、JavaBeansと連携させる必要がある

		// アイコンの数の検索処理を行う
		s_resultDao iconDao = new s_resultDao();
		admin_toppage iconNumber = iconDao.select_toppage(new admin_toppage(0, 0, 0, 0,null,null,null,null, null, null, null, null));


		// リクエストスコープに格納する
		request.setAttribute("iconNumber", iconNumber);

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
