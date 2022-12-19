package bo;

import java.sql.Date;
import java.util.ArrayList;

import bean.hoadonbean;
import dao.hoadondao;

public class hoadonbo {
	public static hoadondao hdd = new hoadondao();
	public void them_hd(hoadonbean hdt) {
		try {
			hdd.them(hdt);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public void capnhap(long mahd, Date ngayduyet) {
		try {
			hdd.capnhap(mahd, ngayduyet);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public int get_hd(long makh) {
		return hdd.gethd(makh);
	}
	
	public ArrayList<hoadonbean> get_dshd(long makh){
		return hdd.getdshd(makh);
	}
	
	public static void main(String[] args) {
		long millis=System.currentTimeMillis();
		java.sql.Date ngayduyet=new java.sql.Date(millis);
		hoadonbo hdb = new hoadonbo();
		hdb.capnhap(3, ngayduyet);
	}
}
