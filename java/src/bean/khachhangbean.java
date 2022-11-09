package bean;

public class khachhangbean {
	long makh;
	String tendn;
	String pass;
	String hoten;
	String diachi;
	String sdt;
	String email;
	public khachhangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public khachhangbean(long makh, String tendn, String pass, String hoten, String diachi, String sdt, String email) {
		super();
		this.makh = makh;
		this.tendn = tendn;
		this.pass = pass;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public String getTendn() {
		return tendn;
	}
	public void setTendn(String tendn) {
		this.tendn = tendn;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
