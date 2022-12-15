package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachhangbean;

public class khachhangdao {
	public ArrayList<khachhangbean> getkhach (){
		try {
			ArrayList<khachhangbean> dskhach = new ArrayList<khachhangbean>();
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			
			String sql = "select * from KhachHang";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			
			while (rs.next()){
				int makh = Integer.parseInt(rs.getString("makh"));
				String tendn = rs.getString("tendn");
				String pass = rs.getString("pass");
				String hoten = rs.getString("tenkh");
				String diachi = rs.getString("diachi");
				String sdt = rs.getString("sdt");
				String email = rs.getString("email");
				dskhach.add(new khachhangbean(makh, tendn, pass, hoten, diachi, sdt, email));
			}
			rs.close();
			cs.cn.close();
			return dskhach;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public int them (khachhangbean kh) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "insert into khachhang(tenkh, sdt, diachi, email, tendn, pass)\r\n"
				+ "values (?, ?, ?, ?, ?, ?);";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, kh.getTenkh());
		cmd.setString(2, kh.getSdt());
		cmd.setString(3, kh.getDiachi());
		cmd.setString(4, kh.getEmail());
		cmd.setString(5, kh.getTendn());
		cmd.setString(6, kh.getPass());
		return cmd.executeUpdate();	
	}
	
	public int capnhap (String ht, String dc, String sdt, String email, long makh) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "update khachhang\r\n"
				+ "set tenkh = ?, sdt = ?, diachi = ?, email = ?\r\n"
				+ "where makh = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, ht);
		cmd.setString(2, sdt);
		cmd.setString(3, dc);
		cmd.setString(4, email);
		cmd.setLong(5, makh);
		return cmd.executeUpdate();	
	}
}
