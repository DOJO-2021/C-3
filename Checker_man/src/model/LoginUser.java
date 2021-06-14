package model;

import java.io.Serializable;

public class LoginUser implements Serializable {

	private String user_id;	// ログイン時のID

	//引数がないコントラスタ（デフォルトコントラスタ）
	public LoginUser() {
		this(null);
	}

	//引数があるコントラスタ
	public LoginUser(String user_id) {
		this.user_id = user_id;
	}

	//ゲッターセッターのプログラム
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


}
