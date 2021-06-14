package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.s_question;

public class s_questionDao {

	// 引数questionで質問項目を取ってくる
	public void select(s_question param) {
		Connection conn = null;
		List<s_question> questionList = new ArrayList<s_question>();

		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		// データベースに接続する
		try {
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa",
					"sa");
		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		for (@SuppressWarnings("unused")
		s_question question_item : questionList) {

			// SELECT文を準備する
			String sql = "select * from s_question";
			PreparedStatement pStmt = null;
			try {
				pStmt = conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			// SQL文を完成させる
			if (param.getQuestion_id() != 0) {
				try {
					pStmt.setString(1, "%" + param.getQuestion_id() + "%");
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			} else {
				try {
					pStmt.setString(1, "%");
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if (param.getQuestion() != null) {
				try {
					pStmt.setString(2, "%" + param.getQuestion() + "%");
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			} else {
				try {
					pStmt.setString(2, "%");
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}

			// SELECT文を実行し、結果表を取得する
			try {
				pStmt.executeQuery();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
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