package bean;

public class cthoadonbean {
	private long macthd, mahd, masp, soluong, thanhtien;
	private boolean damua;
	public cthoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cthoadonbean(long macthd, long mahd, long masp, long soluong, long thanhtien, boolean damua) {
		super();
		this.macthd = macthd;
		this.mahd = mahd;
		this.masp = masp;
		this.soluong = soluong;
		this.thanhtien = thanhtien;
		this.damua = damua;
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
	public long getThanhtien() {
		return thanhtien;
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
