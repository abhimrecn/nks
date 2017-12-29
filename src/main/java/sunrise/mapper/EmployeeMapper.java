package sunrise.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sunrise.beans.Employee;



public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee e = new Employee();
				e.setEid(rs.getString(1));
				e.setFname(rs.getString(2));
				e.setLname(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setContactNo(rs.getString(5));
				e.setAddress(rs.getString(6));
				e.setGender(rs.getString(7));
		return e;
	}

}
