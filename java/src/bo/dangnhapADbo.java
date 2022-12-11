package bo;

import bean.dangnhapbean;
import bean.khachhangbean;
import dao.dangnhapADdao;

public class dangnhapADbo {
	public static dangnhapADdao dndao = new dangnhapADdao();
	public dangnhapbean ktdn (String un , String pass) {
		for(dangnhapbean ad : dndao.getadmin()) {
			if(ad.getTendn().equals(un.toLowerCase()) && ad.getMatkhau().equals(pass.toLowerCase())) {
				return ad;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		dangnhapADbo adbo = new dangnhapADbo();
		dangnhapbean ad = adbo.ktdn("abc", "123");
		System.out.println(ad.getTendn());
	}
}
