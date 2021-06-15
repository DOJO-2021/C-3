package model;

import java.io.Serializable;

// クラスの定義
public class s_question implements Serializable {

	// 質問IDを保持するフィールド
	private int question_id;

	// 質問項目を保持するフィールド
	private String question;

	// 引数があるコンストラクタ
	public s_question(int question_id, String questionList) {
		super();
		this.question_id = question_id;
		this.question = questionList;
	}

	// 引数がないコンストラクタ
	public s_question() {
		super();
		this.question_id = 0;
		this.question = "";
	}

	// ゲッターセッターのプログラム
	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}