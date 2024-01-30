package dao;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Sales;

public class SalesDAO {

	/**
	 * JDBCドライバ内部のDriverクラスパス
	 */
	private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";
	/**
	 * 接続するMySQLデータベースパス
	 */
	private static final String URL = "jdbc:mysql://localhost/kandauniformdb";
	/**
	 * データベースのユーザー名
	 */
	private static final String USER = "root";
	/**
	 * データベースのパスワード
	 */
	private static final String PASSWD = "root123";

	/**
	 * フィールド変数の情報を基に、DB接続をおこなうメソッド
	 *
	 * @return データベース接続情報
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	// orderinfoとsalesinfoテーブルを結合して月ごとの売り上げ情報を取得するメソッド
	public ArrayList<Sales> selectBySales(String month) {

		//配列宣言
		ArrayList<Sales> list = new ArrayList<Sales>();

		Statement smt = null;
		Connection con = null;


		try{
			//DBに接続
			con = SalesDAO.getConnection();
			smt = con.createStatement();

			String date;

			if(month.length()==1){
				date = "-0"+month;
			}else{
				date ="-"+month;
			}


			//salesinfoテーブルとproductinfoテーブルを結合して売上情報を取り出すSQL文を作成する
			String sql =  "SELECT b.salesid, productname, total, quantity, orderdate" +
					 "FROM orderinfo o inner join productinfo b ON o.orderid=b.orderid "+
					 "WHERE salesdate LIKE '"+date+"%' GROUP BY b. ORDER BY b.orderid";

			//SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			//検索結果を配列に格納
			while(rs.next()){
				Sales sales = new Sales();
				sales.setSalesid(rs.getInt("salesid"));
				sales.setOrderid(rs.getInt("orderid"));
				sales.setProductname(rs.getString("productname"));
				sales.setTotal(rs.getInt("total"));
				sales.setQuantity(rs.getInt("quantity"));
				sales.setOrderdate(rs.getDate("orderdate"));
				sales.setSalesdate(rs.getDate("salesdate"));
				list.add(sales);
			}
		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){}
			}
			if(!con.equals("")){
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return list;
	}
}
