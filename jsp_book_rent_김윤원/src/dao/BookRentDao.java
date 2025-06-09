package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import common.DBConnection;
import dto.BookDto;
import dto.BookRentDto;


public class BookRentDao {
	Connection 			con = null;
	PreparedStatement 	ps  = null;
	ResultSet 			rs  = null;
	
	public ArrayList<BookRentDto> getBookRentList( String search) {
		// TODO Auto-generated method stub
		
		BookRentDto dto = null;
		ArrayList<BookRentDto> dtos = new ArrayList<BookRentDto>();
		String sql ="SELECT s.r_code, s.b_code, s.m_id, m.name, c.b_name, to_char(s.rent_date, 'yyyy-MM-DD') as rent_date , to_char(s.return_date, 'yyyy-MM-DD') as return_date \r\n" + 
				"FROM book_rent_김윤원 s, book_김윤원 c , member_김윤원 m\r\n" +
				"where s.b_code = c.b_code \r\n"+
				"and s.m_id = m.id \r\n"
				 ;
		
				if(search != "") sql+= "and m.name like '%"+search+"%'  \r\n";
				
				sql += "order by s.r_code";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String r_code = rs.getString("r_code");
				String b_code = rs.getString("b_code");
				String m_id = rs.getString("m_id");
				String m_name = rs.getString("name");
				String b_name = rs.getString("b_name");
				String rent_date = rs.getString("rent_date");
				String return_date = rs.getString("return_date");
				
				
				dto = new BookRentDto(r_code, b_code, b_name, m_id,m_name,rent_date, return_date);
				dtos.add(dto);
			}
				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getBookrentList() 오류 : "+ sql);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		
		
		return dtos;
		
	}
	
	public int returnBook(String rcode , String bcode) {
		// TODO Auto-generated method stub
		int result = 0;
		
		LocalDate now = LocalDate.now();
		String sql =  "update book_rent_김윤원\r\n" + 
				"set return_date = '"+now+"'\r\n" +  
				"    where r_code = '"+rcode+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
			
			result += returnBookInfo(bcode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("updateBook() 오류 : " + sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		System.out.println("returnBook() 오류 : " + sql);
		
		
		
		return result;
	}
	
	public int returnBookInfo(String bcode) {
		// TODO Auto-generated method stub
		int result = 0;
		
		
		String sql =  "update book_김윤원\r\n" + 
				"set rentable = 'y'\r\n" +  
				"    where b_code = '"+bcode+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("updateBook() 오류 : " + sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		
		
		
		return result;
	}
	
	
}
