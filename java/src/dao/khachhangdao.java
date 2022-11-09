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
				String hoten = rs.getString("hoten");
				String diachi = rs.getString("diachi");
				String sdt = rs.getString("sodt");
				String email = rs.getString("email");
				dskhach.add(new khachhangbean(makh, tendn, pass, hoten, diachi, sdt, email));
			}
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
			
			String sql = "insert into KhachHang (hoten, diachi, sodt, email, tendn, pass)\r\n"
					+ "values (?, ?, ?, ?, ?, ?);";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, kh.getHoten());
			cmd.setString(2, kh.getDiachi());
			cmd.setString(3, kh.getSdt());
			cmd.setString(4, kh.getEmail());
			cmd.setString(5, kh.getTendn());
			cmd.setString(6, kh.getPass());
			return cmd.executeUpdate();
			
	}
	
	public static void main(String[] args) {
		khachhangdao kh = new khachhangdao();
		for(khachhangbean k : kh.getkhach()) {
			System.out.println(k.getTendn() + " " + k.getPass());
		}
	}
}



