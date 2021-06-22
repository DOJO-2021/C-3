package model;

import java.io.Serializable;

public class s_answer implements Serializable {
	private int question_id; //診断質問ID
	private int answer; //診断回答
	private int user_id; //ユーザーID
	private String date; //日付

	//引数があるコンストラクタの生成
	public s_answer(int question_id, int answer, int user_id, String date) {
		super();
		this.question_id = question_id;
		this.answer = answer;
		this.user_id = user_id;
		this.date = date;
	}

	//引数がないコンストラクタ
	public s_answer() {
		super();
		this.question_id = 0;
		this.answer = 0;
		this.user_id = 0;
		this.date = "";
	}
	/* ↑?
	 public s_answer(){
	 	this(null, null, null, null);
	 }
	 */

	//getter,setterの生成
	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
