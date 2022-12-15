package bean;

public class khachhangbean {
	private long makh;
	private String tendn;
	private String pass;
	private String tenkh;
	private String diachi;
	private String sdt;
	private String email;
	public khachhangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public khachhangbean(long makh, String tendn, String pass, String tenkh, String diachi, String sdt, String email) {
		super();
		this.makh = makh;
		this.tendn = tendn;
		this.pass = pass;
		this.tenkh = tenkh;
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
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
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
