package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.giohangbean;


public class giohangdao {
	public ArrayList<giohangbean> getdssp(long makh, long mahd) {
		ArrayList<giohangbean> dssach = new ArrayList<giohangbean>();
		try {
			
			CoSodao cs = new CoSodao();
			cs.ketnoi();
			String sql = "select sach.MaSach, sach.tensach, cthd.SoLuongMua, cthd.SoLuongMua*sach.gia as 'thanhtien', cthd.damua\r\n"
					+ "from ChiTietHoaDon as cthd right join hoadon as hd on cthd.MaHoaDon = hd.MaHoaDon join sach on cthd.MaSach = sach.masach\r\n"
					+ "where hd.makh = ? and cthd.MaHoaDon = ?;";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, makh);
			cmd.setLong(2, mahd);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()){
				String masach = rs.getString("MaSach");
				String tensach = rs.getString("tensach");
				long soluong = rs.getLong("SoLuongMua");
				long gia = rs.getLong("thanhtien")/soluong;
				boolean damua = rs.getBoolean("damua");
				dssach.add(new giohangbean(masach, tensach, gia, soluong, "", damua));
			}
			return dssach;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
//	public static void main(String[] args) {
//		giohangdao gh = new giohangdao();
//		ArrayList<giohangbean> dssach1 = gh.getdssp(26, 13);
//		for(giohangbean sp : dssach1) {
//			System.out.println(sp.getTensach() +  " " + sp.getSoluong() + " " + sp.getThanhtien());
//		}
//	}
}
