package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.s_result;

public class s_resultDao {

	// 引数resultで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(s_result resultdata) {

			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-3/database", "sa", "sa");

				// SQL文を準備する
				String sql = "insert into BC values (null, ?, ?, ? ,? ,? ,? ,? ,? ,? ,current_date)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getCompany() != null) {
					pStmt.setString(1, card.getCompany());
				}
				else {
					pStmt.setString(1, null);
				}

				if (card.getDepart() != null) {
					pStmt.setString(2, card.getDepart());
				}
				else {
					pStmt.setString(2, null);
				}

				if (card.getName() != null) {
					pStmt.setString(3, card.getName());
				}
				else {
					pStmt.setString(3, null);
				}

				if (card.getZipcode() != null) {
					pStmt.setString(4, card.getZipcode());
				}
				else {
					pStmt.setString(4, null);
				}

				if (card.getAddress() != null) {
					pStmt.setString(5, card.getAddress());
				}
				else {
					pStmt.setString(5, null);
				}

				if (card.getPhone() != null) {
					pStmt.setString(6, card.getPhone());
				}
				else {
					pStmt.setString(6, "null");
				}

				if (card.getMail() != null) {
					pStmt.setString(7, card.getMail());
				}
				else {
					pStmt.setString(7, null);
				}

				if (card.getUrl() != null) {
					pStmt.setString(8, card.getUrl());
				}
				else {
					pStmt.setString(8, null);
				}

				if (card.getRemarks() != null) {
					pStmt.setString(9, card.getRemarks());
				}
				else {
					pStmt.setString(9, null);
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
