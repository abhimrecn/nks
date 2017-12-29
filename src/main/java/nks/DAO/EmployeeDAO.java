package nks.DAO;

import java.util.List;

import nks.beans.Employee;
import nks.beans.Login;
import nks.beans.Order;
import nks.beans.Orders;

public interface EmployeeDAO {
	public int saveEmployee(Employee e);
	//public int updateEmployee(Employee e);
	public int deleteEmployee(String eid);
	public Employee findEmployee(String name);
	public List<Employee> getAllEmployee();
	public List<Order> getPackingOrders(String name);
	
	//by sagar pr
		public List<Orders> getWorkDetails(String username);
		int changepassword(String username, String newpassword);
		public int updateEmployee(Employee e);
		public int loginCustomer(Login login);	
}
