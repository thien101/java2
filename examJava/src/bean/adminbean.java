package bean;

public class adminbean {
	private int maAd;
	private String tendn;
	private String pass;
	private int quyen;
	public adminbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public adminbean(int maAd, String tendn, String pass, int quyen) {
		super();
		this.maAd = maAd;
		this.tendn = tendn;
		this.pass = pass;
		this.quyen = quyen;
	}
	public int getMaAd() {
		return maAd;
	}
	public void setMaAd(int maAd) {
		this.maAd = maAd;
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
	public int getQuyen() {
		return quyen;
	}
	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	
}
