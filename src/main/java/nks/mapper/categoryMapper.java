package nks.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nks.beans.Prodcategory;

public class categoryMapper implements RowMapper<Prodcategory>{
	public Prodcategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		Prodcategory category= new Prodcategory();
		category.setCatID(rs.getInt(1));
		category.setName(rs.getString(2));
		return category;
	}

}