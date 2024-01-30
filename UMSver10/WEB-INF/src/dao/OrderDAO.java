package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Order;

public class OrderDAO {

	private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/kandauniformdb";
	private static final String USER = "root";
	private static final String PASSWD = "root123";

	// DBに接続を行うメソッド
	private static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(RDB_DRIVE);
			con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * 引数の購入データを基にDBのorderinfoテーブルに新規登録処理を行うメソッド定義
	 *
	 * @return なし
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public void insert(Order order) {
		Connection con = null;
		Statement smt = null;
		int count = 0;

		try {
			con = getConnection();
			smt = con.createStatement();

			String sql = "INSERT INTO orderinfo VALUES (null, '" + order.getUserid() + "', '" + order.getProductid()
					+ "', '" + order.getPaymentStatus() + "', '" + order.getShippingStatus() + "', "
					+ order.getQuantity() + ", '" + order.getTotal() + "', CURRENT_TIMESTAMP)";

			count = smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

}
