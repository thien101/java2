package bo;

import java.util.ArrayList;

import bean.hangbean;
import dao.hangdao;

public class hangbo {
	hangdao hd = new hangdao();
	ArrayList<hangbean> ds;
	
	public ArrayList<hangbean> gethang(){
		ds = hd.gethang();
		return ds;
	}
	
	public void them_loai (hangbean hang) {
		try {
			hd.them(hang);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void xoa_loai (String mh) {
		try {
			hd.xoa(mh);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void sua_loai (String mh, String th) {
		try {
			hd.sua(mh, th);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
