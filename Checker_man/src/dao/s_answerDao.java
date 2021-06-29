package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.s_answer;
import model.s_answerdata;

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
			String sql = "select * from s_answer WHERE user_id = ? and date = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getUser_id() != 0) {
				pStmt.setInt(1, param.getUser_id());
			} else {
				pStmt.setInt(1, 0);
			}

			if (param.getDate() != "") {
				pStmt.setString(2,  param.getDate() );
			}
			else {
				pStmt.setString(2, "");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				s_answer answer = new s_answer(
						rs.getInt("question_id"),
						rs.getInt("answer"),
						rs.getInt("user_id"),
						rs.getString("date"));
				answerList.add(answer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			answerList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			answerList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
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
		Connection conn = null; //デフォルトで「回答がありません」→回答があったらtrueに書き変わる
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
			//answer.getUser_id() →　LoginUser
			if (answer.getDate() != null) {
				pStmt.setString(4, answer.getDate());
			} else {
				pStmt.setString(4, null);
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
		return result;
	}

	// 管理者トップページの現在の受講者健康状態で使うデータベース処理
		public s_answerdata select_answerdata(s_answerdata param) {

			Connection conn = null;
			s_answerdata result = null;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

		//○の人数表示
				// SQL文を準備する
				String sql = "select (select sum(answer) from s_answer WHERE  user_id = ? and date = CURDATE()) as sum "
						+ ",(select count(*) from s_answer WHERE  user_id = ? and answer = '5' and date = CURDATE()) as countfive "
						+ ",(select count(*) from s_answer WHERE  user_id = ? and answer = '4' and date = CURDATE()) as countfour "
						+ "from s_answer group by CURDATE()";

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getUser_id() != 0) {
					pStmt.setInt(1, param.getUser_id());
				}
				else {
					pStmt.setInt(1, 0);
				}

				if (param.getUser_id() != 0) {
					pStmt.setInt(2, param.getUser_id());
				}
				else {
					pStmt.setInt(2, 0);
				}

				if (param.getUser_id() != 0) {
					pStmt.setInt(3, param.getUser_id());
				}
				else {
					pStmt.setInt(3, 0);
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				rs.next();
				result = new s_answerdata ();
				result.setSum(rs.getInt("sum"));
				result.setCountfive(rs.getInt("countfive"));
				result.setCountfour(rs.getInt("countfour"));

			}

			catch (SQLException e) {
				e.printStackTrace();
				result = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				result = null;
			}

			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						result = null;
					}
				}
			}
			// 結果を返す
			return result;
		}

		// 引数answerで指定されたレコードを登録し、成功したらtrueを返す
		public boolean select_answer(s_answer param) {
			Connection conn = null; //デフォルトで「回答がありません」→回答があったらtrueに書き変わる
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

				// SQL文を準備する
				String sql = "SELECT count(*) from s_answer WHERE user_id=? and date = CURDATE()";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getUser_id() != 0) {
					pStmt.setInt(1, param.getUser_id());
				} else {
					pStmt.setInt(1, 0);
				}

				ResultSet rs = pStmt.executeQuery();
				rs.next();
				int num = rs.getInt("count(*)");

				// SQL文を実行する
				if (num == 0) {
					result = true;
				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
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
			return result;
		}

}