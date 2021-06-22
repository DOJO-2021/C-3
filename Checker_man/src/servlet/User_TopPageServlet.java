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
import model.LoginUser;
import model.user_toppage;

@WebServlet("/User_TopPageServlet")
public class User_TopPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//	 もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/Checker_man/User_LoginServlet");
			return;
		}

		//表示する月の情報　先月(5月)、今月(6月),,,,
		request.getAttribute("date");

		request.getAttribute("date");



		//上をもとに絞り込む日付情報を,,,


		// カレンダーの検索処理を行う
		LoginUser user_id = (LoginUser) session.getAttribute("user_id"); //セッションスコープからデータを入手、JavaBeansと連携させる必要がある

		s_resultDao calenderDao = new s_resultDao();
		List<user_toppage> calenderlist = calenderDao.select_calender(new user_toppage("","date.getDate1()", "date.getDate2()", user_id.getuser_id()));

		// カレンダーの処理をリクエストスコープに格納する
		request.setAttribute("calenderlist", calenderlist);


		//月の差分を view_monthlist に格納する　今月なら「1」、先月なら「0」、来月なら「2」
		List <user_toppage> view_monthlist = calenderDao.select_calender(new user_toppage());

		request.setAttribute("view_monthlist", view_monthlist);




		// ユーザートップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_toppage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/Checker_man/User_LoginServlet");
			return;
		}

	}

}
