package bo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import bean.hoadonbean;
import dao.CoSodao;
import dao.hoadondao;


public class hoadonbo {
	public static hoadondao hd = new hoadondao();
	public void them_hd(hoadonbean hdt) {
		try {
			hd.them(hdt);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public void update_hd(long mahd) {
		try {
			hd.update(mahd);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public  int them_dshd (String masach, long sl, long mahd, boolean damua) {
		try {
			return hd.them_dshd(masach, sl, mahd, damua);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public int get_hd(long makh) {
		return hd.gethd(makh);
	}
	
	public ArrayList<hoadonbean> get_dshd(long makh){
		return hd.getdshd(makh);
	}
	public static void main(String[] args) {
		hoadonbo hd = new hoadonbo();
		hd.update_hd(13);
	}
}
