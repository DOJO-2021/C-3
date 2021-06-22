package model;
import java.io.Serializable;

public class admin_toppagelist implements Serializable {

	private String maru_list ; //　○の人の表示
	private String batsu_list; //　○の人の表示
	private String sankaku_list; //　○の人の表示
	private String comment_list; //　○の人の表示

	private int maru_id;
	private int batsu_id;
	private int sankaku_id;
	private int comment_id;

	//引数があるコントラスタ
	public admin_toppagelist(
			String maru_list,String batsu_list,String sankaku_list, String comment_list
			,int maru_id,int batsu_id,int sankaku_id ,int comment_id) {
		super();
		this.maru_list = maru_list;
		this.batsu_list = batsu_list;
		this.sankaku_list = sankaku_list;
		this.comment_list = comment_list;
		this.maru_id = maru_id;
		this.batsu_id = batsu_id;
		this.sankaku_id = sankaku_id;
		this.comment_id = comment_id;
	}

	//引数がないコントラスタ（デフォルトコントラスタ）
	public admin_toppagelist() {
		super();

		this.maru_list = null;
		this.batsu_list =null;
		this.sankaku_list =null;
		this.comment_list = null;
		this.maru_id =  0;
		this.batsu_id = 0;
		this.sankaku_id = 0;
		this.comment_id = 0;

	}

	//ゲッターセッターのプログラム
	public String getMaru_list() {
		return maru_list;
	}

	public void setMaru_list(String maru_list) {
		this.maru_list = maru_list;
	}

	public String getBatsu_list() {
		return batsu_list;
	}

	public void setBatsu_list(String batsu_list) {
		this.batsu_list = batsu_list;
	}

	public String getSankaku_list() {
		return sankaku_list;
	}

	public void setSankaku_list(String sankaku_list) {
		this.sankaku_list = sankaku_list;
	}

	public String getComment_list() {
		return comment_list;
	}

	public void setComment_list(String comment_list) {
		this.comment_list = comment_list;
	}

	public int getMaru_id() {
		return maru_id;
	}

	public void setMaru_id(int maru_id) {
		this.maru_id = maru_id;
	}

	public int getBatsu_id() {
		return batsu_id;
	}

	public void setBatsu_id(int batsu_id) {
		this.batsu_id = batsu_id;
	}

	public int getSankaku_id() {
		return sankaku_id;
	}

	public void setSankaku_id(int sankaku_id) {
		this.sankaku_id = sankaku_id;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}




}