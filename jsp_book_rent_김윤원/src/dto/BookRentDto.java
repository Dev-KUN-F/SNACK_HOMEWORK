package dto;

public class BookRentDto {
String r_code, b_code,b_name, m_id,m_name,rent_date,return_date;

public BookRentDto(String r_code, String b_code, String m_id, String rent_date, String return_date) {
	super();
	this.r_code = r_code;
	this.b_code = b_code;
	this.m_id = m_id;
	this.rent_date = rent_date;
	this.return_date = return_date;
}

public BookRentDto(String r_code, String b_code, String b_name, String m_id,String m_name, String rent_date, String return_date) {
	super();
	this.r_code = r_code;
	this.b_code = b_code;
	this.b_name = b_name;
	this.m_id = m_id;
	this.m_name = m_name;
	this.rent_date = rent_date;
	this.return_date = return_date;
}

public String getM_name() {
	return m_name;
}

public void setM_name(String m_name) {
	this.m_name = m_name;
}

public BookRentDto(String r_code, String b_code, String m_id, String rent_date) {
	super();
	this.r_code = r_code;
	this.b_code = b_code;
	this.m_id = m_id;
	this.rent_date = rent_date;
}

public String getR_code() {
	return r_code;
}

public void setR_code(String r_code) {
	this.r_code = r_code;
}

public String getB_code() {
	return b_code;
}

public void setB_code(String b_code) {
	this.b_code = b_code;
}

public String getM_id() {
	return m_id;
}

public void setM_id(String m_id) {
	this.m_id = m_id;
}

public String getRent_date() {
	return rent_date;
}

public void setRent_date(String rent_date) {
	this.rent_date = rent_date;
}

public String getReturn_date() {
	return return_date;
}

public void setReturn_date(String return_date) {
	this.return_date = return_date;
}

public String getB_name() {
	return b_name;
}

public void setB_name(String b_name) {
	this.b_name = b_name;
}




	
	
}
