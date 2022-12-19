package bo;

import java.util.ArrayList;

import bean.chitietxnhdbean;
import dao.chittietxnhddao;

public class chitietxnhdbo {
	public chittietxnhddao ctxndao = new chittietxnhddao();
	public ArrayList<chitietxnhdbean> getdssp(long mahd) {
		return ctxndao.getdssp(mahd);
	}
	
	public static void main(String[] args) {
		chitietxnhdbo ctxnbo = new chitietxnhdbo();
		for(chitietxnhdbean sp : ctxnbo.getdssp(3)) {
			System.out.println(sp.getTenkh() + " " + sp.getTensp());
		}
	}
}
