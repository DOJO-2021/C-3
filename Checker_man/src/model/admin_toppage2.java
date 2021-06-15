package model;
import java.io.Serializable;

public class admin_toppage2 implements Serializable {

	private String maru_user; //　○の人の表示
	private String batsu_user; //　☓の人の表示
	private String sankaku_user; //　△の人の表示
	private String comment_user; // コメントした人の表示

	//引数があるコントラスタ
	public admin_toppage2(String maru_user, String batsu_user, String sankaku_user, String comment_user) {
		super();
		this.maru_user = maru_user;
		this.batsu_user = batsu_user;
		this.sankaku_user = sankaku_user;
		this.comment_user = comment_user;
	}

	//引数がないコントラスタ（デフォルトコントラスタ）
	public admin_toppage2() {
		super();
		this.maru_user = null;
		this.batsu_user = null;
		this.sankaku_user = null;
		this.comment_user = null;
	}

	//ゲッターセッターのプログラム
	public String getMaru_user() {
		return maru_user;
	}

	public void setMaru_user(String maru_user) {
		this.maru_user = maru_user;
	}

	public String getBatsu_user() {
		return batsu_user;
	}

	public void setBatsu_user(String batsu_user) {
		this.batsu_user = batsu_user;
	}

	public String getSankaku_user() {
		return sankaku_user;
	}

	public void setSankaku_user(String sankaku_user) {
		this.sankaku_user = sankaku_user;
	}

	public String getComment_user() {
		return comment_user;
	}

	public void setComment_user(String comment_user) {
		this.comment_user = comment_user;
	}





}