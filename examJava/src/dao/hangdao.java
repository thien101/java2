package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.hangbean;

public class hangdao {
	public ArrayList<hangbean> gethang(){
		try {
			ArrayList<hangbean> dshang= new ArrayList<hangbean>();
//			b1: ket noi vao csdl
			CoSodao cs = new CoSodao();
			cs.ketnoi();
//			b2: Lay du lieu ve
			String sql = "select * from hang";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String mahang = rs.getString("mahang");
				String tenhang = rs.getString("tenhang");
				dshang.add(new hangbean(mahang, tenhang));
			}
			   
//			   b3: close rs, cn
			rs.close();
			cs.cn.close();
			return dshang;
				 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}	
	}
	
	public int them (hangbean hang) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		
		String sql = "insert into hang(mahang, tenhang) values (?,?)";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, hang.getMahang());
		cmd.setString(2, hang.getTenhang());
		return cmd.executeUpdate();
	}
	
	public int xoa (String mh) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		String sql = "delete from sanpham where mahang = ?\r\n"
				+ "delete from hang where mahang = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1,mh);
		cmd.setString(2,mh);
		return cmd.executeUpdate();
	}
	
	public int sua (String mh, String th) throws Exception {
		CoSodao cs = new CoSodao();
		cs.ketnoi();
		String sql = "update hang set tenhang = ? where mahang = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1,th);
		cmd.setString(2,mh);
		return cmd.executeUpdate();
	}
	public static void main(String[] args) {
		hangdao hd = new hangdao();
		
	}
}
