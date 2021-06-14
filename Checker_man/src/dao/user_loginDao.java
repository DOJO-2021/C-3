package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.user_login;

public class user_loginDao {

	// ログインできるならtrueを返す
	public boolean isLoginOK(int user_id, String user_name, String user_pw) {

	//引数のないコンストラクタの場合
	//model.user_login usr1 = new model.user_login();
	//usr1.setUserId(id);
	//usr1.setUserName(name);
	//usr1.setPw(pw);

	//引数のあるコンストラクタの場合
	model.user_login usr1 = new model.user_login(user_id,user_name,user_pw);

		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

			// SELECT文を準備する
			String sql = "select count(*) from USER_LOGIN  where USER_ID = ? and USER_NAME = ? and USER_PW = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user_id);
			pStmt.setString(2, user_name);
			pStmt.setString(3, user_pw);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}

		catch (SQLException e) {
			e.printStackTrace(); //例外情報を表示
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}

		finally { //例外があってもなくても、最後にやる共通の処理

			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}

	//引数paramで検索項目を指定し、検索結果のリストを返す
	public List<user_login> select(user_login param) {
		Connection conn = null;
		List<user_login> signList = new ArrayList<user_login>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

			// SQL文を準備する
			String sql = "select * from user_login WHERE user_id LIKE ? AND user_name LIKE ? and user_pw like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getUser_id() != 0) {
				pStmt.setString(1, "%" + param.getUser_id() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getUser_name() != "") {
				pStmt.setString(2, "%" + param.getUser_name() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getUser_pw() != "") {
				pStmt.setString(3, "%" + param.getUser_pw() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				user_login sign = new user_login(
				rs.getInt("question_id"),
				rs.getString("usert_name"),
				rs.getString("user_pw")
				);
				signList.add(sign);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			signList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			signList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					signList = null;
				}
			}
		}

		// 結果を返す
		return signList;
	}

	// 引数new_userで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(user_login sign) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

			// SQL文を準備する
			String sql = "insert into user_login values (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる

			pStmt.setInt(1, sign.getUser_id());

			if (sign.getUser_name() != null) {
				pStmt.setString(2, sign.getUser_name());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (sign.getUser_pw() != null) {
				pStmt.setString(3, sign.getUser_pw());
			}
			else {
				pStmt.setString(3, "null");
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}
