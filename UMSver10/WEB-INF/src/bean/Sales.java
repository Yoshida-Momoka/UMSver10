package bean;

import java.util.*;

public class Sales {

	// 売上IDを格納する変数
	private int salesid;

	//注文IDを格納する変数
	private int orderid;

	//商品名を格納する変数
	private String productname;

	//購入個数を格納する変数
	private int quantity;

	//合計金額を格納する変数
	private int total;

	//注文日時を格納する変数
	private Date orderdate;

	// 売上日時を格納する変数
	private Date salesdate;

	// アクセサメソッド

	public int getSalesid() {
		return salesid;
	}

	public void setSalesid(int salesid) {
		this.salesid = salesid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total=total;
	}

	public Date getSalesdate() {
		return salesdate;
	}

	public void setSalesdate(Date salesdate) {
		this.salesdate = salesdate;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

}