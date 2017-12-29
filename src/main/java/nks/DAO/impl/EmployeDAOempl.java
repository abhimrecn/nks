package nks.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import nks.DAO.EmployeeDAO;
import nks.beans.Employee;
import nks.beans.Login;
import nks.beans.Order;
import nks.beans.Orders;
import nks.mapper.EmployeeMapper;
import nks.mapper.OrderMapper;
import nks.mapper.OrdersMapper;

public class EmployeDAOempl implements EmployeeDAO {

	@Autowired
	protected JdbcTemplate jdbcTemplate;  

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int saveEmployee(Employee e) {
		String Query= "insert into employee (Eid,Fname,Lname,Email,ContactNo,Address,Gender) values ('"+e.getEid()+"','"+e.getFname()+"','"+e.getLname()+"','"+e.getEmail()+"','"+e.getContactNo()+"','"+e.getAddress()+"','"+e.getGender()+"')";
		return jdbcTemplate.update(Query);
	}

	@Override
	public int loginCustomer(Login login) {
		String Query1="insert into Login values(?,?,?)";
		return jdbcTemplate.update(Query1, new Object[]{login.getUsername(),login.getPassword(),2});
		
	}
	@Override
	public int updateEmployee(Employee e) {
		String Query= "update employee set Fname='"+e.getFname()+"', Lname='"+e.getLname()+"',Email='"+e.getEmail()+"',ContactNo='"+e.getContactNo()+"',Address='"+e.getAddress()+"' where Eid='"+e.getEid()+"'";
		
		System.out.println(Query);
		return jdbcTemplate.update(Query);
	}


	@Override
	public int deleteEmployee(String  Eid) {
		
		String q = "delete from login where Uid=?";
		jdbcTemplate.update(q, new Object[]{Eid});
		String Query="update employee set Fname='0' where Eid=?";
		 return jdbcTemplate.update(Query, new Object[]{Eid});
	}

	@Override
	public Employee findEmployee(String name) {
		String Query="select * from employee where Eid=? and Fname!='0' ";
		return jdbcTemplate.queryForObject(Query, new Object[]{name}, new EmployeeMapper());
	}

	@Override
	public List<Employee> getAllEmployee() {
		String Query="select * from employee where Fname!='0' ";
		return jdbcTemplate.query(Query, new EmployeeMapper());
	}

	
	
	
	@Override
	public List<Order> getPackingOrders(String name) {
		// TODO Auto-generated method stub
		String Query="select * from order where PackingEmploye=?";
		return jdbcTemplate.query(Query,new Object[]{name}, new OrderMapper());
	}
	
	
	@Override
	public int changepassword(String username,String newpassword) {
		
		System.out.println("Employee change password");
		String Query="update login set Password='"+newpassword+"' where Uid='"+username+"'";
		System.out.println(Query);
		return jdbcTemplate.update(Query);
		
	}

	@Override
	public List<Orders> getWorkDetails(String username) {
		System.out.println("WooooooooooKs");
		
		String Query="select * from Workdetails where PackingEmploye='"+username+"'";
		System.out.println(Query);
		return jdbcTemplate.query(Query, new OrdersMapper());
	}
	


}
