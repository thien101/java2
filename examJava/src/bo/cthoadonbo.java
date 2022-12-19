package bo;

import bean.cthoadonbean;
import dao.cthoadondao;

public class cthoadonbo {
	public static cthoadondao cthdd = new cthoadondao();
	public void them_cthd(cthoadonbean cthd) {
		try {
			cthdd.them(cthd);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public void capnhap_cthd(long mahd) {
		try {
			cthdd.capnhap(mahd);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		cthoadonbo hdb = new cthoadonbo();
		hdb.capnhap_cthd(3);
	}
}
