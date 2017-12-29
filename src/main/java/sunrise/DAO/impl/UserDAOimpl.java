package sunrise.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import sunrise.DAO.UserDAO;
import sunrise.beans.User;
import sunrise.mapper.UserMapper;

public class UserDAOimpl implements UserDAO{


	@Autowired
	protected JdbcTemplate jdbcTemplate;  

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User find(String username, String password) {
		
		System.out.println("from dao login");
		String SQL="select * from login where Uid=? AND Password=?";
		User user=jdbcTemplate.queryForObject(SQL,new Object[] {username,password},new UserMapper());	
		return user;
	}

	
	@Override
	public int CheckExistance(String username, String password) {
		String query="SELECT COUNT(*) FROM login WHERE Uid=? AND PASSWORD=?";
		
		return jdbcTemplate.queryForInt(query, new Object[] {username,password});
	}
}
