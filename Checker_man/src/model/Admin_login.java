package model;
import java.io.Serializable;

public class Admin_login implements Serializable {
	private int admin_id;
	private String admin_name;
	private String admin_pw;

	// 引数があるコンストラクタ
	public Admin_login(String admin_name, String admin_pw) {

		this.admin_name = admin_name;
		this.admin_pw = admin_pw;
	}

	// 引数がないコンストラクタ
	public Admin_login() {

	}

	//getter
	public int getAdmin_id() {
		return admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public String getAdmin_pw() {
		return admin_pw;
	}

	//setter
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}

}