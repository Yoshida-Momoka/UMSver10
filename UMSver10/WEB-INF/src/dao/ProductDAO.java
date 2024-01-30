/*
 *プログラム名  ：ユニフォーム発注管理システム
 *プログラム説明：商品管理に関するDAOクラス
 *作成者        ：小倉悠聖
 *作成日        ：2024年1月29日～1月30日
 *変更履歴      ：無し
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Product;

public class ProductDAO {

	//定数宣言
	private static String RDB_DRIVE="com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost/kandauniformdb";
	private static String USER="root";
	private static String PASSWD="root123";

	/**
	 * DB接続
	 * @param なし
	 * @throws Exception
	 */
	private static Connection getConnection(){
		try{
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		}catch(Exception e){
			throw new IllegalStateException(e);
		}
	}

	/**
	 * @メソッド名	：selectAll
	 * @説明		：全ての商品を取得する
	 * @args		：なし
	 * @return		：List型の配列
	 */
	public ArrayList<Product> selectAll()
	{
		//配列宣言
		ArrayList<Product> list = new ArrayList<Product>();
		//SQL文
		String sql = "SELECT * FROM productinfo ORDER BY productid";

		Connection con = null;
		Statement  smt = null;
		try{
			//DBに接続
			con = ProductDAO.getConnection();
			smt = con.createStatement();

			//SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			//検索結果を配列に格納
			while(rs.next()){
				Product products = new Product();
				products.setProductid(rs.getInt("productid"));
				products.setProductname(rs.getString("productname"));
				products.setPrice(rs.getInt("price"));
				products.setStock(rs.getInt("stock"));

				list.add(products);
			}

		}catch(SQLException e){
			System.out.println("Errorが発生しました！\n"+e);
			throw new IllegalStateException(e);
		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			//リソースの開放
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){}
			}
			if(con != null){
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return list;

	}

	/**
	 * @メソッド名	 ：selectByIsbn
	 * @説明		 ：商品IDから商品を取得する
	 * @param 	productid ：productid
	 * @return	product：Product型のオブジェクト
	 */
	public Product selectByIsbn(int isbn)
	{
		//SQL文
		String sql = "SELECT * FROM productinfo WHERE productid ='" + isbn + "'";

		//オブジェクト宣言
		Product product = new Product();

		//変数宣言
		Connection con = null;
		Statement  smt = null;

		try{
			//DBに接続
			con = ProductDAO.getConnection();
			smt = con.createStatement();

			//SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			while(rs.next()){
				//検索結果を配列に格納
				product.setProductid(rs.getInt("productid"));
				product.setProductname(rs.getString("productname"));
				product.setPrice(rs.getInt("price"));
				product.setStock(rs.getInt("stock"));
			}
		}catch(SQLException e){
			System.out.println("Errorが発生しました！\n"+e);
			throw new IllegalStateException(e);
		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			//リソースの開放
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){}
			}
			if(con != null){
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return product;
	}


	/**
	 * @メソッド名	 ：insert
	 * @説明		 ：商品を新規登録する
	 * @param 	product ：オブジェクト(productid,productname,price,stock)
	 * @return	count：更新数
	 */
	/*オプション機能
	public int insert(Product product)
	{
		//SQL文設定
		String sql  = "INSERT INTO productinfo VALUE(";
		       sql += "'" + product.getProductid()  + "',";
		       sql += "'" + product.getProductname() + "',";
		       sql += "'" + product.getPrice() + "',";
		       sql += product.getStock() +")";

		//変数宣言
		Connection con = null;
		Statement  smt = null;
		int		 count = 0;

		try{
			//DBに接続
			con = productDAO.getConnection();
			smt = con.createStatement();

			//SQL文発行
			count = smt.executeUpdate(sql);

		}catch(SQLException e){
			System.out.println("Errorが発生しました！\n"+e);
			throw new IllegalStateException(e);
		}finally{
			//リソースの開放
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){}
			}
			if(con != null){
				try{con.close();}catch(SQLException ignore){}
			}
		}

		return count;
	}
	 */

	/**
	 * @メソッド名	 ：delete
	 * @説明		 ：商品を削除する
	 * @param 	productid ：productid
	 * @return	count：更新数
	 */
	/*オプション機能
	public int delete(int productid)
	{
		//SQL文設定
		String sql  = "DELETE FROM productinfo WHERE";
		       sql += " productid ='" + productid + "'";

		//変数宣言
		Connection con = null;
		Statement  smt = null;
		int		 count = 0;

		try{
			//DBに接続
			con = productDAO.getConnection();
			smt = con.createStatement();

			//SQL文発行
			count = smt.executeUpdate(sql);

		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			//リソースの開放
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){}
			}
			if(con != null){
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return count;
	}
	*/

	/**
	 * @メソッド名		：delete
	 * @説明			：商品を更新する
	 * @param product	：オブジェクト(pruductid,productname,price,stock)
	 * @param oldPuroductid	：変更productid
	 * @return count	：更新数
	 */
	/*オプション機能
	public int update(Product product)
	{
		//SQL文設定
		String sql   = "UPDATE bookinfo SET";
				sql += " productname ='" + product.getProductname() + "',";
				sql += " price ="  + product.getPrice();
				sql += " stock ="  + product.getStock();
				sql += " WHERE productid ='" + product.getProductid() + "'";

		//変数宣言
		Connection con = null;
		Statement  smt = null;
		int		 count = 0;

		try{
			//DBに接続
			con = productDAO.getConnection();
			smt = con.createStatement();

			//SQL文発行
			count = smt.executeUpdate(sql);

		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			//リソースの開放
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){}
			}
			if(con != null){
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return count;
	}
	*/

}
