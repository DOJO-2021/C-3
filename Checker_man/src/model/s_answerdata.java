package model;
import java.io.Serializable;

public class s_answerdata implements Serializable {

	private int sum;//合計点数
	private int countfive;//５を選んだ数
	private int countfour;//４を選んだ数

	//引数があるコンストラクタの生成
	public s_answerdata(int sum, int countfive, int countfour) {
		super();
		this.sum = sum;
		this.countfive = countfive;
		this.countfour = countfour;
	}
	//引数がないコンストラクタ
	public s_answerdata() {
		super();
		this.question_id = 0;
		this.answer = 0;
		this.user_id = 0;
		this.date = "";
	}

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
