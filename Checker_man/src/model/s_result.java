package model;
import java.io.Serializable;

public class s_result implements Serializable {
	private int result_id; //診断結果ID
	private String date;   //日付
	private String icon;   //アイコン
	private String user_comment; //受講者コメント
	private String admin_comment; //管理者コメント
	private int user_id; //ユーザーID

	//引数があるコントラスタ
	public s_result(int result_id, String date, String icon,
			String user_comment, String admin_comment, int user_id) {
		super();
		this.result_id = result_id;
		this.date = date;
		this.icon = icon;
		this.user_comment = user_comment;
		this.admin_comment = admin_comment;
		this.user_id = user_id;
	}

	//引数がないコントラスタ（デフォルトコントラスタ）
	public s_result() {
		super();
		this.result_id = 0;
		this.date = "";
		this.icon = "";
		this.user_comment = "";
		this.admin_comment = "";
		this.user_id = 0;
	}

	//ゲッターセッターのプログラム
	public int getResult_id() {
		return result_id;
	}

	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	//setIcon_path()ではなく、getIcon_path()
	public String getIcon_path() {
		if(this.icon.equals("maru")) {
			return "健康的な生活を送れています。このまま継続してください。";
		}else if(this.icon.equals("sankaku")) {
			return "あまり健康とは言えません。規則正しい生活を送るよう心掛けましょう。";
		}else {
			return "健康的とは言えません。生活習慣を見直しましょう。";
		}
	}


	public String getUser_comment() {
		return user_comment;
	}

	public void setUser_comment(String user_comment) {
		this.user_comment = user_comment;
	}

	public String getAdmin_comment() {
		return admin_comment;
	}

	public void setAdmin_comment(String admin_comment) {
		this.admin_comment = admin_comment;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



}

