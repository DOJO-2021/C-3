package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.admin_lastdata;
import model.s_result;

public class a_lastdataDao {


	// 管理者の過去のデータにアイコンを入れる処理
	public boolean insert_lastdata(s_result resultdata) {

		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

			// SQL文を準備する
			String sql = "insert into a_lastdata (maru_icon, batsu_icon, sankaku_icon,date) "
					+ "values (select icon from s_result where icon = 'maru' and date = CURDATE() and user_id = '?'"
					+ ",select icon from s_result where icon = 'batsu' and date = CURDATE() and user_id = '?'"
					+ ",select icon from s_result where icon = 'sankaku' and date = CURDATE() and user_id = '?'"
					+ ",current_date)";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (resultdata.getUser_id() != 0) {
				pStmt.setInt(1, resultdata.getUser_id());
			}
			else {
				pStmt.setInt(1, 0);
			}

			if (resultdata.getUser_id() != 0) {
				pStmt.setInt(2, resultdata.getUser_id());
			}
			else {
				pStmt.setInt(2, 0);
			}

			if (resultdata.getUser_id() != 0) {
				pStmt.setInt(3, resultdata.getUser_id());
			}
			else {
				pStmt.setInt(3, 0);
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

	// 管理者の過去のデータの表で使うデータベース処理
				public List<admin_lastdata> select_lastdata(admin_lastdata param) {

					Connection conn = null;
					List<admin_lastdata> resultList = new ArrayList<admin_lastdata>();

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

						// SQL文を準備する
						String sql = "select count(maru_icon) as maru, count(batsu_icon) as batsu"
								+ ", count(sankaku_icon) as sankaku, date from a_lastdata"
								+ " group by date order by date asc;";

						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							admin_lastdata resultData = new admin_lastdata(
							rs.getInt("maru"),
							rs.getInt("batsu"),
							rs.getInt("sankaku"),
							rs.getString("date")
							);
							resultList.add(resultData);
						}
					}

					catch (SQLException e) {
						e.printStackTrace();
						resultList = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						resultList = null;
					}

					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								resultList = null;
							}
						}
					}
					// 結果を返す
					return resultList;
				}


}
