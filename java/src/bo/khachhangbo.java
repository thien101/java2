package bo;

import java.util.ArrayList;

import bean.khachhangbean;
import dao.khachhangdao;

public class khachhangbo {
	public static khachhangdao kh = new khachhangdao();
	public static ArrayList<khachhangbean> dskhach;
	
	public khachhangbean ktdn (String un , String pass) {
		dskhach = kh.getkhach();
		for(khachhangbean k : dskhach) {
			if(k.getTendn().equals(un.toLowerCase()) && k.getPass().equals(pass.toLowerCase())) {
				return k;
			}
		}
		return null;
	}
	public void them_kh(khachhangbean kh) {
		khachhangdao k = new khachhangdao();
		try {
			k.them(kh);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		khachhangbean k = new khachhangbean(1,"thien123", "123", "thien", "sadad", "0123456789", "thien@gmail.com");
		khachhangbo khbo = new khachhangbo();
		khbo.them_kh(k);
	}
}
