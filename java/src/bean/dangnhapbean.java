package bean;

public class dangnhapbean {
	private String tendn;
	private String matkhau;
	private boolean quyen;
	public dangnhapbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public dangnhapbean(String tendn, String matkhau, boolean quyen) {
		super();
		this.tendn = tendn;
		this.matkhau = matkhau;
		this.quyen = quyen;
	}
	public String getTendn() {
		return tendn;
	}
	public void setTendn(String tendn) {
		this.tendn = tendn;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public boolean isQuyen() {
		return quyen;
	}
	public void setQuyen(boolean quyen) {
		this.quyen = quyen;
	}
	
}
