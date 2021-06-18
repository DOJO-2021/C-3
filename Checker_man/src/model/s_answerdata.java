package model;
import java.io.Serializable;

public class s_answerdata implements Serializable {

	private int sum;//合計点数
	private int countfive;//５を選んだ数
	private int countfour;//４を選んだ数
	private int user_id; //ユーザーID

	//引数があるコンストラクタの生成
	public s_answerdata(int sum, int countfive, int countfour,int user_id) {
		super();
		this.sum = sum;
		this.countfive = countfive;
		this.countfour = countfour;
		this.user_id = user_id;
	}
	//引数がないコンストラクタ
	public s_answerdata() {
		super();
		this.sum = 0;
		this.countfive = 0;
		this.countfour = 0;
		this.user_id = 0;
	}


	//getter,setterの生成
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getCountfive() {
		return countfive;
	}
	public void setCountfive(int countfive) {
		this.countfive = countfive;
	}
	public int getCountfour() {
		return countfour;
	}
	public void setCountfour(int countfour) {
		this.countfour = countfour;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
