package model;
import java.io.Serializable;

public class admin_lastdata implements Serializable {

	private String icon;   //アイコン
	private int icon_number; //アイコンの人数
	private String date;   //日付

	//引数があるコントラスタ
	public admin_lastdata(String icon, int icon_number,String date) {
		super();
		this.icon = icon;
		this.icon_number = icon_number;
		this.date = date;
	}

	//引数がないコントラスタ（デフォルトコントラスタ）
	public admin_lastdata() {
		super();
		this.icon = null;
		this.icon_number = 0;
		this.date = null;
	}

	//ゲッターセッターのプログラム
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getIcon_number() {
		return icon_number;
	}

	public void setIcon_number(int icon_number) {
		this.icon_number = icon_number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

