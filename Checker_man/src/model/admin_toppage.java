package model;
import java.io.Serializable;
import java.util.ArrayList;

public class admin_toppage implements Serializable {

	private int maru_number; //　○の人の数
	private int batsu_number; //　☓の人の数
	private int sankaku_number; //　△の人の数
	private int comment_number; // コメントの数

	private ArrayList<String> maru_list ; //　○の人の表示
	private ArrayList<String> batsu_list; //　○の人の表示
	private ArrayList<String> sankaku_list; //　○の人の表示
	private ArrayList<String> comment_list; //　○の人の表示

	private ArrayList<Integer> maru_id;
	private ArrayList<Integer> batsu_id;
	private ArrayList<Integer> sankaku_id;
	private ArrayList<Integer> comment_id;

	//引数があるコントラスタ
	public admin_toppage(int maru_number, int batsu_number, int sankaku_number, int comment_number
			,ArrayList<String> maru_list,ArrayList<String> batsu_list,ArrayList<String> sankaku_list,ArrayList<String> comment_list
			,ArrayList<Integer> maru_id,ArrayList<Integer> batsu_id,ArrayList<Integer> sankaku_id ,ArrayList<Integer> comment_id) {
		super();
		this.maru_number = maru_number;
		this.batsu_number = batsu_number;
		this.sankaku_number = sankaku_number;
		this.comment_number = comment_number;
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
	public admin_toppage() {
		super();
		this.maru_number = 0;
		this.batsu_number = 0;
		this.sankaku_number = 0;
		this.comment_number = 0;
		this.maru_list = new ArrayList<String>();
		this.batsu_list =new ArrayList<String>();
		this.sankaku_list =new ArrayList<String>();
		this.comment_list =new ArrayList<String>();
		this.maru_id =  new ArrayList<Integer>();
		this.batsu_id = new ArrayList<Integer>();
		this.sankaku_id = new ArrayList<Integer>();
		this.comment_id = new ArrayList<Integer>();

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

	public ArrayList<String> getMaru_list() {
		return maru_list;
	}

	public void setMaru_list(String maru_list) {
		 this.maru_list.add(maru_list);
	}

	public ArrayList<String> getBatsu_list() {
		return batsu_list;
	}

	public void setBatsu_list(String batsu_list) {
		this.batsu_list.add(batsu_list);

	}

	public ArrayList<String> getSankaku_list() {
		return sankaku_list;
	}

	public void setSankaku_list(String sankaku_list) {
		this.sankaku_list.add(sankaku_list);
	}

	public ArrayList<String> getComment_list() {
		return comment_list;
	}

	public void setComment_list(String comment_list) {
		this.comment_list.add(comment_list);
	}

	public ArrayList<Integer> getMaru_id() {
		return maru_id;
	}

	public void setMaru_id(int maru_id) {
		this.maru_id.add(maru_id);
	}

	public ArrayList<Integer> getBatsu_id() {
		return batsu_id;
	}

	public void setBatsu_id(int batsu_id) {
		this.batsu_id.add(batsu_id) ;
	}

	public ArrayList<Integer> getSankaku_id() {
		return sankaku_id;
	}

	public void setSankaku_id(int sankaku_id) {
		this.sankaku_id.add(sankaku_id) ;
	}

	public ArrayList<Integer> getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id.add(comment_id);
	}



}