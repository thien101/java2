package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.danhsachxnbean;

public class danhsachxndao {
	public ArrayList<danhsachxnbean> getdsxn(long mahd) {
		ArrayList<danhsachxnbean> dssach = new ArrayList<danhsachxnbean>();
		try {
			
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			String sql = "select *\r\n"
					+ "from danhsachxacnhan\r\n"
					+ "where damua = 0 and MaHoaDon = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, mahd);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()){
				String tensach = rs.getString("tensach");
				long gia = rs.getLong("gia");
				long thanhtien = rs.getLong("thanhtien");
				long sl = rs.getLong("SoLuongMua");
				boolean damua = rs.getBoolean("damua");
				dssach.add(new danhsachxnbean(mahd, sl, gia, thanhtien, tensach, damua));
			}
			return dssach;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
