package model;

import java.io.Serializable;

// クラスの定義
public class s_question implements Serializable {

	// 質問項目を保持するフィールド
	private String Question;

	// 質問項目を表示するメソッド
	public void showQuestion() {
		System.out.println(this.Question);
	}

	// コンストラクタ
	public s_question(String Question) {
		this.Question = Question;
	}
}