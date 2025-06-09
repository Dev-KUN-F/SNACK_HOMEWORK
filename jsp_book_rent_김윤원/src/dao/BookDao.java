package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnection;
import dto.BookDto;





public class BookDao {
	Connection 			con = null;
	PreparedStatement 	ps  = null;
	ResultSet 			rs  = null;
	
	public ArrayList<BookDto> getBookList( String search) {
		// TODO Auto-generated method stub
		
		BookDto dto = null;
		ArrayList<BookDto> dtos = new ArrayList<BookDto>();
		String sql ="SELECT b_code, b_name, publisher, writer , to_char(reg_date, 'yyyy-MM-DD') as reg_date , rentable\r\n" + 
				"FROM book_김윤원 \r\n" 
				 ;
		
				if(search != "") sql+= "where b_name like '%"+search+"%'  \r\n";
				
				sql += "order by b_code";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String b_code = rs.getString("b_code");
				String b_name = rs.getString("b_name");
				String publisher = rs.getString("publisher");
				String writer = rs.getString("writer");
				String reg_date = rs.getString("reg_date");
				String rent_able = rs.getString("rentable");
				
				dto = new BookDto(b_code, b_name, publisher, writer,reg_date, rent_able);
				dtos.add(dto);
			}
				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getBookList() 오류 : "+ sql);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		System.out.println("getBookList() 오류 : "+ sql);
		
		return dtos;
		
	}
	
	
	public String checkLastBcode() {
		String result = "";
		
		String sql = "select max(b_code) from book_김윤원";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				 result = rs.getString("max(b_code)");
				
				
			}
				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("checkLastBcode() 오류 : "+ sql);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	
	public int bookSave(BookDto dto) {
		// TODO Auto-generated method stub
		int result = 0;
		
		String sql = "insert into book_김윤원\r\n" + 
				"(b_code, b_name, publisher, writer, reg_date ,rentable)\r\n" + 
				"values\r\n" + 
				"('"+dto.getB_code()+"','"+dto.getB_name()+"','"+dto.getPublisher()+"','"+dto.getWriter()+"','"+dto.getReg_date()+"','"+dto.getRent_able()+"')";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("bookSave() 오류 : " + sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	
	public int deleteBook(String bcode) {
		// TODO Auto-generated method stub
		int result = 0;
		
		String sql = "delete from book_김윤원 \r\n" + 
				"\r\n" + 
				"where b_code = '"+bcode+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("deleteBook() 오류 : " + sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
		
	}
	
	

	public BookDto getBookInfo(String bcode) {
		// TODO Auto-generated method stub
		BookDto dto = null;
		String sql ="SELECT b_code, b_name, publisher, writer , to_char(reg_date, 'yyyy-MM-DD') as reg_date , rentable\r\n" + 
				"FROM book_김윤원 \r\n" + 
				
				 "where b_code = '"+bcode+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String b_code = rs.getString("b_code");
				String b_name = rs.getString("b_name");
				String publisher = rs.getString("publisher");
				String writer = rs.getString("writer");
				String reg_date = rs.getString("reg_date");
				String rent_able = rs.getString("rentable");
				
				
				dto = new BookDto(b_code, b_name, publisher, writer,reg_date, rent_able);
				
			}
				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getBookInfo() 오류 : "+ sql);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}
	
	public int updateBook(BookDto dto) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql =  "update book_김윤원\r\n" + 
				"set b_name = '"+dto.getB_name()+"',\r\n" + 
				"    publisher = '"+dto.getPublisher()+"', \r\n" + 
				"    writer = '"+dto.getWriter()+"', \r\n" + 
				"    reg_date = '"+dto.getReg_date()+"' \r\n" + 
				"    where b_code = '"+dto.getB_code()+"'";
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
	
	public String checkLastRcode() {
		String result = "";
		
		String sql = "select max(r_code) from book_rent_김윤원";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				 result = rs.getString("max(r_code)");
				
				
			}
				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("checkLastBcode() 오류 : "+ sql);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	
	public ArrayList<BookDto> getMemberList() {
		// TODO Auto-generated method stub
		ArrayList<BookDto> dtos = new ArrayList<>();
		//sql query
		String sql =  "select id, name \r\n" + 
				  "from member_김윤원 \r\n"+
				  "order by id";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				
				BookDto dto = new BookDto(id, name);
				
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getMemberList() : "+ sql);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dtos;
	}
	
	
	public int rentBook(String rcode, String bcode,String mid ,String rentDate) {
		// TODO Auto-generated method stub
		int result = 0;
		
		String sql = "insert into book_rent_김윤원\r\n" + 
				"(r_code, b_code, m_id, rent_date)\r\n" + 
				"values\r\n" + 
				"('"+rcode+"','"+bcode+"','"+mid+"','"+rentDate+"')";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
			
			result += rentedBook(bcode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("rentbook() 오류 : " + sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	
	public int rentedBook(String b_code) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql =  "update book_김윤원\r\n" + 
				"set rentable = 'n'\r\n" + 
				
				"    where b_code = '"+b_code+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("rentedBook() 오류 : " + sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		
		return result;
	}
	
	public int checkRent(String bcode) {
		// TODO Auto-generated method stub
		int count = 0;
		
		String sql ="SELECT b_code\r\n" + 
				"FROM book_rent_김윤원 \r\n" 
				 ;
		
				
				
				sql += "order by b_code";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String b_code = rs.getString("b_code");
				
				if(b_code.equals(bcode)) {
					count++;
				}
				
			}
				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("checkRent() 오류 : "+ sql);
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		
		return count;
		
	}
}
