package bean;

/*
 *プログラム名  ：ユニフォーム発注管理システム
 *プログラム説明：商品管理に必要なSET＆GET関数を提供するクラス
 *作成者        ：小倉悠聖
 *作成日        ：2024年1月29日
 *変更履歴      ：無し
*/
public class Product {
	private int productid;		// 商品ID
	private String productname;	// 商品名
	private int price;		// 価格
	private int stock;		// 在庫数

	//コンストラクタ
	public Product() {
		this.productid = 0;
		this.productname = null;
		this.price = 0;
		this.stock = 0;
	}


	/* GETメソッド */
	public int getProductid() {
		return productid;
	}
	public String getProductname() {
		return productname;
	}
	public int getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}


	/* SETメソッド */
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}



}
