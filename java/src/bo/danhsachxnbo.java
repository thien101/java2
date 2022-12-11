package bo;

import java.util.ArrayList;

import bean.danhsachxnbean;
import dao.danhsachxndao;

public class danhsachxnbo {
	danhsachxndao xndao = new danhsachxndao();
	public ArrayList<danhsachxnbean> getdsxn(long mahd) {
		return xndao.getdsxn(mahd);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		danhsachxnbo xnbo = new danhsachxnbo();
		for(danhsachxnbean s : xnbo.getdsxn(13)) {
			System.out.println(s.getTensach());
		}
	}

}
