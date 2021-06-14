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

	// 引数questionで質問項目を取ってくる
	public List<s_question> select(s_question param) {
		Connection conn = null;
		List<s_question> questionList = new ArrayList<s_question>();

		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa",
				"sa");

		for (String question_item : questionList) {

			// SELECT文を準備する
			String sql = "select * from s_question";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, question_item);

			// SQL文を完成させる
			if (param.getQuestion_id() != 0) {
				pStmt.setString(1, "%" + param.getQuestion_id() + "%");
			} else {
				pStmt.setString(1, "%");
			}
			if (param.getQuestion() != null) {
				pStmt.setString(2, "%" + param.getQuestion() + "%");
			} else {
				pStmt.setString(2, "%");
			}

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
		}

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