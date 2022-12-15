package bean;

public class sanphambean {
	private long masp;
	private String tensp;
	private String mahang;
	private long tonkho;
	private long gia;
	private String anh;
	public sanphambean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public sanphambean(long masp, String tensp, String mahang, long tonkho, long gia, String anh) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.mahang = mahang;
		this.tonkho = tonkho;
		this.gia = gia;
		this.anh = anh;
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
	public long getTonkho() {
		return tonkho;
	}
	public void setTonkho(long tonkho) {
		this.tonkho = tonkho;
	}
	
	public String getMahang() {
		return mahang;
	}

	public void setMahang(String mahang) {
		this.mahang = mahang;
	}
	
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
}
