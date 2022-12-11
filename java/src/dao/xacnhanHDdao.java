package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.hoadonbean;
import bean.xacnhanhdbean;

public class xacnhanHDdao {
	public ArrayList<xacnhanhdbean> getdshd() {
		ArrayList<xacnhanhdbean> dshd = new ArrayList<xacnhanhdbean>();
		try {
			
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			String sql = "select *\r\n"
					+ "from danhsachdatmua\r\n"
					+ "where damua = 0";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()){
				String tenkh = rs.getString("hoten");
				long mahd = rs.getLong("MaHoaDon");
				Date ngaymua = rs.getDate("NgayMua");
				boolean damua = rs.getBoolean("damua");
				dshd.add(new xacnhanhdbean(tenkh, mahd, ngaymua, damua));
			}
			return dshd;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
