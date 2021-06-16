package model;

import java.io.Serializable;

public class LoginUser implements Serializable {

	private int user_id;	// ログイン時のID

	//引数がないコントラスタ（デフォルトコントラスタ）
	public LoginUser() {
		this.user_id = 0;
	}

	//引数があるコントラスタ
	public LoginUser(int user_id) {
		this.user_id = user_id;
	}

	//ゲッターセッターのプログラム
	public int getuser_id() {
		return user_id;
	}

	public void setuser_id(int user_id) {
		this.user_id = user_id;
	}


}
