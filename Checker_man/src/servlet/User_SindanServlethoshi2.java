package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.a_lastdataDao;
import dao.s_answerDao;
import dao.s_resultDao;
import model.s_answerdata;
import model.s_result;

@WebServlet("/User_SindanServlethoshi2")
public class User_SindanServlethoshi2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//		HttpSession session = request.getSession();
		//		if (session.getAttribute("user_id") == null) {
		//			response.sendRedirect("/Checker_man/User_SindanServlet");
		//			return;
		//		}
		//
		//		// リクエストパラメータを取得する
		//		request.setCharacterEncoding("UTF-8");
		//		String question_id = request.getParameter("QUESTION_ID");
		//		String question = request.getParameter("QUESTION");
		//
		//		// 診断項目の処理を行う
		//		s_questionDao bDao = new s_questionDao();
		//		try {
		//			if (bDao.select(new s_question(0, question)) != null) { // 登録成功
		//				request.setAttribute("result",
		//						new Result("登録成功", "レコードを登録しました。", "/Checker_man/User_ResultServlet"));
		//			} else { // 登録失敗
		//				request.setAttribute("result",
		//						new Result("登録失敗", "レコードを登録できませんでした。", "/Checker_man/User_SindanServlet"));
		//			}
		//		} catch (SQLException e) {
		//			e.printStackTrace();
		//		}

		// ユーザーの回答(1～5)の検索処理を行う
		//LoginUser user_id = (LoginUser)session.getAttribute("user_id"); //セッションスコープからデータを入手、JavaBeansと連携させる必要がある

	s_answerDao answerdataDao = new s_answerDao();
	s_answerdata resultData = answerdataDao.select_answerdata(new s_answerdata(0, 0, 0,1));

	//回答から、アイコンを判断する処理
	String icon =null;

	//☓のパターン
	if(resultData.getSum() >= 60  ||  resultData.getCountfive() <= 6  ||  resultData.getCountfour() <= 9) {
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
	s_result insRec = new s_result(0, null, icon, "", "", 1);
	resultDao.insert(insRec);

	//データをまとめて、過去のデータのデータベースにインサートする処理
	a_lastdataDao lastdataDao = new a_lastdataDao();
	lastdataDao.insert_lastdata(insRec);


		// 診断ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_sindan.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//		HttpSession session = request.getSession();
		//		if (session.getAttribute("user_id") == null) {
		//			response.sendRedirect("/Checker_man/User_LoginServlet");
		//			return;
		//		}

		// リクエストパラメータを取得する
//		request.setCharacterEncoding("UTF-8");
//		request.getParameter("QUESTION_ID");
//		request.getParameter("ANSWER");
//		request.getParameter("USER_ID");
//		String question = request.getParameter("QUESTION");
//
//		// 診断結果の登録処理を行う
//		s_answerDao bDao = new s_answerDao();
//		if (bDao.insert(new s_answer(0, 0, 0, question))) { // 登録成功
//			request.setAttribute("result",
//					new Result("登録成功", "レコードを登録しました。", "/Checker_man/User_ResultServlet"));
//		} else { // 登録失敗
//			request.setAttribute("result",
//					new Result("登録失敗", "レコードを登録できませんでした。", "/Checker_man/User_SindanServlet"));
//		}




		// 診断結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/User_Result.jsp");
		dispatcher.forward(request, response);
	}
}
