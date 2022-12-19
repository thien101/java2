package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.hoadonbean;

public class hoadondao {
	public int them (hoadonbean hd) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "insert into hoadon(makh, thanhtien, ngaydat, daduyet)\r\n"
				+ "values (?, ?, ?, ?)";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setLong(1, hd.getMakh());
		cmd.setLong(2, hd.getThanhtien());
		cmd.setDate(3, hd.getNgaydat());
		cmd.setBoolean(4, hd.isDuyet());
		return cmd.executeUpdate();
	}
	
	public int capnhap (long mahd, Date ngayduyet) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "update hoadon set daduyet = 'true', ngayduyet = ? where mahd = ?\r\n"
				+ "update chitiethoadon set damua = 'true' where mahd = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setDate(1, ngayduyet);
		cmd.setLong(2, mahd);
		cmd.setLong(3, mahd);
		return cmd.executeUpdate();
	}
	
	public int gethd(long makh) {
		try {
			
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			String sql = "select max(mahd) as mahd\r\n"
					+ "from hoadon\r\n"
					+ "where makh =?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, makh);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()){
				return Integer.parseInt(rs.getString("mahd"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public ArrayList<hoadonbean> getdshd(long makh) {
		ArrayList<hoadonbean> dshd = new ArrayList<hoadonbean>();
		try {
			
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			String sql = "select * from hoadon where makh = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, makh);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()){
				long mahd = rs.getLong("mahd");
				long mak = rs.getLong("makh");
				long thanhtien = rs.getLong("thanhtien");
				Date ngayduyet = rs.getDate("ngayduyet");
				Date ngaydat = rs.getDate("ngaydat");
				boolean duyet = rs.getBoolean("daduyet");
				dshd.add(new hoadonbean(mahd, makh, duyet, thanhtien, ngaydat, ngayduyet));
			}
			return dshd;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
