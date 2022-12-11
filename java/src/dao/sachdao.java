package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.hoadonbean;
import bean.sachbean;

public class sachdao {
	public ArrayList<sachbean> dssach = new ArrayList<sachbean>();
	public ArrayList<sachbean> get_sach(){
		dssach.add(new sachbean("s1", "Cấu trúc dữ liệu 1", "Nguyễn Hoàng Hà", 1, 100000, "./image_sach/b1.jpg", "tin"));
		dssach.add(new sachbean("s2", "Cấu trúc dữ liệu 2", "Nguyễn Hoàng Hà 1", 1, 100000, "./image_sach/b2.jpg", "tin"));
		dssach.add(new sachbean("s3", "Cấu trúc dữ liệu 3", "Nguyễn Hoàng Hà 2", 1, 100000, "./image_sach/b3.jpg", "tin"));
		dssach.add(new sachbean("s4", "Cơ sở toán", "Nguyễn Hoàng Hà 3", 1, 100000, "./image_sach/b4.jpg", "toan"));
		dssach.add(new sachbean("s5", "Giải tích", "Nguyễn Hoàng Hà 4", 1, 100000, "./image_sach/b5.jpg", "toan"));
		dssach.add(new sachbean("s6", "Ca dao", "Nguyễn Hoàng Hà 5", 1, 100000, "./image_sach/b6.jpg", "van"));
		return dssach;
	}
	
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
				long soluong = 1;
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