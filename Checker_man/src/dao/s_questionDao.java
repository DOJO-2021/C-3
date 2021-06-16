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

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa",
					"sa");

			// SELECT文を準備する
			String sql = "select * from s_question";
			PreparedStatement pStmt = null;
			pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				s_question question = new s_question(
						rs.getInt("question_id"),
						rs.getString("question"));
				questionList.add(question);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			questionList = null;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			questionList = null;

		} finally {
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
		return questionList;
	}
}