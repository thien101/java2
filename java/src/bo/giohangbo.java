package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	public void Them(String masach, String tensach, long giasach, long soluong, String anh) {
		for(giohangbean g:ds) {
			if(g.getMasach().equals(masach)) {
				g.setSoluong(soluong + g.getSoluong());
				return;
			}
		}
		ds.add(new giohangbean(masach, tensach, giasach, soluong, anh));
	}
	
	public long tongtien () {
		long tt = 0;
		for(giohangbean g:ds) {
			tt += g.getThanhtien();
		}
		return tt;
	}
	
	public void Xoa(String masach) {
		for(int i=0; i < ds.size(); i++) {
			if(ds.get(i).getMasach().equals(masach)) {
				ds.remove(i);
			}
		}
	}
	
	public void Sua(String masach, long sl) {
		for(int i =0; i< ds.size(); i++) {
			if(ds.get(i).getMasach().equals(masach)) {
				ds.get(i).setSoluong(sl);
			}
		}
	}
	
	public int find(String masach) {
		int index = -1;
		for(int i=0; i < ds.size(); i++) {
			if(ds.get(i).getMasach().equals(masach))index = i;
		}
		return index;
	}
	
	public int demsl() {
		return ds.size();
	}
	
}