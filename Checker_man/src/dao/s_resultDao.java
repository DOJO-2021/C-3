package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.admin_lastdata;
import model.admin_toppage;
import model.s_result;
import model.user_toppage;

public class s_resultDao {

	// Select文のデータベース処理
		public List<s_result> select(s_result param) {

			Connection conn = null;
			List<s_result> resultList = new ArrayList<s_result>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

				// SQL文を準備する
				String sql = "select result_id, date, icon, user_comment, admin_comment, user_id "
						+ "from s_result WHERE date LIKE ? AND icon LIKE ? AND user_comment LIKE ? "
						+ " AND admin_comment LIKE ? AND user_id LIKE ? ORDER BY result_id ASC , date ASC";

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getDate() != null) {
					pStmt.setString(1, "%" + param.getDate() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}

				if (param.getIcon() != null) {
					pStmt.setString(2, "%" + param.getIcon() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}

				if (param.getUser_comment() != null) {
					pStmt.setString(3, "%" + param.getUser_comment() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}

				if (param.getAdmin_comment() != null) {
					pStmt.setString(4, "%" + param.getAdmin_comment() + "%");
				}
				else {
					pStmt.setString(4, "%");
				}

				if (param.getUser_id() != 0) {
					pStmt.setString(5, "%" + param.getUser_id() + "%");
				}
				else {
					pStmt.setString(5, "%");
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					s_result resultData = new s_result(
					rs.getInt("result_id"),
					rs.getString("date"),
					rs.getString("icon"),
					rs.getString("user_comment"),
					rs.getString("admin_comment"),
					rs.getInt("user_id")
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

	// カレンダーのデータベース処理
		public List<user_toppage> select_calender(user_toppage param) {

			Connection conn = null;
			List<user_toppage> resultList = new ArrayList<user_toppage>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

				// SQL文を準備する
				String sql = "select  icon, date, user_id from s_result WHERE user_id LIKE ? order by date asc";

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getUser_id() != 0) {
					pStmt.setString(1, "%" + param.getUser_id() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					user_toppage resultData = new user_toppage(
					rs.getString("icon"),
					rs.getString("date"),
					rs.getInt("user_id")
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


	// 診断結果の表示のデータベース処理
				public boolean insert(s_result resultdata) {

					Connection conn = null;
					boolean result = false;

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

						// SQL文を準備する
						String sql = "insert into s_result values (null, current_date, ?, ? ,? ,?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						if (resultdata.getIcon() != null) {
							pStmt.setString(1, resultdata.getIcon());
						}
						else {
							pStmt.setString(1, null);
						}

						if (resultdata.getUser_comment() != null) {
							pStmt.setString(2, resultdata.getUser_comment());
						}
						else {
							pStmt.setString(2, null);
						}

						if (resultdata.getAdmin_comment() != null) {
							pStmt.setString(3, resultdata.getAdmin_comment());
						}
						else {
							pStmt.setString(3, null);
						}

						if (resultdata.getUser_id() != 0) {
							pStmt.setInt(4, resultdata.getUser_id());
						}
						else {
							pStmt.setString(4, null);
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

		// 管理者トップページの現在の受講者健康状態で使うデータベース処理
				public admin_toppage select_toppage(admin_toppage param) {

					Connection conn = null;
					admin_toppage result = null;

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

				//○の人数表示
						// SQL文を準備する
						String sql1 = "select count(*) as maru from s_result where icon = 'maru' and date = CURDATE()";

						PreparedStatement pStmt1 = conn.prepareStatement(sql1);

						// SQL文を実行し、結果表を取得する
						ResultSet rs1 = pStmt1.executeQuery();

						// 結果表をコレクションにコピーする
						rs1.next();
						result = new admin_toppage();
						result.setMaru_number(rs1.getInt("maru"));

				   //☓の人数表示
						String sql2 = "select count(*) as batsu from s_result where icon = 'batsu' and date = CURDATE()";
						PreparedStatement pStmt2 = conn.prepareStatement(sql2);
						ResultSet rs2 = pStmt2.executeQuery();
						rs1.next();
						result.setBatsu_number(rs2.getInt("batsu"));

					//△の人数表示
						String sql3 = "select count(*) as sankaku from s_result where icon = 'sankaku' and date = CURDATE()";
						PreparedStatement pStmt3 = conn.prepareStatement(sql3);
						ResultSet rs3 = pStmt3.executeQuery();
						rs3.next();
						result.setSankaku_number(rs3.getInt("sankaku"));

					//コメントした人数表示
						String sql4 = "select count(*) as comment from s_result where user_comment <> '' and date = CURDATE()";
						PreparedStatement pStmt4 = conn.prepareStatement(sql4);
						ResultSet rs4 = pStmt4.executeQuery();
						rs4.next();
						result.setComment_number(rs4.getInt("comment"));

				//○の人表示
//						String sql5 = "select u.user_name from  s_result as s inner join user_login as u on s.user_id = u.user_id  where icon = 'maru' and date = CURDATE()";
//						PreparedStatement pStmt5 = conn.prepareStatement(sql5);
//						ResultSet rs5 = pStmt5.executeQuery();
//						while (rs5.next()) {
//							result.setMaru_list(rs5.getString("u.user_name"));
//						}
						//rs5.next();
						//result.setMaru_list(rs5.getString("u.user_name"));

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
						String sql = "select icon, count(icon),date from s_result group by icon,date order by date asc";

						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							admin_lastdata resultData = new admin_lastdata(
							rs.getString("icon"),
							rs.getInt("count(icon)"),
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
