package nks.beans;

public class Admin {
private String Aid,Fname,Lname,Email,ContactNo,Address;
private String Gender;
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
public Admin(String aid, String fname, String lname, String email, String contactNo, String address, String gender) {
	super();
	Aid = aid;
	Fname = fname;
	Lname = lname;
	Email = email;
	ContactNo = contactNo;
	Address = address;
	Gender = gender;
}
public String getAid() {
	return Aid;
}
public void setAid(String aid) {
	Aid = aid;
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
	return "Admin [Aid=" + Aid + ", Fname=" + Fname + ", Lname=" + Lname + ", Email=" + Email + ", ContactNo="
			+ ContactNo + ", Address=" + Address + ", Gender=" + Gender + "]";
}


}
