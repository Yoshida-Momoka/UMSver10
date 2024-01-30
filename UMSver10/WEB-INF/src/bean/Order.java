package bean;

public class Order {

	private int orderid; //注文ID
	private String userid; //ユーザーID
	private String productid; //商品ID
	private String paymentStatus; //入金ステータス (0: 入金済 1:未入金)
	private String shippingStatus; //発送ステータス (0: 発送済 1:発送準備中 2:未)
	private int quantity; //購入個数
	private String total; //合計金額
	private String orderdate; //注文日時

	// コンストラクタ
	public Order() {
		this.orderid = 0;
		this.userid = null;
		this.productid = null;
		this.paymentStatus = null;
		this.shippingStatus = null;
		this.quantity = 0;
		this.total = null;
		this.orderdate = null;
	}

	//ゲッター・セッターメソッド

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

}