package classes;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Address {
	private int id;
	private String name;
	private String christianName;
	private String addressform;
	private String email;
	private String phone;
	private String mobile;
	private String street;
	private int number;
	private String city;
	private String postcode;
	private String country;
	private Date birthday;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public int save() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook?user=root&password=password");
		Statement stmt = conn.createStatement();
		stmt.execute("Insert Into address (name, christianname, addressform, email, phone, mobile, street, number, city, postcode, country, birthday) values("+'"'+getName()+'"' +"," +'"'+getChristianName()+'"' +"," +'"'+getAddressform()+'"' +"," +'"'+getEmail()+'"' +"," +'"'+getPhone()+'"' +"," +'"'+getMobile()+'"' +"," +'"'+getStreet()+'"' +"," +'"'+getNumber()+'"' +"," +'"'+getCity()+'"' +"," +'"'+getPostcode()+'"' +"," +'"'+getCountry()+'"' +"," +'"'+getBirthday()+'"' +")", Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = stmt.getGeneratedKeys();
		int generatedID = 0;
		while (rs.next()){
			generatedID = rs.getInt(1);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		return generatedID;
		
	}
	
	public Boolean read(String sId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ParseException{
		int id = Integer.parseInt(sId);
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook?user=root&password=password");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from address where id=" +id);
		Boolean empty = true;
		while (rs.next()){
			empty=false;
			this.id = Integer.parseInt(rs.getString("id"));
			this.name = rs.getString("name");
			this.christianName = rs.getString("christianname");
			this.addressform = rs.getString("addressform");
			this.email = rs.getString("email");
			this.phone = rs.getString("phone");
			this.mobile = rs.getString("mobile");
			this.street = rs.getString("street");
			this.number = Integer.parseInt(rs.getString("number"));
			this.city = rs.getString("city");
			this.postcode = rs.getString("postcode");
			this.country = rs.getString("country");
			this.birthday = parseDate(rs.getString("birthday"));
		}
		if(empty){
			return false;
		}
		
		rs.close();
		stmt.close();
		conn.close();
		return true;
	}

	public Date parseDate(String date) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		java.util.Date parsed = format.parse(date);
		return new java.sql.Date(parsed.getTime());
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChristianName() {
		return christianName;
	}

	public void setChristianName(String christianName) {
		this.christianName = christianName;
	}

	public String getAddressform() {
		return addressform;
	}

	public void setAddressform(String addressform) {
		this.addressform = addressform;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	

}
