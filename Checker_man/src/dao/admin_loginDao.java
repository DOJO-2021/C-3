package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class admin_loginDao {

	// ログインできるならtrueを返す
	public boolean isLoginOK(int id, String name, String pw) {

		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

			// SELECT文を準備する
			String sql = "select count(*) from admin_login where admin_ID = ? and admin_NAME = ? and admin_PW = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			pStmt.setString(2, name);
			pStmt.setString(3, pw);

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
}
