package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
		//現在の月からの差分　今月が「1」、先月が「0」
		int diffCount = 1;
		if(request.getParameter("diffCount") != null) {
			diffCount = Integer.parseInt(request.getParameter("diffCount"));
		}


		//日付の文字列を作成　2021-06-01と2021-06-31 2021/06/01 2021/6/1
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, diffCount - 1);

		//日付をどの形で表記するのか指定
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String firstDate = sdf.format(getFirstDate(cal.getTime()));
		String lastDate = sdf.format(getLastDate(cal.getTime()));




		// カレンダーの検索処理を行う
		LoginUser user_id = (LoginUser) session.getAttribute("user_id"); //セッションスコープからデータを入手、JavaBeansと連携させる必要がある

		s_resultDao calenderDao = new s_resultDao();
		List<user_toppage> calenderlist = calenderDao.select_calender(new user_toppage("","",firstDate,lastDate , user_id.getuser_id()));


		// カレンダーの処理をリクエストスコープに格納する
		request.setAttribute("calenderlist", calenderlist);
		request.setAttribute("view_monthlist", diffCount);






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

	// 月初日を返す
	public static Date getFirstDate(Date date) {

		if (date==null) return null;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int first = calendar.getActualMinimum(Calendar.DATE);
		calendar.set(Calendar.DATE, first);

		calendar.set(Calendar.HOUR_OF_DAY, 00);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		calendar.set(Calendar.MILLISECOND, 000);

		return calendar.getTime();
	}

	// 月末日を返す
	public static Date getLastDate(Date date) {

		if (date==null) return null;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int last = calendar.getActualMaximum(Calendar.DATE);
		calendar.set(Calendar.DATE, last);

		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);

		return calendar.getTime();
	}

}
