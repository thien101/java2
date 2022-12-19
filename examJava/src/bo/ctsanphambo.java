package bo;

import java.util.ArrayList;

import bean.chitietsanpham;
import dao.ctsanphamdao;

public class ctsanphambo {
	public static ctsanphamdao ctspd = new ctsanphamdao();
	public ArrayList<chitietsanpham> get_dssp(long mahd){
		return ctspd.getdssp(mahd);
	}
}
