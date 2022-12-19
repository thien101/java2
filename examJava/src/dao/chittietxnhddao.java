package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.chitietxnhdbean;


public class chittietxnhddao {
	public ArrayList<chitietxnhdbean> getdssp(long mahd) {
		ArrayList<chitietxnhdbean> dssp = new ArrayList<chitietxnhdbean>();
		try {
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			String sql = "select * from xacnhancthd \r\n"
					+ "where mahd = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, mahd);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()){
				String tenkh = rs.getString("tenkh");
				String tensp = rs.getString("tensp");
				long thanhtien = rs.getLong("thanhtien");
				long gia = rs.getLong("gia");
				long soluong = rs.getLong("soluong");
				boolean damua = rs.getBoolean("damua");
				dssp.add(new chitietxnhdbean(mahd, tenkh, tensp, gia, soluong, thanhtien, damua));
			}
			rs.close();
			cs.cn.close();
			return dssp;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
