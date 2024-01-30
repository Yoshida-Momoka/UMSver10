package bean;

public class User {

	/*---フィールド変数---*/

	private String userid;
	private String username;
	private String authority;
	private String password;
	private String mailaddress;
	private String address;

	/*---コンストラクタ---*/

	public User() {

		this.userid = null;
		this.username = null;
		this.authority = null;
		this.password = null;
		this.mailaddress = null;
		this.address = null;

	}

	/*---アクセサメソッド---*/

	//setterメソッド

	public void setUserid(String userid) {

		this.userid = userid;

	}

	public void setUsername(String username) {

		this.username = username;

	}
	
	public void setPassword(String password) {

		this.password = password;

	}
	
	public void setAuthority(String authority) {
		
		this.authority = authority;
		
	}

	public void setAddress(String address) {
		
		this.address = address;
		
	}

	public void setMailaddress(String mailaddress) {

		this.mailaddress = mailaddress;

	}

	//getterメソッド

	public String getUserid() {

		return userid;

	}

	public String getUsername() {

		return username;

	}

	public String getPassword() {

		return password;

	}

	public String getAuthority() {

		return authority;
	}

	public String getMailaddress() {

		return mailaddress;

	}

	public String getAddress() {

		return address;
	}

}
