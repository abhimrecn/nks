package nks.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import nks.DAO.CustomerDAO;
import nks.beans.Customer;
import nks.beans.Login;
import nks.mapper.CustomerMapper;


public class CustomerDAOimpl implements CustomerDAO {

	@Autowired
	protected JdbcTemplate jdbcTemplate;  

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public int saveCustomer(Customer c) {
		String Query="insert into customer (CustId,Fname,Lname,Gender,Email,ContactNo,State,City,Address,Pincode,password) values(?,?,?,?,?,?,?,?,?,?,?) ";
		return jdbcTemplate.update(Query, new Object[]{c.getCustId(),c.getFname(),c.getLname(),c.getGender(),c.getEmail(),c.getContactNo(),c.getState(),c.getCity(),c.getAddress(),c.getPincode(),c.getPassword()});
	
	}

	@Override
	public int loginCustomer(Login login) {
		String Query1="insert into Login values(?,?,?)";
		return jdbcTemplate.update(Query1, new Object[]{login.getUsername(),login.getPassword(),3});
		
	}
	
	

	
	@Override
	public int updateCustomer(Customer c) {
String Query= "update customer set Fname='"+c.getFname()+"', Lname='"+c.getLname()+"',Email='"+c.getEmail()+"',ContactNo='"+c.getContactNo()+"',Address='"+c.getAddress()+"' where CustId='"+c.getCustId()+"'";
		
		System.out.println(Query);
		return jdbcTemplate.update(Query);
		
	}


	@Override
	public int deleteCustomer(String Uid) {
		String Query="delete from customer where CustId=?";
		return jdbcTemplate.update(Query, new Object[]{Uid});
	}

	@Override
	public Customer findCustomer(String Uid) {
		String Query="select * from customer where CustId=?";
		Customer cust=new Customer();
		List<Customer> c=jdbcTemplate.query(Query,new Object[]{Uid}, new CustomerMapper());
		for(Customer c1:c)
		{
			
			cust=c1;
		}
		return cust;
	}

	//add new
		@Override
		public int changepassword(String username,String newpassword) {
			
			System.out.println("Employee change password");
			String Query="update login set Password='"+newpassword+"' where Uid='"+username+"'";
			System.out.println(Query);
			return jdbcTemplate.update(Query);
			
		}

	
	
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		String Query="select * from customer";
		return jdbcTemplate.query(Query, new CustomerMapper());
	}
	@Override
	public int addServiceArea(int pin, String state, String City) {
		
		String Query = "insert into servicearea values ("+ pin +",'"+state +"', '"+ City+"')";
		
		return jdbcTemplate.update(Query);
	}




}
