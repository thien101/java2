package bo;

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
					|| sp.getMahang().toLowerCase().trim().contains(tk.toLowerCase().trim()) )
					{
				findsach.add(sp);
			}
		}
		return findsach;
	}
	
	public static void main(String[] args) {
		sanphambo spb = new sanphambo();
		for(sanphambean sp : spb.timkiem("mac")) {
			System.out.println(sp.getTensp() + " " + sp.getMasp());
		}
	}
}
