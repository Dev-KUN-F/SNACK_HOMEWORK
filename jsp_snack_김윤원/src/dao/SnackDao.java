package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnection;
import dto.SnackDto;



public class SnackDao {
	Connection 			con = null;
	PreparedStatement 	ps  = null;
	ResultSet 			rs  = null;
	
	public ArrayList<SnackDto> getSnackList(String company , String search) {
		// TODO Auto-generated method stub
		
		SnackDto dto = null;
		ArrayList<SnackDto> dtos = new ArrayList<SnackDto>();
		String sql ="SELECT s.pcode, s.pname, S.COMPANY, C.NAME, S.PRICE, to_char(S.MAKEDATE, 'yy-MM-DD') as makedate \r\n" + 
				"FROM SNACK_김윤원 S, SNACK_COMPANY C\r\n" + 
				"WHERE s.company = c.company\r\n"
				 ;
		
				if(company != "") sql+= "and s.company = '"+company+"' \r\n";
				if(search != "") sql += "and s.pname like '%"+search+"%' \r\n" ;
				
				sql += "order by s.pcode";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String pid = rs.getString("pcode");
				String pname = rs.getString("pname");
				String pcomname = rs.getString("name");
				String pcomcode = rs.getString("company");
				
				int pprice = rs.getInt("price");
				String pmakedate = rs.getString("makedate");
				dto = new SnackDto(pid, pname, pcomname, pcomcode,pprice,pmakedate);
				dtos.add(dto);
			}
				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getSnackList() 오류 : "+ sql);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dtos;
		
	}
	
	public int SnackSave(SnackDto dto) {
		// TODO Auto-generated method stub
		int result = 0;
		
		String sql = "insert into snack_김윤원\r\n" + 
				"(pcode, pname, COMPANY, PRICE, MAKEDATE)\r\n" + 
				"values\r\n" + 
				"('"+dto.getId()+"','"+dto.getName()+"','"+dto.getCompany()+"',"+dto.getPrice()+",'"+dto.getDate()+"' )";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SnackSave() 오류 : " + sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	
	public SnackDto getSnackInfo(String id) {
		// TODO Auto-generated method stub
		SnackDto dto = null;
		String sql ="SELECT s.pcode, s.pname, S.COMPANY, C.NAME, S.PRICE, to_char(S.MAKEDATE, 'yy-MM-DD') as makedate \r\n" + 
				"FROM SNACK_김윤원 S, SNACK_COMPANY C\r\n" + 
				"WHERE s.company = c.company\r\n"
				+ "and s.pcode = '"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String pid = rs.getString("pcode");
				String pname = rs.getString("pname");
				String pcomname = rs.getString("name");
				String pcomcode = rs.getString("company");
				
				int pprice = rs.getInt("price");
				String pmakedate = rs.getString("makedate");
				dto = new SnackDto(pid, pname, pcomname, pcomcode,pprice,pmakedate);
				
			}
				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getSnackInfo() 오류 : "+ sql);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}
	
	public int updateSnack(SnackDto dto) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql =  "update SNACK_김윤원\r\n" + 
				"set pname = '"+dto.getName()+"',\r\n" + 
				"    company = '"+dto.getCompany()+"', \r\n" + 
				"    price = "+dto.getPrice()+", \r\n" + 
				"    makedate = '"+dto.getDate()+"' \r\n" + 
				"    where pcode = '"+dto.getId()+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("updateSnack() 오류 : " + sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		
		return result;
	}
	
	public int deleteSnack(String id) {
		// TODO Auto-generated method stub
		int result = 0;
		
		String sql = "delete from snack_김윤원 \r\n" + 
				"\r\n" + 
				"where pcode = '"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("memberUpdate() 오류 : " + sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
		
	}
	
	public int checkPcode(String id) {
		// TODO Auto-generated method stub
		int count = 0;
		
		
		String sql ="SELECT count(*) as count \r\n" + 
				"FROM SNACK_김윤원 \r\n" + 
				"WHERE pcode = '"+id+"'"
				;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt("count");
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("checkPcode() 오류 : "+ sql);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		
		
		return count;
	}	
}
