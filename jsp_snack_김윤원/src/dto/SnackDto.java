package dto;

public class SnackDto {
	private String id , name, company, date ;
	private int price ;
	private String company_name;
	public SnackDto(String id, String name, String company, int price,String date ) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.date = date;
		this.price = price;
	}
	
	
	public String getCompany_name() {
		return company_name;
	}


	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	public SnackDto(String id, String name,String company_name, String company, int price, String date  ) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.date = date;
		this.price = price;
		this.company_name = company_name;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	} 
	
}
