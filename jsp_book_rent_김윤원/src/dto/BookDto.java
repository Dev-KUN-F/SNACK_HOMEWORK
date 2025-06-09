package dto;

import java.sql.Date;

public class BookDto {
	String b_code, b_name, publisher, writer;
	String reg_date ,rent_able;
	
	String m_id, m_name;
	
	
	
	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public BookDto(String m_id, String m_name) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
	}

	public String getRent_able() {
		return rent_able;
	}

	public void setRent_able(String rent_able) {
		this.rent_able = rent_able;
	}

	public BookDto(String b_code, String b_name, String publisher, String writer, String reg_date, String rent_able) {
		super();
		this.b_code = b_code;
		this.b_name = b_name;
		this.publisher = publisher;
		this.writer = writer;
		this.reg_date = reg_date;
		this.rent_able = rent_able;
	}
	
	

	public BookDto(String b_code, String b_name, String publisher, String writer, String reg_date) {
		super();
		this.b_code = b_code;
		this.b_name = b_name;
		this.publisher = publisher;
		this.writer = writer;
		this.reg_date = reg_date;
	}

	public String getB_code() {
		return b_code;
	}

	public void setB_code(String b_code) {
		this.b_code = b_code;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	
}
