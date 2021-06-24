package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.a_lastdataDao;
import dao.s_answerDao;
import dao.s_resultDao;
import model.LoginUser;
import model.s_answer;
import model.s_answerdata;
import model.s_result;

@WebServlet("/User_SindanServlet")
public class User_SindanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("user_id") == null) {
					response.sendRedirect("/Checker_man/User_LoginServlet");
					return;
				}

				LoginUser user_id = (LoginUser)session.getAttribute("user_id"); //セッションスコープからデータを入手、JavaBeansと連携させる必要がある
				s_answerDao aDao = new s_answerDao();

				//もしも、今日回答してたら、トップページに移動する
				if (!aDao.select_answer(new s_answer(0, 0, user_id.getuser_id(), ""))) {
					response.sendRedirect("/Checker_man/User_TopPageServlet");
					return;
				}

		// 診断ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_sindan.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		LoginUser user = (LoginUser) session.getAttribute("user_id");

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int answer1 = Integer.parseInt(request.getParameter("answer1"));
		int answer2 = Integer.parseInt(request.getParameter("answer2"));
		int answer3 = Integer.parseInt(request.getParameter("answer3"));
		int answer4 = Integer.parseInt(request.getParameter("answer4"));
		int answer5 = Integer.parseInt(request.getParameter("answer5"));
		int answer6 = Integer.parseInt(request.getParameter("answer6"));
		int answer7 = Integer.parseInt(request.getParameter("answer7"));
		int answer8 = Integer.parseInt(request.getParameter("answer8"));
		int answer9 = Integer.parseInt(request.getParameter("answer9"));
		int answer10 = Integer.parseInt(request.getParameter("answer10"));
		int answer11 = Integer.parseInt(request.getParameter("answer11"));
		int answer12 = Integer.parseInt(request.getParameter("answer12"));
		int answer13 = Integer.parseInt(request.getParameter("answer13"));
		int answer14 = Integer.parseInt(request.getParameter("answer14"));
		int answer15 = Integer.parseInt(request.getParameter("answer15"));


		// 現在日時情報で初期化されたインスタンスの取得
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter java8Format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// 日時情報を指定フォーマットの文字列で取得
		String java8Disp = nowDateTime.format(java8Format);

		// 値を取得できているかの確認
		// question_id
//		System.out.println("answer1;" + answer1);
//		System.out.println("user_id;" + user);
//		System.out.println("今日の日付;" + java8Disp); // user.getuser_id()

		// 診断結果の登録処理を行う
		s_answerDao bDao = new s_answerDao();
		bDao.insert(new s_answer(1, answer1, user.getuser_id(), java8Disp));
		bDao.insert(new s_answer(2, answer2, user.getuser_id(), java8Disp));
		bDao.insert(new s_answer(3, answer3, user.getuser_id(), java8Disp));
		bDao.insert(new s_answer(4, answer4, user.getuser_id(), java8Disp));
		bDao.insert(new s_answer(5, answer5, user.getuser_id(), java8Disp));
		bDao.insert(new s_answer(6, answer6, user.getuser_id(), java8Disp));
		bDao.insert(new s_answer(7, answer7, user.getuser_id(), java8Disp));
		bDao.insert(new s_answer(8, answer8, user.getuser_id(), java8Disp));
		bDao.insert(new s_answer(9, answer9, user.getuser_id(), java8Disp));
		bDao.insert(new s_answer(10, answer10, user.getuser_id(), java8Disp));
		bDao.insert(new s_answer(11, answer11, user.getuser_id(), java8Disp));
		bDao.insert(new s_answer(12, answer12, user.getuser_id(), java8Disp));
		bDao.insert(new s_answer(13, answer13, user.getuser_id(), java8Disp));
		bDao.insert(new s_answer(14, answer14, user.getuser_id(), java8Disp));
		bDao.insert(new s_answer(15, answer15, user.getuser_id(), java8Disp));



	s_answerDao answerdataDao = new s_answerDao();
	s_answerdata resultData = answerdataDao.select_answerdata(new s_answerdata(0, 0, 0,user.getuser_id()));

	//回答から、アイコンを判断する処理
	String icon =null;

	//☓のパターン
	if(resultData.getSum() >= 60  ||  resultData.getCountfive() >= 6  ||  resultData.getCountfour() >= 9) {
	icon = "batsu";
	}

	//○のパターン
	else if(resultData.getSum() <= 40) {
		icon = "maru";
	}

	//△のパターン
	else {
		icon = "sankaku";
	}

	//データをまとめて、診断結果のデータベースにインサートする処理
	s_resultDao resultDao = new s_resultDao();
	s_result insRec = new s_result(0, null, icon, "", "", user.getuser_id());
	resultDao.insert(insRec);

	//データをまとめて、過去のデータのデータベースにインサートする処理
	a_lastdataDao lastdataDao = new a_lastdataDao();
	lastdataDao.insert_lastdata(insRec);

		// 診断結果ページにフォワードする
	response.sendRedirect("/Checker_man/User_ResultServlet");
	}
}
