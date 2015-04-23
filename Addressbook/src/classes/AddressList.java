package classes;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AddressList {
	private String searchQuery = "";
	private List<Address> list;
	public AddressList() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Address> getList() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException{
		String query = "Select * from address";
		
		if(!getSearchQuery().isEmpty()){
			query += "where " + getSearchQuery();
		}
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook?user=root&password=password");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		list = new ArrayList<>();
		while (rs.next()){
			Address temp = new Address();
			temp.setId(rs.getInt("id"));
			temp.setName(rs.getString("name"));
			temp.setChristianName(rs.getString("christianname"));
			temp.setAddressform(rs.getString("addressform"));
			temp.setEmail(rs.getString("email"));
			temp.setPhone(rs.getString("phone"));
			temp.setMobile(rs.getString("mobile"));
			temp.setStreet(rs.getString("street"));
			temp.setNumber(rs.getInt("number"));
			temp.setCity(rs.getString("city"));
			temp.setPostcode(rs.getString("postcode")); 
			temp.setCountry(rs.getString("country"));
			if(rs.getString("birthday")!= null){
				temp.setBirthday(parseDate(rs.getString("birthday"))); 
			}
			list.add(temp);
		}
		rs.close();
		stmt.close();
		conn.close();
		return list;
	}
	
	public void delete(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook?user=root&password=password");
		Statement stmt = conn.createStatement();
		stmt.execute("Delete from address where id =" +id);
		stmt.close();
		conn.close();
	}
	public Date parseDate(String date) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		java.util.Date parsed = format.parse(date);
		return new java.sql.Date(parsed.getTime());
	}
	public String getSearchQuery() {
		return searchQuery;
	}
	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

}
