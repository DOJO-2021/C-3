package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.s_resultDao;
import model.admin_lastdata;



/**
 * Servlet implementation class Admin_LastData
 */
@WebServlet("/Admin_LastData")
public class Admin_LastDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/Checker_man/Admin_LoginServlet");
			return;
		}

		// 過去のデータページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin_lastdata.jsp");
		dispatcher.forward(request, response);
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String icon = request.getParameter("icon");
		String date = request.getParameter("date");

		// 検索処理を行う
		s_resultDao sDao = new s_resultDao();
		List<admin_lastdata> resultList = sDao.select_lastdata(new admin_lastdata(icon, count(icon),date));

		// 検索結果をリクエストスコープに格納する
		//request.setAttribute("resultList",resultList );




	//doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}


	}



}
