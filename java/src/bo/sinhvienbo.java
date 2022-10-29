package bo;

import java.util.ArrayList;

import bean.sinhvienbean;
import dao.sinhviendao;

public class sinhvienbo {
	sinhviendao ds = new sinhviendao();
	public ArrayList<sinhvienbean> dssv = new ArrayList<>();
	public ArrayList<sinhvienbean> timkiem(String key){
		for(sinhvienbean sv : ds.getsv()) {
			if(sv.getMamon().toLowerCase().contains(key.toLowerCase())
					|| sv.getMasv().toLowerCase().trim().contains(key.toLowerCase().trim()) 
					|| sv.getHoten().toLowerCase().trim().contains(key.toLowerCase().trim()) 
					|| sv.getEmail().toLowerCase().trim().contains(key.toLowerCase().trim())
					|| sv.getDiachi().toLowerCase().trim().contains(key.toLowerCase().trim())
					){
				dssv.add(sv);
			}
		}
		return dssv;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}