package model;

import java.io.Serializable;

public class LoginAdmin implements Serializable {

	private String admin_id;	// ログイン時のID

	//引数がないコントラスタ（デフォルトコントラスタ）
	public LoginAdmin() {
		this(null);
	}

	//引数があるコントラスタ
	public LoginAdmin(String admin_id) {
		this.admin_id = admin_id;
	}

	//ゲッターセッターのプログラム
	public String getadmin_id() {
		return admin_id;
	}

	public void setadmin_id(String admin_id) {
		this.admin_id = admin_id;
	}


}
