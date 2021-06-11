package model;
import java.io.Serializable;

public class admin_login implements Serializable {
	private int admin_id;
	private String admin_name;
	private String admin_pw;

	// 引数があるコンストラクタ
	public admin_login(int admin_id,String admin_name, String admin_pw) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_pw = admin_pw;
	}

	// 引数がないコンストラクタ（デフォルトコンストラクタ）
	public admin_login() {
		super();
		this.admin_id = 0;
		this.admin_name = "";
		this.admin_pw = "";
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_pw() {
		return admin_pw;
	}

	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}

}