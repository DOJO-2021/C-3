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

						List<admin_lastdata> resultList2 = dao.select_lastdata(new admin_lastdata(0,0,0,null));

						for (admin_lastdata resultData : resultList2) {
							System.out.println("maru：" + resultData.getMaru_number());
							System.out.println("batsu：" + resultData.getBatsu_number());
							System.out.println("sankaku：" + resultData.getSankaku_number());
							System.out.println("date：" + resultData.getDate());
							System.out.println();
						}
//

	}
}
