package test;


import java.util.List;

import dao.a_lastdataDao;
import model.admin_lastdata;

public class a_lastdataDaoTest {

	public static void main(String[] args) {
		a_lastdataDao dao = new a_lastdataDao();


//		// insert()のテスト
//				System.out.println("---------- insert()のテスト ----------");
//
//				//ユーザーIDが4の場合
//				s_result insRec = new s_result(0,null,null,null,null,4);
//
//				if (dao.insert_lastdata(insRec)) {
//					System.out.println("登録成功！");
//
//				}
//
//				else {
//					System.out.println("登録失敗！");
//				}

//				// selectのテスト
						System.out.println("---------- selectのテスト ----------");

						List<admin_lastdata> resultList4 = dao.select_lastdata4(new admin_lastdata(0,0,0,null));

						for (admin_lastdata resultData4 : resultList4) {
							System.out.println("maru：" + resultData4.getMaru_number());
							System.out.println("batsu：" + resultData4.getBatsu_number());
							System.out.println("sankaku：" + resultData4.getSankaku_number());
							System.out.println("date：" + resultData4.getDate());
							System.out.println();
						}

						// selectのテスト
						System.out.println("---------- select_lastdata5のテスト ----------");

						List<admin_lastdata> resultList5 = dao.select_lastdata5(new admin_lastdata(0,0,0,null));

						for (admin_lastdata resultData5 : resultList5) {
							System.out.println("maru：" + resultData5.getMaru_number());
							System.out.println("batsu：" + resultData5.getBatsu_number());
							System.out.println("sankaku：" + resultData5.getSankaku_number());
							System.out.println("date：" + resultData5.getDate());
							System.out.println();
						}

						// selectのテスト
						System.out.println("---------- select_lastdata6のテスト ----------");

						List<admin_lastdata> resultList6 = dao.select_lastdata6(new admin_lastdata(0,0,0,null));

						for (admin_lastdata resultData6 : resultList6) {
							System.out.println("maru：" + resultData6.getMaru_number());
							System.out.println("batsu：" + resultData6.getBatsu_number());
							System.out.println("sankaku：" + resultData6.getSankaku_number());
							System.out.println("date：" + resultData6.getDate());
							System.out.println();
						}

	}
}
