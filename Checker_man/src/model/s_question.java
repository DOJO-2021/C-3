package model;

import java.io.Serializable;

// クラスの定義
public class s_question implements Serializable {

	// 質問項目を保持するフィールド
	private String Question;

	public Result() {
		this(null, null, null);
	}

	public Result(String title, String message, String backTo) {
		this.title = title;
		this.message = message;
		this.backTo = backTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBackTo() {
		return backTo;
	}

	public void setBackTo(String backTo) {
		this.backTo = backTo;
	}
}
