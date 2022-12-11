package bean;

import java.sql.Date;

public class xacnhanhdbean {
	private String tenkh;
	private long mahd;
	private Date ngaymua;
	private boolean damua;
	public xacnhanhdbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public xacnhanhdbean(String tenkh, long mahd, Date ngaymua, boolean damua) {
		super();
		this.tenkh = tenkh;
		this.mahd = mahd;
		this.ngaymua = ngaymua;
		this.damua = damua;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public long getMahd() {
		return mahd;
	}
	public void setMahd(long mahd) {
		this.mahd = mahd;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	
}
