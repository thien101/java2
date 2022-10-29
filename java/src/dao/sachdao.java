package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
}