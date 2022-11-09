package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.hoadonbean;
import bean.khachhangbean;

public class hoadondao {
	public int them (hoadonbean hd) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "insert into hoadon (Ngaymua, damua, makh)\r\n"
				+ "values (?, ?, ?);";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setDate(1, hd.getNgaymua());
		cmd.setBoolean(2, hd.isDamua());
		cmd.setLong(3, hd.getMakh());
		return cmd.executeUpdate();
	}
	
	public int them_dshd (String masach, long sl, long mahd, boolean damua) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "insert into ChiTietHoaDon(MaSach, SoLuongMua, MaHoaDon, damua) values (?, ?, ?, ?);";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		cmd.setLong(2, sl);
		cmd.setLong(3, mahd);
		cmd.setBoolean(4, damua);
		return cmd.executeUpdate();
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
				long mahd = rs.getLong("MaHoaDon");
				long mak = rs.getLong("makh");
				Date date = rs.getDate("NgayMua");
				boolean damua = rs.getBoolean("damua");
				dshd.add(new hoadonbean(mahd, makh, date, damua));
			}
			return dshd;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public int gethd() {
		try {
			
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			String sql = "select top 1 MaHoaDon\r\n"
					+ "from hoadon\r\n"
					+ "ORDER BY MaHoaDon desc";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()){
				return Integer.parseInt(rs.getString("MaHoaDon"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
//	public static void main(String[] args) {
//		hoadondao hd = new hoadondao();
//		System.out.println(hd.gethd());
//	}
	
}
