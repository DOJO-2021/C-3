package model;
import java.io.Serializable;

public class admin_lastdata implements Serializable {
	private String date;   //日付
	private String icon;   //アイコン
	private int user_id; //ユーザーID

	//引数があるコントラスタ
	public admin_lastdata(int result_id, String date, String icon,
			String user_comment, String admin_comment, int user_id) {
		super();
		this.date = date;
		this.icon = icon;
		this.user_id = user_id;
	}

	//引数がないコントラスタ（デフォルトコントラスタ）
	public admin_lastdata() {
		super();
		this.date = "";
		this.icon = "";
		this.user_id = 0;
	}

	//ゲッターセッターのプログラム




}

