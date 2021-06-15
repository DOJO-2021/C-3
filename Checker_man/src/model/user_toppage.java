package model;
import java.io.Serializable;

public class user_toppage implements Serializable {

	private String icon;   //アイコン
	private String date;  //日付
	private int user_id; //ユーザーID

	//引数があるコントラスタ
	public user_toppage(String icon, String date, int user_id) {
		super();
		this.icon = icon;
		this.date = date;
		this.user_id = user_id;
	}

	//引数がないコントラスタ（デフォルトコントラスタ）
	public user_toppage() {
		super();
		this.icon = null;
		this.date = null;
		this.user_id = 0;
	}

	//ゲッターセッターのプログラム
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}

