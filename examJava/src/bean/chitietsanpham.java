package bean;

public class chitietsanpham {
	private long macthd, mahd, masp, soluong, gia;
	private boolean damua;
	String tensp;
	public chitietsanpham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public chitietsanpham(long macthd, long mahd, long masp, long soluong, long gia, boolean damua, String tensp) {
		super();
		this.macthd = macthd;
		this.mahd = mahd;
		this.masp = masp;
		this.soluong = soluong;
		this.gia = gia;
		this.damua = damua;
		this.tensp = tensp;
	}
	public long getMacthd() {
		return macthd;
	}
	public void setMacthd(long macthd) {
		this.macthd = macthd;
	}
	public long getMahd() {
		return mahd;
	}
	public void setMahd(long mahd) {
		this.mahd = mahd;
	}
	public long getMasp() {
		return masp;
	}
	public void setMasp(long masp) {
		this.masp = masp;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	
}
