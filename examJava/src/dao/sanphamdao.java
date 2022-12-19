package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.sanphambean;

public class sanphamdao {
	public ArrayList<sanphambean> getsanpham() {
		try {
			ArrayList<sanphambean> dssanpham = new ArrayList<sanphambean>();
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			
			String sql = "select * from sanpham";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				long masp = rs.getLong("masp");
				String tensp = rs.getString("tensp");
				String image = rs.getString("image");
				String mahang = rs.getString("mahang");
				long gia = rs.getLong("gia");
				long tonkho = rs.getLong("tonkho");
				dssanpham.add(new sanphambean(masp, tensp, mahang, tonkho, gia, image));
			}
			return dssanpham;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public int them (sanphambean s) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "insert into sanpham(tensp, mahang, image, tonkho, gia)\r\n"
				+ "values(?, ?, ?, ?, ?)";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, s.getTensp());
		cmd.setString(2, s.getMahang());
		cmd.setString(3, s.getAnh());
		cmd.setLong(4, s.getTonkho());
		cmd.setLong(5, s.getGia());

		return cmd.executeUpdate();
	}
	
	public int sua (sanphambean s) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "update sanpham\r\n"
				+ "set tensp = ?, mahang = ?, tonkho = ?, gia = ?\r\n"
				+ "where masp = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, s.getTensp());
		cmd.setString(2, s.getMahang());
		cmd.setLong(3, s.getTonkho());
		cmd.setLong(4, s.getGia());
		cmd.setLong(5, s.getMasp());
		return cmd.executeUpdate();
	}
	
	public int xoa (long masp) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "delete from sanpham where masp = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setLong(1, masp);
		return cmd.executeUpdate();
	}
	
	public static void main(String[] args) {
		sanphamdao spd = new sanphamdao();
		for(sanphambean sp : spd.getsanpham()) {
			System.out.println(sp.getMasp() + " " + sp.getTensp());
		}
	}
}
