package nks.DAO.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import nks.DAO.AdminDAO;
import nks.beans.Admin;
import nks.mapper.AdminMapper;

public class AdminDAOimpl implements AdminDAO {

	@Autowired
	protected JdbcTemplate jdbcTemplate;  

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Admin findAdmin(String Aid) {
		String query="select * from admin where Aid=?";
		List<Admin> a= jdbcTemplate.query(query,new Object[] {Aid}, new AdminMapper());
		Admin admin=new Admin();
		for(Admin aa:a)
		{
			System.out.println(aa.getFname());
			admin=aa;
		}
		return admin;
	}

}
