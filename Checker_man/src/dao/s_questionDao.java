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

	// 引数paramで質問項目を取ってくる
	public List<s_question> select(s_question param) throws SQLException {
		Connection conn = null;
		List<s_question> questionList = new ArrayList<s_question>();

		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}

		// データベースに接続する
		try {
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa",
					"sa");
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		// SELECT文を準備する
		String sql = "select * from s_question";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		try {
			while (rs.next()) {
				s_question question = new s_question(
						rs.getInt("question_id"),
						rs.getString("question"));
				questionList.add(question);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return questionList;
	}
}