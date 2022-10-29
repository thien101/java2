package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ldao = new loaidao();
	ArrayList<loaibean> ds;
	
	public ArrayList<loaibean> getloai(){
		ds = ldao.getloai();
		return ds;
	}
	
	public static void main(String[] args) {
		loaibo dsl = new loaibo();
		for(loaibean l : dsl.getloai()) {
			System.out.println(l.getMaloai());
		}
	}
}
