package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

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
}