package nks.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nks.beans.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Product p=new Product();
		p.setId(rs.getInt(1));
		p.setName(rs.getString(2));
		p.setProdCatId(rs.getInt(3));
		p.setSubCatId(rs.getInt(4));
		p.setQunatdesc(rs.getString(5));
		p.setMaxquant(rs.getInt(6));
		p.setPrice(rs.getFloat(7));
		p.setShortDesc(rs.getString(8));
		p.setDetailedDesc(rs.getString(9));
		p.setImage(rs.getString(10));
		return p;
	}

}
