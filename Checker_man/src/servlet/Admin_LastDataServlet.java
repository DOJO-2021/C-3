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

import dao.a_lastdataDao;
import model.admin_lastdata;



/**
 * Servlet implementation class Admin_LastData
 */
@WebServlet("/Admin_LastDataServlet")
public class Admin_LastDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/Checker_man/Admin_LoginServlet");
//			return;
//		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		// 検索処理を行う(4月の表)
		a_lastdataDao aDao = new a_lastdataDao();
		List<admin_lastdata> resultList4 = aDao.select_lastdata4(new admin_lastdata(0,0,0,null));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("resultList4",resultList4 );



		// 検索処理を行う(5月の表)（仮）
		a_lastdataDao aDao5 = new a_lastdataDao();
		List<admin_lastdata> resultList5 = aDao5.select_lastdata5(new admin_lastdata(0,0,0,null));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("resultList5",resultList5 );



		// 検索処理を行う(6月の表)（仮）
		a_lastdataDao aDao6 = new a_lastdataDao();
		List<admin_lastdata> resultList6 = aDao6.select_lastdata6(new admin_lastdata(0,0,0,null));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("resultList6",resultList6 );



		// 過去のデータページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin_lastdata.jsp");
		dispatcher.forward(request, response);
	}

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
