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
	public static void main(String[] args) {
		hangdao hd = new hangdao();
		for(hangbean h : hd.gethang()) {
			System.out.println(h.getMahang() + " " + h.getTenhang());
		}
	}
}
