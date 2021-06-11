package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
