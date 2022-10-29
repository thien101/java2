package bean;

public class giohangbean {
	String masach;
	String tensach;
	long giasach, soluong;
	String anh;
	long thanhtien;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String masach, String tensach, long giasach, long soluong, String anh) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.giasach = giasach;
		this.soluong = soluong;
		this.anh = anh;
		this.thanhtien = soluong*giasach;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public long getGiasach() {
		return giasach;
	}
	public void setGiasach(long giasach) {
		this.giasach = giasach;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public long getThanhtien() {
		return soluong*giasach;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	
	
}