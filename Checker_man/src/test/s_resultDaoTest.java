package test;

import java.util.List;

import dao.s_resultDao;
import model.admin_lastdata;

public class s_resultDaoTest {

	public static void main(String[] args) {
		s_resultDao dao = new s_resultDao();

		/*
		// insert()のテスト
				System.out.println("---------- insert()のテスト ----------");

				s_result insRec = new s_result(0, null, "maru", "受講者コメント", "管理者コメント", 6);

				if (dao.insert(insRec)) {
					System.out.println("登録成功！");

					List<s_result> resultList = dao.select(insRec);

					for (s_result resultData : resultList) {
						System.out.println("result_id：" + resultData.getResult_id());
						System.out.println("date：" + resultData.getDate());
						System.out.println("icon：" + resultData.getIcon());
						System.out.println("user_comment：" + resultData.getUser_comment());
						System.out.println("admin_comment：" + resultData.getAdmin_comment());
						System.out.println("user_id：" + resultData.getUser_id());
						System.out.println();
					}
				}

				else {
					System.out.println("登録失敗！");
				}

				// selectのテスト
						System.out.println("---------- selectのテスト ----------");

						List<s_result> resultList2 = dao.select(new s_result(0, "2021", "", "", "", 0));

						for (s_result resultData : resultList2) {
							System.out.println("result_id：" + resultData.getResult_id());
							System.out.println("date：" + resultData.getDate());
							System.out.println("icon：" + resultData.getIcon());
							System.out.println("user_comment：" + resultData.getUser_comment());
							System.out.println("admin_comment：" + resultData.getAdmin_comment());
							System.out.println("user_id：" + resultData.getUser_id());
							System.out.println();
						}

						// select_iconのテスト
						System.out.println("---------- select_iconのテスト ----------");

						admin_toppage resultData = dao.select_icon(new admin_toppage("", 0));;

							System.out.println("icon：" + resultData.getIcon());
							System.out.println("icon_number：" + resultData.getIcon_number());
							System.out.println();*/


				// select_lastdataのテスト
							List<admin_lastdata> resultList3 = dao.select_lastdata(new admin_lastdata("", 0,""));

							for (admin_lastdata resultData : resultList3) {
								System.out.println("icon：" + resultData.getIcon());
								System.out.println("icon_number：" + resultData.getIcon_number());
								System.out.println("date：" + resultData.getDate());
								System.out.println();
							}

	}
}
