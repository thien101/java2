package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> dssp = new ArrayList<giohangbean>();
	public void them(long masp, String tensp, long gia, long slmua, String anh, boolean damua){
		for(giohangbean gh : dssp) {
			if(gh.getMasp() == masp) {
				gh.setSlmua(slmua + gh.getSlmua());
				return;
			}
		}
		dssp.add(new giohangbean(masp, tensp, gia, slmua, anh, damua));
	}
	
	public void suasl(long masp,long slmua){
		for(int i =0; i< dssp.size(); i++) {
			giohangbean gh = dssp.get(i);
			if(gh.getMasp() == masp) {
				gh.setSlmua(slmua);
			}
		}
	}
	
	public void Xoa(long masp) {
		for(int i=0; i < dssp.size(); i++) {
			if(dssp.get(i).getMasp() == masp) {
				dssp.remove(i);
			}
		}
	}
	
	public long tongtien() {
		long tt=0;
		for(giohangbean gh : dssp) {
			tt += gh.getThanhtien();
		}
		return tt;
	}
}
