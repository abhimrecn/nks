package nks.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nks.beans.Customer;

public class CustomerMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int Rowno) throws SQLException {
		// TODO Auto-generated method stub
		Customer c=new Customer();
		c.setCustId(rs.getString(1));
		c.setFname(rs.getString(2));
		c.setLname(rs.getString(3));
		c.setGender(rs.getString(4));
		c.setEmail(rs.getString(5));
		c.setContactNo(rs.getString(6));
		c.setState(rs.getString(7));
		c.setCity(rs.getString(8));
		c.setAddress(rs.getString(9));
		c.setPincode(rs.getInt(10));
		
		return c;
	}

}
