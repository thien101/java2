package bean;

public class chitietxnhdbean {
	private long mahd;
	private String tenkh;
	private String tensp;
	private long gia;
	private long soluong;
	private long thanhtien;
	private boolean damua;
	public chitietxnhdbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public chitietxnhdbean(long mahd, String tenkh, String tensp, long gia, long soluong, long thanhtien,
			boolean damua) {
		super();
		this.mahd = mahd;
		this.tenkh = tenkh;
		this.tensp = tensp;
		this.gia = gia;
		this.soluong = soluong;
		this.thanhtien = thanhtien;
		this.damua = damua;
	}

	public long getMahd() {
		return mahd;
	}
	public void setMahd(long mahd) {
		this.mahd = mahd;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
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
