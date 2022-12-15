package bo;

import java.util.ArrayList;

import bean.khachhangbean;
import dao.khachhangdao;

public class khachhangbo {
	public static khachhangdao khd = new khachhangdao();

	public khachhangbean ktdn (String un , String pass) {
		for(khachhangbean k : khd.getkhach()) {
			if(k.getTendn().equals(un.toLowerCase()) && k.getPass().equals(pass.toLowerCase())) {
				return k;
			}
		}
		return null;
	}
	
	public void them_kh(khachhangbean kh) {
		try {
			khd.them(kh);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public void capnhap_kh(String ht, String dc, String sdt, String email, khachhangbean kh) {
		try {
			khd.capnhap(ht, dc, sdt, email, kh.getMakh());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		/*
		 * for(khachhangbean k : khd.getkhach()) { System.out.println(k.getTenkh() + " "
		 * + k.getMakh()); }
		 */
		
		try {
			khd.capnhap("Cong Trung", "Second House", "0123789456", "trung@gmail.com", 4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
