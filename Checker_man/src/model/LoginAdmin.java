package model;

import java.io.Serializable;

public class LoginAdmin implements Serializable {

	private int admin_id;	// ログイン時のID

	//引数がないコントラスタ（デフォルトコントラスタ）
	public LoginAdmin() {
		this.admin_id = 0;
	}

	//引数があるコントラスタ
	public LoginAdmin(int admin_id) {
		this.admin_id = admin_id;
	}

	//ゲッターセッターのプログラム
	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}


}
