/*package nks.beans;


public class Customer {
	private String CustId,Fname,Lname,Email,ContactNo,State,City,Address;
	private String Gender;
	private int Pincode;


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCustId() {
		return CustId;
	}
	public void setCustId(String custId) {
		CustId = custId;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getPincode() {
		return Pincode;
	}
	public void setPincode(int pincode) {
		Pincode = pincode;
	}
	public Customer(String custId, String fname, String lname, String email, String contactNo, String state,
			String city, String address, String gender, int pincode) {
		super();
		CustId = custId;
		Fname = fname;
		Lname = lname;
		Email = email;
		ContactNo = contactNo;
		State = state;
		City = city;
		Address = address;
		Gender = gender;
		Pincode = pincode;
	}
	
	
	
	public Customer(String custId, String fname, String lname, String email, String contactNo, String address,
			int pincode) {
		super();
		CustId = custId;
		Fname = fname;
		Lname = lname;
		Email = email;
		ContactNo = contactNo;
		Address = address;
		Pincode = pincode;
	}
	@Override
	public String toString() {
		return "Customer [CustId=" + CustId + ", Fname=" + Fname + ", Lname=" + Lname + ", Email=" + Email
				+ ", ContactNo=" + ContactNo + ", State=" + State + ", City=" + City + ", Address=" + Address
				+ ", Gender=" + Gender + ", Pincode=" + Pincode + "]";
	}
	
	

}
*/


// Project v2

package nks.beans;


public class Customer {
	private String CustId,Fname,Lname,Email,ContactNo,State,City,Address,password , country;
	private String Gender;
	private int Pincode;


	public Customer(String custId, String fname, String lname, String email, String contactNo, String state,
			String city, String address, String country,String password,  int pincode) {
		super();
		CustId = custId;
		Fname = fname;
		Lname = lname;
		Email = email;
		ContactNo = contactNo;
		State = state;
		City = city;
		Address = address;
		this.password = password;
		this.country = country;
		
		Pincode = pincode;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getCustId() {
		return CustId;
	}
	public void setCustId(String custId) {
		CustId = custId;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getPincode() {
		return Pincode;
	}
	public void setPincode(int pincode) {
		Pincode = pincode;
	}
	public Customer(String custId, String fname, String lname, String email, String contactNo, String state,
			String city, String address, String gender, int pincode , String pwd) {
		super();
		CustId = custId;
		Fname = fname;
		Lname = lname;
		Email = email;
		ContactNo = contactNo;
		State = state;
		City = city;
		Address = address;
		Gender = gender;
		Pincode = pincode;
		password = pwd;
	}
	
	
	
	public Customer(String custId, String fname, String lname, String email, String contactNo, String address,
			int pincode) {
		super();
		CustId = custId;
		Fname = fname;
		Lname = lname;
		Email = email;
		ContactNo = contactNo;
		Address = address;
		Pincode = pincode;
	}



	@Override
	public String toString() {
		return "Customer [CustId=" + CustId + ", Fname=" + Fname + ", Lname=" + Lname + ", Email=" + Email
				+ ", ContactNo=" + ContactNo + ", State=" + State + ", City=" + City + ", Address=" + Address
				+ ", password=" + password + ", country=" + country + ", Gender=" + Gender + ", Pincode=" + Pincode
				+ "]";
	}
	
	
	
	

}
