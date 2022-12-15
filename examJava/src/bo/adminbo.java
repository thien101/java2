package bo;

import bean.adminbean;
import dao.admindao;
public class adminbo {
	
	admindao adD = new admindao();
	public adminbean ktdn(String tendn, String pass) {
		for(adminbean ad : adD.getdsadmin()) {
			if(ad.getTendn().equals(tendn.toLowerCase()) && ad.getPass().equals(pass.toLowerCase())) {
				return ad;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		adminbo adb = new adminbo();
		System.out.println(adb.ktdn("thien", "123").getTendn());
	}
}
