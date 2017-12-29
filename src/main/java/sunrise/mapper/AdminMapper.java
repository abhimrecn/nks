package sunrise.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sunrise.beans.Admin;

public class AdminMapper implements RowMapper<Admin> {

	@Override
	public Admin mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Admin a= new Admin();
		
		a.setAid(rs.getString(1));
		a.setFname(rs.getString(2));
		a.setLname(rs.getString(3));
		a.setEmail(rs.getString(4));
		a.setContactNo(rs.getString(5));
		a.setAddress(rs.getString(6));
		a.setGender(rs.getString(7));
		
		return a;
	}

}
