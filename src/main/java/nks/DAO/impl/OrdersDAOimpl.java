package nks.DAO.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import nks.DAO.OrdersDAO;
import nks.beans.Customer;
import nks.beans.Order;
import nks.beans.Product;


public class OrdersDAOimpl implements OrdersDAO {
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;  
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<Order> getALLOrders() {
		String Query="select * from orders ";
		return jdbcTemplate.query(Query, new RowMapper<Order>(){  
			
			@Override
			public Order mapRow(ResultSet rs, int arg1) throws SQLException {
				
				Order ord  = new Order(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5));
				
				return ord;
			}  
			
		    });
	}

	@Override
	public int assignTask(int Pid, String EmpName) {
		
		String Query = "UPDATE `sunrise`.`orders` SET `PackingEmploye` = '"+EmpName +"' WHERE `OrderID` = '"+ Pid +"' ";
		return jdbcTemplate.update(Query);
		
	}

	@Override
	public int PlaceOrder(String d1, String d2,int days, TreeMap<Product, Integer> t,Customer c) {
		// TODO Auto-generated method stub
		
		String Query="INSERT INTO orders (`CustId`, `StartDate`, `EndDate`) VALUES (?, ?, ?)";
		jdbcTemplate.update(Query, new Object[]{c.getCustId(),d1,d2});
		
		
		String Query2="SELECT MAX(orderid) FROM orders";
		int id=jdbcTemplate.queryForInt(Query2);
		System.out.println("id of the order is "+id);
		
		String Query3="INSERT INTO orderdetails (OrderID, ProductID, Quntity, TotaPrice) VALUES (?, ?, ?, ?)";
		
		for(Map.Entry<Product, Integer> entry:t.entrySet()){  
	    	Product p=entry.getKey();
	    	int quantity=entry.getValue();
	    	jdbcTemplate.update(Query3, new Object[]{id,p.getId(),quantity,p.getPrice()*quantity});
		}
		
		
		return 1;
	}

}
