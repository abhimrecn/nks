package nks.DAO;

import java.util.List;

import nks.beans.Customer;
import nks.beans.Login;

public interface CustomerDAO {
	public int saveCustomer(Customer c);
	public int updateCustomer(Customer c);
	public int deleteCustomer(String Uid);
	public Customer findCustomer(String Uid);
	public List<Customer> getAllCustomer();
	public int changepassword(String username, String newpassword);
	public int addServiceArea(int pin, String state, String City);
	public int loginCustomer(Login login);	
	}
