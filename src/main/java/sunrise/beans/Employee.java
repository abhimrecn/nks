package sunrise.beans;

public class Employee {

	private String Eid,Fname,Lname,Email,ContactNo,Address,Gender;

	public Employee(String eid, String fname, String lname, String email, String contactNo, String address,
			String gender) {
		super();
		Eid = eid;
		Fname = fname;
		Lname = lname;
		Email = email;
		ContactNo = contactNo;
		Address = address;
		Gender = gender;
	}
	

	


	public Employee(String eid, String fname, String lname, String email, String contactNo, String address) {
		super();
		Eid = eid;
		Fname = fname;
		Lname = lname;
		Email = email;
		ContactNo = contactNo;
		Address = address;
	}





	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEid() {
		return Eid;
	}

	public void setEid(String eid) {
		Eid = eid;
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

	@Override
	public String toString() {
		return "Employee [Eid=" + Eid + ", Fname=" + Fname + ", Lname=" + Lname + ", Email=" + Email + ", ContactNo="
				+ ContactNo + ", Address=" + Address + ", Gender=" + Gender + "]";
	}

	
	
	
	
}
