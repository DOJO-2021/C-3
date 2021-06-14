package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class s_questionDao {

	{

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		Connection conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

		for (String question_item : question) {

			// SELECT文を準備する
			String sql = "select * from s_question";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, question);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
