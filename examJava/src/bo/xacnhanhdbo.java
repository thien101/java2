package bo;

import java.util.ArrayList;

import bean.xacnhanhdbean;
import dao.xacnhanhddao;

public class xacnhanhdbo {
	xacnhanhddao xndao = new xacnhanhddao();
	public ArrayList<xacnhanhdbean> getdshd(){
		return xndao.getdshd();
	}
	
	public static void main(String[] args) {
		xacnhanhdbo xnbo = new xacnhanhdbo();
		for(xacnhanhdbean hd : xnbo.getdshd()) {
			System.out.println(hd.getTenkh() +" "+ hd.getThanhtien());
		}
	}
}
