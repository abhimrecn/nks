package sunrise.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sunrise.beans.Order;

public class OrderMapper implements RowMapper<Order>{

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		
		Order o=new Order();
		o.setOrderID(rs.getInt(1));
		o.setCustId(rs.getString(2));
		o.setStartDate(rs.getDate(3));
		o.setEndDate(rs.getDate(4));
		o.setPackingEmploye(rs.getString(5));
		return null;
	}

}
