package sunrise.DAO;

import java.util.List;

import sunrise.beans.Employee;
import sunrise.beans.Login;
import sunrise.beans.Order;
import sunrise.beans.Orders;

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
