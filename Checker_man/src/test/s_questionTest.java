package test;

import dao.s_questionDao;

public class s_questionTest {

	public static void main(String[] args) {
		testIsQuestionOK();
	}

	// 質問項目を表示するテスト
	public static void testIsQuestionOK() {
		s_questionDao dao = new s_questionDao();
		if (dao.IsQuestionOK(1, s_question)) {
		} else {
			System.out.println("失敗しました");
		}
	}
}
