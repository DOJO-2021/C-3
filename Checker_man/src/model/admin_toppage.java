package model;
import java.io.Serializable;

public class admin_toppage implements Serializable {

	private String icon;   //アイコン
	private int icon_number; //アイコンの人数

	//引数があるコントラスタ
	public admin_toppage(String icon, int icon_number) {
		super();
		this.icon = icon;
		this.icon_number = icon_number;
	}

	//引数がないコントラスタ（デフォルトコントラスタ）
	public admin_toppage() {
		super();
		this.icon = null;
		this.icon_number = 0;
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

}

