package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.chitietsanpham;
import bean.hoadonbean;

public class ctsanphamdao {
	public ArrayList<chitietsanpham> getdssp(long mahd) {
		ArrayList<chitietsanpham> dssp = new ArrayList<chitietsanpham>();
		try {
			
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			String sql = "select * from chitietsanpham where mahd = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, mahd);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()){
				long macthd = rs.getLong("macthd");
				long masp = rs.getLong("masp");
				String tensp = rs.getString("tensp");
				long slmua = rs.getLong("soluong");
				long gia = rs.getLong("gia");
				boolean damua = rs.getBoolean("damua");
				dssp.add(new chitietsanpham(macthd, mahd, masp, slmua, gia, damua, tensp));
			}
			return dssp;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
