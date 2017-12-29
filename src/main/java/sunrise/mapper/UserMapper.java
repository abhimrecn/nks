package sunrise.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sunrise.beans.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=new User();
		user.setType(rs.getInt("Type"));
		user.setUid(rs.getString("Uid"));
		user.setPassword(rs.getString("Password"));
		return user;
	}

}
