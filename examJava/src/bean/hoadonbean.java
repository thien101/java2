package bean;

import java.sql.Date;

public class hoadonbean {
	private long mahd;
	private long makh;
	private boolean duyet;
	private long thanhtien;
	private Date ngaydat;
	private Date ngayduyet;
	public hoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hoadonbean(long mahd, long makh, boolean duyet, long thanhtien, Date ngaydat, Date ngayduyet) {
		super();
		this.mahd = mahd;
		this.makh = makh;
		this.duyet = duyet;
		this.thanhtien = thanhtien;
		this.ngaydat = ngaydat;
		this.ngayduyet = ngayduyet;
	}
	public long getMahd() {
		return mahd;
	}
	public void setMahd(long mahd) {
		this.mahd = mahd;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public boolean isDuyet() {
		return duyet;
	}
	public void setDuyet(boolean duyet) {
		this.duyet = duyet;
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
	
}
