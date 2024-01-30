package dao;

import java.util.*;
import java.sql.*;

import bean.User;

public class UserDAO {

	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/kandauniformdb";
	private static String USER = "root";
	private static String PASS = "root123";

	/**
	 * DBに接続するメソッド
	 *
	 * @return
	 */
	public Connection getConnection() {

		try {

			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASS);

			return con;

		} catch (Exception e) {

			throw new IllegalStateException(e);

		}

	}

	/**
	 * ユーザーIDとパスワードからユーザーデータを取得する
	 *
	 * @param userid
	 * @param password
	 * @return user、あるいはnull
	 */
	public User selectByUser(String userid, String password) {

		Connection con = null;
		Statement smt = null;

		// SQL文作成
		String sql = "SELECT * FROM userinfo WHERE userid = '" + userid + "' AND password = '" + password + "'";

		User user = null;

		try {

			// DB接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// データが取得出来た場合
			if (rs.next()) {

				user = new User();

				// userオブジェクトにデータ格納
				user.setUserid(rs.getString("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAuthority(rs.getString("authority"));
				user.setAddress(rs.getString("address"));
				user.setMailaddress(rs.getString("mailaddress"));

			}

			// データが取得出来たらそのデータを、出来なかったらnullを返す
			return user;

		} catch (Exception e) {

			throw new IllegalStateException(e);

		} finally {

			/* DBとの接続切断 */
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

	/**
	 * ユーザーIDからユーザーデータを取得する
	 *
	 * @param userid
	 * @return
	 */
	public User selectByUser(String userid) {

		Connection con = null;
		Statement smt = null;

		// SQL文作成
		String sql = "SELECT * FROM userinfo WHERE userid = '" + userid + "'";

		User user = null;

		try {

			// DB接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// データが取得出来た場合
			if (rs.next()) {

				user = new User();

				// userオブジェクトにデータ格納
				user.setUserid(rs.getString("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAuthority(rs.getString("authority"));
				user.setAddress(rs.getString("address"));
				user.setMailaddress(rs.getString("mailaddress"));

			}

			// データが取得出来たらそのデータを、出来なかったらnullを返す
			return user;

		} catch (Exception e) {

			throw new IllegalStateException(e);

		} finally {

			/* DBとの接続切断 */
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

	/**
	 * 登録したいデータを格納したUserオブジェクトを取得して、
	 * そこからユーザーIDが等しいデータの 情報を変更する
	 *
	 * @param userid
	 * @param mailaddress
	 * @param address
	 */
	public void insertByuserid(User user) {

		Connection con = null;
		Statement smt = null;

		// SQL文作成
		String sql = "UPDATE userinfo SET username = '" + user.getUsername() + "' , mailaddress = '" + user.getMailaddress()
				+ "', address = '" + user.getAddress() + "' WHERE userid = '" + user.getUserid() + "'";

		try {

			con = getConnection();
			smt = con.createStatement();

			int cnt = smt.executeUpdate(sql);

		} catch (Exception e) {

			throw new IllegalStateException(e);

		} finally {

			/* DBとの接続切断 */
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
