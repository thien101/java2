package dao;

import java.util.ArrayList;

import bean.monhocbean;

public class monhocdao {
	public ArrayList<monhocbean> dsmh= new ArrayList<monhocbean>();
	public ArrayList<monhocbean> getds() {
		dsmh.add(new monhocbean("mh01", "To�n"));
		dsmh.add(new monhocbean("mh02", "L�"));
		dsmh.add(new monhocbean("mh03", "Ho�"));
		return dsmh;
	}
}