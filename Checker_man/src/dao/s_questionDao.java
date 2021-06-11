package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class s_questionDao {
	try
	{
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "");

			// SELECT文を準備する
			String sql = "select * from s_question;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, toi1);
			pStmt.setString(2, toi2);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
		}

	finally
	{ //例外があってもなくても、最後にやる共通の処理

		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 結果を返す
	// return loginResult;
}}
