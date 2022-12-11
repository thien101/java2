package bo;

import java.util.ArrayList;

import bean.xacnhanhdbean;
import dao.xacnhanHDdao;

public class xacnhanHDbo {
	xacnhanHDdao xndao = new xacnhanHDdao();
	public ArrayList<xacnhanhdbean> getdshd() {
		return xndao.getdshd();
	}
	
	public static void main(String[] args) {
		xacnhanHDbo xnbo = new xacnhanHDbo();
		for(xacnhanhdbean hd : xnbo.getdshd()) {
			System.out.println(hd.getTenkh() + " " + hd.getMahd() + " " + hd.getNgaymua() + " " + hd.isDamua());
		}
	}
}
