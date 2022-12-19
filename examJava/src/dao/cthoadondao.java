package dao;

import java.sql.PreparedStatement;

import bean.cthoadonbean;

public class cthoadondao {
	public int them (cthoadonbean cthd) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "insert into chitiethoadon(mahd, masp, soluong, thanhtien, damua)\r\n"
				+ "values (?, ?, ?, ?, ?)";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setLong(1, cthd.getMahd());
		cmd.setLong(2, cthd.getMasp());
		cmd.setLong(3, cthd.getSoluong());
		cmd.setLong(4, cthd.getThanhtien());
		cmd.setBoolean(5, false);

		return cmd.executeUpdate();
	}
	
	public int capnhap (long mahd) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "update chitiethoadon\r\n"
				+ "set damua = 'true'\r\n"
				+ "where mahd = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setLong(1, mahd);

		return cmd.executeUpdate();
	}
}
