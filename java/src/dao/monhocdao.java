package dao;

import java.util.ArrayList;

import bean.monhocbean;

public class monhocdao {
	public ArrayList<monhocbean> dsmh= new ArrayList<monhocbean>();
	public ArrayList<monhocbean> getds() {
		dsmh.add(new monhocbean("mh01", "Toán"));
		dsmh.add(new monhocbean("mh02", "Lý"));
		dsmh.add(new monhocbean("mh03", "Hoá"));
		return dsmh;
	}
}