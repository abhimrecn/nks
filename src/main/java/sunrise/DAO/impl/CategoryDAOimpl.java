package sunrise.DAO.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sunrise.DAO.CategoryDAO;
import sunrise.beans.ProdSubCat;
import sunrise.beans.Prodcategory;
import sunrise.mapper.categoryMapper;

public class CategoryDAOimpl implements CategoryDAO {

	@Autowired
	protected JdbcTemplate jdbcTemplate;  

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int create(Prodcategory cat) {
		// TODO Auto-generated method stub
		 String query="insert into prodcategory values("+cat.getCatID()+",'"+cat.getName()+"')";  
		 System.out.println(query);
		 return jdbcTemplate.update(query);  
	}

	@Override
	public Prodcategory find1(int id) {
		System.out.println("from prodcategory dao");
		String SQL="select * from  prodcategory where CatId=?";
		System.out.println(SQL);
		Prodcategory category=jdbcTemplate.queryForObject(SQL,new Object[] {id},new categoryMapper());
		return category;
	}

	@Override
	public List<String> getAllProductCategories() {
		// TODO Auto-generated method stub
		String sql="Select name from prodcats";
		return jdbcTemplate.query(sql, new RowMapper<String>(){  
			
			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				String s=new String();
				s=rs.getString(1);
				return s;
			}  
			
		    });  
	}

	@Override
	public List<String> getSubCategories(String prodCat) {
		String query="SELECT * FROM prodsubcat ps, prodcats p WHERE ps.ProdcatId=p.id AND p.name=?";
		
		 return jdbcTemplate.query(query,new Object[] {prodCat} ,new RowMapper<String>(){  
			
			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				String s=new String();
				s=rs.getString(2);
				return s;
			}  
			
		    });  
	}

	@Override
	public Hashtable<String, List<String>> GetCategoryAndSubCategory() {
		
		List<String> l1=getAllProductCategories();
		
		Hashtable<String,List<String>> hm=new Hashtable<String,List<String>>();  
		for(String str:l1)
		{
			hm.put(str, getSubCategories(str));
			
		}
		return hm;
	}

	
	@Override
	public List<Prodcategory> GetAllMainProductCAtegories() {
		// TODO Auto-generated method stub
		String sql="Select * from prodcats";
		
		return jdbcTemplate.query(sql, new categoryMapper());
	}

	@Override
	public List<Prodcategory> getSubCategories_In_Id__Name_Format(String prodCat) {
		String Query="SELECT * FROM prodsubcat ps, prodcats pc WHERE ps.Prodcatid=pc.id AND pc.Name=?";
		System.out.println(Query);
		return jdbcTemplate.query(Query ,new Object[]{prodCat},new categoryMapper());
		
		 
	}

	@Override
	public List<Prodcategory> getSubCategories_By_Main_category_id(int prodCat) {
		String Query="SELECT * FROM prodsubcat ps, prodcats pc WHERE ps.Prodcatid=pc.id AND pc.Id=?";
		return jdbcTemplate.query(Query ,new Object[]{prodCat},new categoryMapper());
	}

	@Override
	public Hashtable<Prodcategory, List<Prodcategory>> GetCategoryAndSubCategory_in_Id_Name_Format() {
		
		Hashtable<Prodcategory, List<Prodcategory>> ht=new Hashtable<Prodcategory, List<Prodcategory>>();
		List<Prodcategory> list=GetAllMainProductCAtegories();
		for(Prodcategory p:list)
		{
			ht.put(p, getSubCategories_By_Main_category_id(p.getCatID()));
		}
		
		return ht;
	}	
	
	
	
	@Override
	public List<ProdSubCat> getSubProductCategories(int prodCat) {
		
		String Query="select * from prodsubcat where ProdCatId=?";

		return jdbcTemplate.query(Query,new Object[] {prodCat} ,new RowMapper<ProdSubCat>(){  
			
			@Override
			public ProdSubCat mapRow(ResultSet rs, int arg1) throws SQLException {
				
				ProdSubCat prodSub = new ProdSubCat();
				prodSub.setId(rs.getInt(1));
				prodSub.setName(rs.getString(2));
				prodSub.setProdCatId(rs.getInt(3));
				
				return prodSub;
			}  
			
		    });
	}

	@Override
	public String GetCategory_and_SubCategory_toShow() {
		List<Prodcategory> list=new ArrayList<Prodcategory>();
		Hashtable<Prodcategory, List<Prodcategory>> hm=GetCategoryAndSubCategory_in_Id_Name_Format();
		String str="";
		
			int i=0;
				for(Map.Entry m:hm.entrySet())
				{  
					Prodcategory p=(Prodcategory) m.getKey();
					str+="<li class='subMenu";
							if(i==0)
							{
								str+=" open";			
							};
					str+="'><a>"+p.getName()+"</a>";
					str+="<ul";
					if(i!=0)
					{
						str+=" style='display:none'";
					};
					str+=">";
					   list=(List<Prodcategory>) m.getValue();
					   str+="<li><a class='ProdCategory' href='#showInfo' value='"+p.getCatID()+"'><i class='icon-chevron-right'></i>All </a></li>";
					   for(Prodcategory cat:list)
					   {
							str+="<li><a  class='active' href='#showInfo' value='"+cat.getCatID()+"'><i class='icon-chevron-right'></i>"+cat.getName()+" </a></li>";
					   }
					   
					  str+="</ul>";
					  str+="</li>";
					  i++;
				}  
		//str+="</ul><br/></div>";
		//System.out.println(str);
		return str;
	}	
	
	
	@Override
	public int saveCatgory(String p) {
		String Query="insert into prodcats(Name) values('"+ p +"')";
		
		return jdbcTemplate.update(Query);
	}

	@Override
	public int saveSubCategory(String name,int id) {
		String Query="insert into prodsubcat(Name,ProdCatId) values('"+ name +"',"+id+")";
		
		return jdbcTemplate.update(Query);
	}

	@Override
	public int getProductCategoryID(String id) {
		String Query="select * from prodcats where Name=?";
		
		return (Integer)getJdbcTemplate().queryForObject(Query, new Object[] { id }, Integer.class);
		
	}	
	


	

}
