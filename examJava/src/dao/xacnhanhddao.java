package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.cthoadonbean;
import bean.xacnhanhdbean;

public class xacnhanhddao {
	public ArrayList<xacnhanhdbean> getdshd() {
		ArrayList<xacnhanhdbean> dsxnhd = new ArrayList<xacnhanhdbean>();
		try {
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			String sql = "select * from xacnhanhoadon where daduyet = 'false'";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()){
				long mahd = rs.getLong("mahd");
				String tenkh = rs.getString("tenkh");
				long thanhtien = rs.getLong("thanhtien");
				Date ngaydat = rs.getDate("ngaydat");
				Date ngayduyet = rs.getDate("ngayduyet");
				boolean duyet = rs.getBoolean("daduyet");
				dsxnhd.add(new xacnhanhdbean(mahd, tenkh, thanhtien, ngaydat, ngayduyet, duyet));
			}
			rs.close();
			cs.cn.close();
			return dsxnhd;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
