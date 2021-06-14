package test;

import java.util.List;

import dao.s_questionDao;
import model.s_question;

public class s_questionTest {

	public static void main(String[] args) {
		s_questionDao dao = new s_questionDao();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<s_question> questionList2 = dao.select(new s_question(1, questionList));
		for (s_question question : questionList2) {
			System.out.println("question_id：" + question.getQuestion_id());
			System.out.println("question：" + question.getQuestion());
			System.out.println();
		}
	}
}