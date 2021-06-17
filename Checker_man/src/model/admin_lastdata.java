package model;
import java.io.Serializable;

public class admin_lastdata implements Serializable {

	private int maru_number; //　○の人の数
	private int batsu_number; //　☓の人の数
	private int sankaku_number; //　△の人の数
	private String date;   //日付

	//引数があるコントラスタ
	public admin_lastdata(int maru_number, int batsu_number, int sankaku_number,String date) {
		super();
		this.maru_number = maru_number;
		this.batsu_number = batsu_number;
		this.sankaku_number = sankaku_number;
		this.date = date;
	}

	//引数がないコントラスタ（デフォルトコントラスタ）
	public admin_lastdata() {
		super();
		this.maru_number = 0;
		this.batsu_number = 0;
		this.sankaku_number = 0;
		this.date = null;
	}

	//ゲッターセッターのプログラム

	public int getMaru_number() {
		return maru_number;
	}

	public void setMaru_number(int maru_number) {
		this.maru_number = maru_number;
	}

	public int getBatsu_number() {
		return batsu_number;
	}

	public void setBatsu_number(int batsu_number) {
		this.batsu_number = batsu_number;
	}

	public int getSankaku_number() {
		return sankaku_number;
	}

	public void setSankaku_number(int sankaku_number) {
		this.sankaku_number = sankaku_number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

