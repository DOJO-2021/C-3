package test;
import dao.s_answerDaohoshi;
import model.s_answerdata;

public class s_answerDaoTesthoshi {

	public static void main(String[] args) {
		s_answerDaohoshi dao = new s_answerDaohoshi();

		// select()のテスト
		//user_idに1を含んだデータを検索する
//		System.out.println("---------- select()のテスト ----------");
//		List<s_answer> answerList2 = dao.select(new s_answer(0, 0, 1, ""));
//		for (s_answer answer : answerList2) {
//			System.out.println("question_id：" + answer.getQuestion_id());
//			System.out.println("answer：" + answer.getAnswer());
//			System.out.println("user_id：" + answer.getUser_id());
//			System.out.println("date：" + answer.getDate());
//			System.out.println();
//		}
//
//		//insert()のテスト
//		System.out.println("---------- insert()のテスト ----------");
//		s_answer insRec = new s_answer(1, 4, 2, "2021-06-11");
//		if (dao.insert(insRec)) {
//			System.out.println("登録成功！");
//			List<s_answer> answerList3 = dao.select(insRec);
//			for (s_answer answer : answerList3) {
//				System.out.println("question_id" + answer.getQuestion_id());
//				System.out.println("answer" + answer.getAnswer());
//				System.out.println("user_id" + answer.getUser_id());
//				System.out.println("date" + answer.getDate());
//
//				System.out.println();
//			}
//		}else {
//			System.out.println("登録失敗！");
//		}


		// select_answerdataのテスト
		System.out.println("---------- select_toppageのテスト ----------");

		s_answerdata resultData = dao.select_answerdata(new s_answerdata(0, 0, 0,1));

			System.out.println("合計：" + resultData.getSum());
			System.out.println("5の数：" + resultData.getCountfive());
			System.out.println("4の数：" + resultData.getCountfour());

			System.out.println();





	}
}
