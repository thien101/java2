package bo;

import java.util.ArrayList;

import bean.sachbean;
import dao.sachdao;

public class sachbo {
	sachdao ds = new sachdao();
	ArrayList<sachbean> dssach;
	
	
	public ArrayList<sachbean> getsach(){
		dssach = ds.getsach();
		return dssach;
	}
	
	public ArrayList<sachbean> timkiem(ArrayList<sachbean> dss, String tk){
		ArrayList<sachbean> findsach = new ArrayList<sachbean>();
		//int n = dssach.size();
		for(sachbean s : ds.getsach()) {
			if(s.getMaloai().toLowerCase().contains(tk.toLowerCase())
					|| s.getMasach().toLowerCase().trim().contains(tk.toLowerCase().trim()) 
					|| s.getTacgia().toLowerCase().trim().contains(tk.toLowerCase().trim()) 
					|| s.getTensach().toLowerCase().trim().contains(tk.toLowerCase().trim())
					){
				findsach.add(s);
			}
		}
		return findsach;
	}
	
}