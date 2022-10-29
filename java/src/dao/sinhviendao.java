package dao;

import java.util.ArrayList;

import bean.sinhvienbean;

public class sinhviendao {
	public ArrayList<sinhvienbean> dssv = new ArrayList<>();
	public ArrayList<sinhvienbean> getsv() {
		dssv.add(new sinhvienbean("sv01", "Huỳnh Trọng Đức", "asd", "b5.jpg", "mh01", "sv01@husc.edu.vn"));
		dssv.add(new sinhvienbean("sv03", "Đức Huỳnh", "asd", "b1.jpg", "mh02", "sv03@husc.edu.vn"));
		dssv.add(new sinhvienbean("sv04", "Huỳnh Đức", "asd", "b2.jpg", "mh03", "sv04@husc.edu.vn"));
		dssv.add(new sinhvienbean("sv05", "Đức Trọng", "asd", "b3.jpg", "mh01", "sv05@husc.edu.vn"));
		dssv.add(new sinhvienbean("sv06", "Huyền Khanh", "asd", "b4.jpg", "mh03", "sv06@husc.edu.vn"));
		dssv.add(new sinhvienbean("sv02", "Khánh Huyền", "asd", "b6.jpg", "mh02", "sv02@husc.edu.vn"));
		return dssv;
	}
}