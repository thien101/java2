package bean;

public class danhsachxnbean {
	private long mahd, slm, gia, thanhtien;
	private String tensach;
	private boolean damua;
	public danhsachxnbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public danhsachxnbean(long mahd, long slm, long gia, long thanhtien, String tensach, boolean damua) {
		super();
		this.mahd = mahd;
		this.slm = slm;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.tensach = tensach;
		this.damua = damua;
	}
	public long getMahd() {
		return mahd;
	}
	public void setMahd(long mahd) {
		this.mahd = mahd;
	}
	public long getSlm() {
		return slm;
	}
	public void setSlm(long slm) {
		this.slm = slm;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	
}
