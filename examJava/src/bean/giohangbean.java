package bean;

public class giohangbean {
	private long masp;
	private String tensp;
	private long gia, slmua;
	private String anh;
	private long thanhtien;
	private boolean damua;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(long masp, String tensp, long gia, long slmua, String anh, boolean damua) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.gia = gia;
		this.slmua = slmua;
		this.anh = anh;
		this.thanhtien = this.gia*this.slmua;
		this.damua = damua;
	}
	public long getMasp() {
		return masp;
	}
	public void setMasp(long masp) {
		this.masp = masp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getSlmua() {
		return slmua;
	}
	public void setSlmua(long slmua) {
		this.slmua = slmua;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public long getThanhtien() {
		return this.gia*this.slmua;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	
	
}
