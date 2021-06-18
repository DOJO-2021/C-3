package test;


import java.util.List;

import dao.s_resultDao;
import model.s_result;
import model.user_toppage;

public class s_resultDaoTest {

	public static void main(String[] args) {
		s_resultDao dao = new s_resultDao();


//		// insert()のテスト
//				System.out.println("---------- insert()のテスト ----------");
//
//				s_result insRec = new s_result(0, null, "maru", "受講者コメント", "管理者コメント", 10);
//
//				if (dao.insert(insRec)) {
//					System.out.println("登録成功！");
//
//					List<s_result> resultList = dao.select(insRec);
//
//					for (s_result resultData : resultList) {
//						System.out.println("result_id：" + resultData.getResult_id());
//						System.out.println("date：" + resultData.getDate());
//						System.out.println("icon：" + resultData.getIcon());
//						System.out.println("user_comment：" + resultData.getUser_comment());
//						System.out.println("admin_comment：" + resultData.getAdmin_comment());
//						System.out.println("user_id：" + resultData.getUser_id());
//						System.out.println();
//					}
//				}
//
//				else {
//					System.out.println("登録失敗！");
//				}
//
//				// selectのテスト
//						System.out.println("---------- selectのテスト ----------");
//
//						List<s_result> resultList2 = dao.select(new s_result(0, "2021", "", "", "", 0));
//
//						for (s_result resultData : resultList2) {
//							System.out.println("result_id：" + resultData.getResult_id());
//							System.out.println("date：" + resultData.getDate());
//							System.out.println("icon：" + resultData.getIcon());
//							System.out.println("user_comment：" + resultData.getUser_comment());
//							System.out.println("admin_comment：" + resultData.getAdmin_comment());
//							System.out.println("user_id：" + resultData.getUser_id());
//							System.out.println();
//						}
//
//
				// select_toppageのテスト
//						System.out.println("---------- select_toppageのテスト ----------");
//
//						admin_toppage resultData = dao.select_toppage(new admin_toppage(0, 0, 0, 0,null,null,null,null, null, null, null, null));
//
//							System.out.println("○の人数：" + resultData.getMaru_number());
//							System.out.println("☓の人数：" + resultData.getBatsu_number());
//							System.out.println("△の人数：" + resultData.getSankaku_number());
//							System.out.println("commentの人数：" + resultData.getComment_number());
//							System.out.println("○の人：" + resultData.getMaru_list());
//							System.out.println("○の人id：" + resultData.getMaru_id());
//							System.out.println("☓の人：" + resultData.getBatsu_list());
//							System.out.println("☓の人id：" + resultData.getBatsu_id());
//							System.out.println("△の人：" + resultData.getSankaku_list());
//							System.out.println("△の人id：" + resultData.getSankaku_id());
//							System.out.println("コメントした人：" + resultData.getComment_list());
//							System.out.println("コメントした人id：" + resultData.getComment_id());
//
//							System.out.println();
//
//
//				// select_lastdataのテスト
//		System.out.println("---------- select_lastdataのテスト ----------");
//							List<admin_lastdata> resultList3 = dao.select_lastdata(new admin_lastdata("", 0,""));
//
//							for (admin_lastdata resultData1 : resultList3) {
//								System.out.println("icon：" + resultData1.getIcon());
//								System.out.println("icon_number：" + resultData1.getIcon_number());
//								System.out.println("date：" + resultData1.getDate());
//								System.out.println();
//							}
//
//
//		// select_calenderのテスト
		System.out.println("---------- select_calenderのテスト ----------");
		List<user_toppage> resultList4 = dao.select_calender(new user_toppage("", "",1));

		for (user_toppage resultData1 : resultList4) {
			System.out.println("icon：" + resultData1.getIcon());
			System.out.println("date：" + resultData1.getDate());
			System.out.println("user_id：" + resultData1.getUser_id());
			System.out.println();
		}



		//select1のテスト（アイコン、受講者コメント、管理者コメント）
		System.out.println("---------- select1のテスト ----------");
		s_result resultList = dao.select1(new s_result(0,"","","", "",1));


			System.out.println("icon：" + resultList.getIcon());
			System.out.println("user_comment：" + resultList.getUser_comment());
			System.out.println("admin_comment：" + resultList.getAdmin_comment());
			System.out.println();


		//insert1のテスト（受講者コメント）
		System.out.println("---------- insert()のテスト ----------");
		s_result insRec = new s_result(0, "2021-06-17", "sankaku", "受講者コメント", "", 10);
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<s_result> commentList = dao.select(insRec);
			for (s_result comment : commentList) {
				System.out.println("result_id" + comment.getResult_id());
				System.out.println("date" + comment.getDate());
				System.out.println("icon" + comment.getIcon());
				System.out.println("user_comment" + comment.getUser_comment());
				System.out.println("admin_comment" + comment.getAdmin_comment());
				System.out.println("user_id" + comment.getUser_id());

				System.out.println();
			}
		}else {
			System.out.println("登録失敗！");
		}


	}

}
