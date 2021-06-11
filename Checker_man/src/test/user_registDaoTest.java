package test;
import java.util.List;

import dao.s_resultDao;
import model.s_result;

public class user_registDaoTest {
	public static void main(String[] args) {
		s_resultDao dao = new s_resultDao();


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


		// select_calenderのテスト
				System.out.println("---------- select_calenderのテスト ----------");

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



	}
}
