package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import bean.hoadonbean;
import bean.loaibean;

public class loaidao {
	//public ArrayList<loaibean> dsloai = new ArrayList<loaibean>();

	//public ArrayList<loaibean> dsloai= new ArrayList<loaibean>();
	public ArrayList<loaibean> getloai(){
		try {
			ArrayList<loaibean> dsloai= new ArrayList<loaibean>();
//			b1: ket noi vao csdl
			CoSodao cs = new CoSodao();
			cs.ketnoi();
//			b2: Lay du lieu ve
			String sql = "select * from loai";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maloai = rs.getString("maloai");
				String tenloai = rs.getString("tenloai");
				dsloai.add(new loaibean(maloai, tenloai));
			}
			   
//			   b3: close rs, cn
			rs.close();
			cs.cn.close();
			return dsloai;
				 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	public int them (loaibean loai) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "insert into loai(maloai, tenloai) values(?, ?)";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, loai.getMaloai());
		cmd.setString(2, loai.getTenloai());
		return cmd.executeUpdate();
	}
	
	public int xoa (String ml) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		String sql = "delete from loai where maloai = ? \r\n"
				+ "delete from sach where maloai = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1,ml);
		cmd.setString(2,ml);
		return cmd.executeUpdate();
	}
	
	public int sua (String ml, String tl) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		String sql = "update loai set tenloai = ? where maloai = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1,tl);
		cmd.setString(2,ml);
		return cmd.executeUpdate();
	}
	
	/*
	 * public static void main(String[] args) { try { loaidao ld = new loaidao();
	 * System.out.println(ld.them(new loaibean("tieuthuyet", "Tieu Thuyet"))); }
	 * catch (Exception e) { // TODO: handle exception e.printStackTrace(); } }
	 */
}