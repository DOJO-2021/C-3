package model;
import java.io.Serializable;

public class user_toppage implements Serializable {

	private String icon;   //アイコン
	private String date1;  //日付1
	private String date2;
	private int user_id; //ユーザーID

	//引数があるコントラスタ
	public user_toppage(String icon, String date1,String date2, int user_id) {
		super();
		this.icon = icon;
		this.date1 = date1;
		this.date2 = date2;
		this.user_id = user_id;
	}

	//引数がないコントラスタ（デフォルトコントラスタ）
	public user_toppage() {
		super();
		this.icon = null;
		this.date1 = null;
		this.date2 = null;
		this.user_id = 0;
	}

	//ゲッターセッターのプログラム
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}


	//〇だったら、〇の画像、△だったら△の画像～
	public String getIcon_path() {
		if(this.icon.equals("maru")) {
			return "/Checker_man/images/maru.png";
		}
		else if(this.icon.equals("batsu")){
			return "/Checker_man/images/batsu.png";
		}
		else {
			return "/Checker_man/images/sankaku.png";
		}
	}

	public String getDate1() {
		return date1;
	}

	public void setDate(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}

