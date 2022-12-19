package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.adminbean;



public class admindao {
	public ArrayList<adminbean> getdsadmin (){
		try {
			ArrayList<adminbean> dsad = new ArrayList<adminbean>();
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			
			String sql = "select * from admin";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			
			while (rs.next()){
				int maad = rs.getInt("maadmin");
				String tendn = rs.getString("tendn");
				String pass = rs.getString("pass");
				dsad.add(new adminbean(maad, tendn, pass));
			}
			rs.close();
			cs.cn.close();
			return dsad;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		admindao add = new admindao();
		for(adminbean ad : add.getdsadmin()) {
			System.out.println(ad.getTendn() + " " + ad.getPass());
		}
	}
}
