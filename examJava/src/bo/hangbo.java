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
}
