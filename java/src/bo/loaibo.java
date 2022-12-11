package bo;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import bean.loaibean;
import dao.CoSodao;
import dao.loaidao;

public class loaibo {
	loaidao ldao = new loaidao();
	ArrayList<loaibean> ds;
	
	public ArrayList<loaibean> getloai(){
		ds = ldao.getloai();
		return ds;
	}
	
	public void them_loai (loaibean loai) {
		try {
			ldao.them(loai);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void xoa_loai (String ml) {
		try {
			ldao.xoa(ml);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void sua_loai (String ml, String tl) {
		try {
			ldao.sua(ml, tl);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		loaibo dsl = new loaibo();
		for(loaibean l : dsl.getloai()) {
			System.out.println(l.getMaloai());
		}
	}
}
