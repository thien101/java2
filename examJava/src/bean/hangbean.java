package bean;

public class hangbean {
	private String mahang;
	private String tenhang;
	public hangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hangbean(String mahang, String tenhang) {
		super();
		this.mahang = mahang;
		this.tenhang = tenhang;
	}
	public String getMahang() {
		return mahang;
	}
	public void setMahang(String mahang) {
		this.mahang = mahang;
	}
	public String getTenhang() {
		return tenhang;
	}
	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}
	
}
