package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.s_question;

public class s_questionDao {

	//引数questionで質問項目を指定する
	public List<s_question> select(s_question question) {
		Connection conn = null;
		List<s_question> questionList = new ArrayList<s_question>();

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa",
				"sa");

		for (String question_item : question) {

			// SELECT文を準備する
			String sql = "select * from s_question";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(0, question_item);

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
