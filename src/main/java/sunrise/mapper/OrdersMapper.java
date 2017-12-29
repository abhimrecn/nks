package sunrise.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sunrise.beans.Orders;

public class OrdersMapper  implements RowMapper<Orders> {

	@Override
	public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Orders o=new Orders();
		o.setOrderID(rs.getInt(1));
		o.setProductName(rs.getString(4));
		o.setQuantity(rs.getInt(2));
		return o;
	}

	

	
}
