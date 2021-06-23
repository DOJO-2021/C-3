package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Admin_login;

public class Admin_loginDao {

	// ログインできるならtrueを返す
	public boolean isLoginOK(String admin_name, String admin_pw) {

		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

			// SELECT文を準備する
			String sql = "select count(*) from ADMIN_LOGIN where ADMIN_NAME = ? and ADMIN_PW = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, admin_name);
			pStmt.setString(2, admin_pw);

			// SELECT文を実行し、結果表を取得する(Query:DBに対する処理要求)
			ResultSet rs = pStmt.executeQuery();

			// 管理者IDとパスワードが一致する管理者がいたかどうかをチェックする
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
	public List<Admin_login> select(Admin_login param) {
		Connection conn = null;
		List<Admin_login> signList = new ArrayList<Admin_login>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

			// SQL文を準備する
			String sql = "select * from admin_login WHERE admin_id = ? AND admin_name = ? and admin_pw = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (param.getAdmin_name() != "") {
				pStmt.setString(1,  param.getAdmin_name() );
			}
			else {
				pStmt.setString(1, null);
			}
			if (param.getAdmin_pw() != "") {
				pStmt.setString(2,  param.getAdmin_pw());
			}
			else {
				pStmt.setString(2, null);
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Admin_login sign = new Admin_login(
				rs.getString("admin_name"),
				rs.getString("admin_pw")
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


	// セッションスコープのための処理
	public Admin_login select_session(String admin_name, String admin_pw) {

		Connection conn = null;
		Admin_login result = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");


			// SELECT文を準備する
			String sql = "select admin_id from ADMIN_LOGIN  where  ADMIN_NAME = ? and ADMIN_PW = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, admin_name);
			pStmt.setString(2, admin_pw);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			rs.next();
//			Admin_login test = new Admin_login();
			result = new Admin_login();
			result.setAdmin_id(rs.getInt("admin_id"));
		}

		catch (SQLException e) {
			e.printStackTrace();
			result = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			result = null;
		}

		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					result = null;
				}
			}
		}
		// 結果を返す
		return result;

	}
}
