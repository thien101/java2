package dao;

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
	public static void main(String[] args) {
		sanphamdao spd = new sanphamdao();
		for(sanphambean sp : spd.getsanpham()) {
			System.out.println(sp.getMasp() + " " + sp.getTensp());
		}
	}
}
