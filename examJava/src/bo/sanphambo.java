package bo;

import java.sql.Date;
import java.util.ArrayList;


import bean.sanphambean;
import dao.sanphamdao;

public class sanphambo {
	sanphamdao spd = new sanphamdao();
	public ArrayList<sanphambean> getsanpham(){
		return spd.getsanpham();
	}
	
	public ArrayList<sanphambean> timkiem(String tk){
		ArrayList<sanphambean> findsach = new ArrayList<sanphambean>();
		//int n = dssach.size();
		for(sanphambean sp : spd.getsanpham()) {
			if(sp.getTensp().trim().contains(tk.toLowerCase().trim()) 
					|| sp.getMahang().toLowerCase().trim().contains(tk.toLowerCase().trim()))
					{
				findsach.add(sp);
			}
		}
		return findsach;
	}
	
	public sanphambean timkiem_msp(long masp){
		//int n = dssach.size();
		for(sanphambean sp : spd.getsanpham()) {
			if(sp.getMasp() == masp){
				return sp;
			}
		}
		return null;
	}
	
	public void them_sp(sanphambean s) {
		try {
			spd.them(s);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public void sua_sach(sanphambean s) {
		try {
			spd.sua(s);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public void xoa_sach(long ms) {
		try {
			spd.xoa(ms);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	
	public static void main(String[] args) {
		sanphambo spb = new sanphambo();
		spb.them_sp(new sanphambean(0, "sadsd", "macbook", 50, 12000000, ""));
	}
}
