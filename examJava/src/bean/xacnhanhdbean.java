package bean;

import java.sql.Date;

public class xacnhanhdbean {
	private long mahd;
	private String tenkh;
	private long thanhtien;
	private Date ngaydat, ngayduyet;
	private boolean duyet;
	public xacnhanhdbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public xacnhanhdbean(long mahd, String tenkh, long thanhtien, Date ngaydat, Date ngayduyet, boolean duyet) {
		super();
		this.mahd = mahd;
		this.tenkh = tenkh;
		this.thanhtien = thanhtien;
		this.ngaydat = ngaydat;
		this.ngayduyet = ngayduyet;
		this.duyet = duyet;
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
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public Date getNgaydat() {
		return ngaydat;
	}
	public void setNgaydat(Date ngaydat) {
		this.ngaydat = ngaydat;
	}
	public Date getNgayduyet() {
		return ngayduyet;
	}
	public void setNgayduyet(Date ngayduyet) {
		this.ngayduyet = ngayduyet;
	}
	public boolean isDuyet() {
		return duyet;
	}
	public void setDuyet(boolean duyet) {
		this.duyet = duyet;
	}
}
