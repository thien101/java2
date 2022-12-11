package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.dangnhapbean;
import bean.khachhangbean;

public class dangnhapADdao {
	public ArrayList<dangnhapbean> getadmin (){
		try {
			ArrayList<dangnhapbean> dsad = new ArrayList<dangnhapbean>();
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			
			String sql = "select * from DangNhap";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			
			while (rs.next()){
				String tendn = rs.getString("TenDangNhap");
				String pass = rs.getString("MatKhau");
				boolean quyen = rs.getBoolean("Quyen");
				dsad.add(new dangnhapbean(tendn, pass, quyen));
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
}
