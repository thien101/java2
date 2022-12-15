package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.hoadonbean;
import bean.sachbean;

public class sachdao {
	public ArrayList<sachbean> dssach = new ArrayList<sachbean>();
	public ArrayList<sachbean> getsach() {
		try {
			ArrayList<sachbean> dssach = new ArrayList<sachbean>();
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			
			String sql = "select * from sach";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String anh = rs.getString("anh");
				String tacgia = rs.getString("tacgia");
				long gia = rs.getLong("gia");
				long soluong = rs.getLong("soluong");
				String maloai = rs.getString("maloai");
				dssach.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			}
			return dssach;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<sachbean> tikiemsach(String ml) {
		try {
			ArrayList<sachbean> dssach = new ArrayList<sachbean>();
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			
			String sql = "select * from sach where maloai=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String anh = rs.getString("anh");
				String tacgia = rs.getString("tacgia");
				long gia = rs.getLong("gia");
				long soluong = rs.getLong("soluong");
				String maloai = rs.getString("maloai");
				dssach.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			}
			return dssach;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public int them (sachbean s, String sotap, Date date) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "insert into sach (masach, tensach, soluong, gia, maloai, sotap, anh, NgayNhap, tacgia)\r\n"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, s.getMasach());
		cmd.setString(2, s.getTensach());
		cmd.setLong(3, s.getSoluong());
		cmd.setLong(4, s.getGia());
		cmd.setString(5, s.getMaloai());
		cmd.setString(6, sotap);
		cmd.setString(7, s.getAnh());
		cmd.setDate(8, date);
		cmd.setString(9, s.getTacgia());
		return cmd.executeUpdate();
	}
	
	public int sua (sachbean s, String sotap) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "update sach\r\n"
				+ "set tensach=?, soluong=?, gia=?, maloai=?, sotap=?, tacgia=?\r\n"
				+ "where masach=?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, s.getTensach());
		cmd.setLong(2, s.getSoluong());
		cmd.setLong(3, s.getGia());
		cmd.setString(4, s.getMaloai());
		cmd.setString(5, sotap);
		cmd.setString(6, s.getTacgia());
		cmd.setString(7, s.getMasach());
		return cmd.executeUpdate();
	}
	
	public int xoa (String ms) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "delete from sach where masach = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1,ms);
		return cmd.executeUpdate();
	}
	
	public static void main(String[] args) {
		long millis=System.currentTimeMillis();//
		java.sql.Date date=new java.sql.Date(millis);
		sachbean sach = new sachbean("bbb123", "aaa", "bbb", 10, 1000, null, "Tin");
		sachdao sd = new sachdao();
		try {
			sd.them(sach, "1", date);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}