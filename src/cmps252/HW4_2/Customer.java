package cmps252.HW4_2;
public class Customer {
	private String FirstName;
	private String LastName;
	private String Company;
	private String Address;
	private String City;
	private String County;
	private String State;
	private String ZIP;
	private String Phone;
	private String Fax;
	private String Email;
	private String Web;
	
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCounty() {
		return County;
	}

	public void setCounty(String county) {
		County = county;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZIP() {
		return ZIP;
	}

	public void setZIP(String zIP) {
		ZIP = zIP;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getWeb() {
		return Web;
	}

	public void setWeb(String web) {
		Web = web;
	}
	
	Customer(String first,String last,String company,String address,String city,String county,String state,String zip,String phone,String fax,String email,String web){
		this.FirstName = first;
		this.LastName = last;
		this.Company = company;
		this.Address = address;
		this.City = city;
		this.County = county;
		this.State = state;
		this.ZIP = zip;
		this.Phone = phone;
		this.Fax = fax;
		this.Email = email;
		this.Web = web;
	}
	
	
	public void print() {
		System.out.println(""+this.getFirstName()+", "+this.getLastName()+"; "+this.getCompany()+
				"; "+this.getAddress()+"; "+this.getCity()+"; "+this.getCounty()+
				"; "+this.getState()+"; "+this.getZIP()+"; "+this.getPhone()+
				"; "+this.getFax()+"; "+this.getEmail()+"; "+this.getWeb()+"\n");
	}

}
