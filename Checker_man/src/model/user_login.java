package model;
import java.io.Serializable;

public class user_login implements Serializable {
	private int user_id;	// ID
	private String user_name; //ユーザー名
	private String user_pw;	// PW


	//引数のあるコンストラクタ
	public user_login(int user_id,String user_name,String user_pw) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pw = user_pw;
	}

	//引数のないコンストラクタ
	public user_login() {}

	//ゲッター
	public int getUser_id() {
		return user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getUser_pw() {
		return user_pw;
	}


	//セッター
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public boolean insert(user_login user_login) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}


}
