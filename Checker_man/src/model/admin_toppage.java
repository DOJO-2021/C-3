package model;
import java.io.Serializable;

public class admin_toppage implements Serializable {

	private int maru_number; //　○の人の数
	private int batsu_number; //　☓の人の数
	private int sankaku_number; //　△の人の数
	private int comment_number; // コメントの数

	//引数があるコントラスタ
	public admin_toppage(int maru_number, int batsu_number, int sankaku_number, int comment_number) {
		super();
		this.maru_number = maru_number;
		this.batsu_number = batsu_number;
		this.sankaku_number = sankaku_number;
		this.comment_number = comment_number;
	}

	//引数がないコントラスタ（デフォルトコントラスタ）
	public admin_toppage() {
		super();
		this.maru_number = 0;
		this.batsu_number = 0;
		this.sankaku_number = 0;
		this.comment_number = 0;
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

	public int getComment_number() {
		return comment_number;
	}

	public void setComment_number(int comment_number) {
		this.comment_number = comment_number;
	}

}