package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.s_answer;

public class s_answerDao {

	//引数paramで検索項目を指定し、検索結果のリストを返す
	public List<s_answer> select(s_answer param) {
		Connection conn = null;
		List<s_answer> answerList = new ArrayList<s_answer>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");


			// SQL文を準備する
			String sql = "select * from s_answer WHERE question_id LIKE ? AND answer LIKE ? and user_id like ? and date like ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getQuestion_id() != 0) {
				pStmt.setString(1, "%" + param.getQuestion_id() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getAnswer() != 0) {
				pStmt.setString(2, "%" + param.getAnswer() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getUser_id() != 0) {
				pStmt.setString(3, "%" + param.getUser_id() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getDate() != "") {
				pStmt.setString(4, "%" + param.getDate() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				s_answer answer = new s_answer(
				rs.getInt("question_id"),
				rs.getInt("answer"),
				rs.getInt("user_id"),
				rs.getString("date")
				);
				answerList.add(answer);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			answerList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			answerList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					answerList = null;
				}
			}
		}

		// 結果を返す
		return answerList;
	}


	// 引数answerで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(s_answer answer) {
		Connection conn = null;		//デフォルトで「回答がありません」→回答があったらtrueに書き変わる
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

			// SQL文を準備する
			String sql = "insert into s_answer values (?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる

			pStmt.setInt(1, answer.getQuestion_id());
			pStmt.setInt(2, answer.getAnswer());
			pStmt.setInt(3, answer.getUser_id());

			if (answer.getDate() != null) {
				pStmt.setString(4, answer.getDate());
			}
			else {
				pStmt.setString(4, "null");
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}