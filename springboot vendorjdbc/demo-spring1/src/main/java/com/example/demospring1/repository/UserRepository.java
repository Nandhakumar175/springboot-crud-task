package com.example.demospring1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demospring1.dto.User;

@Repository
public class UserRepository {
	private static Connection connection;

	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/mysql_demo_tnj", "mysql_demo_tnj",
				"Ebrain@20");
		return connection;


	}

	public void save(User user) throws Exception {
		Connection connection = getConnection(); // GetConnection
		String insertQuery = "insert into tb_nandha_vendor(vendor_name,contact_name,contact_title,contact_phone,contact_email,address,city,state,zip_code,country,payment_terms,payment_method,tax_id_number,notes) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery); // GetPreparedStatement
		preparedStatement.setString(1, user.getVendorname());
		preparedStatement.setString(2, user.getContactname());
		preparedStatement.setString(3, user.getContacttitle());
		preparedStatement.setString(4, user.getContactphone());
		preparedStatement.setString(5, user.getContactemail());
		preparedStatement.setString(6, user.getAddress());
		preparedStatement.setString(7, user.getCity());
		preparedStatement.setString(8, user.getState());
		preparedStatement.setString(9, user.getZip_code());
		preparedStatement.setString(10, user.getCountry());
		preparedStatement.setString(11, user.getTaxidnumber());
		preparedStatement.setString(12, user.getPaymentterms());
		preparedStatement.setString(13, user.getPaymentmethod());
		preparedStatement.setString(14, user.getNotes());
		
		// Save User object by calling executeupdate
		preparedStatement.executeUpdate();

	}

	public List<User> getAll() throws SQLException, ClassNotFoundException {
		// Connection connection = getConnection();//GetConnection
		Connection con = getConnection();
		String selectQuery = "select * from tb_nandha_vendor";

		PreparedStatement ps = con.prepareStatement(selectQuery);

		ResultSet resultSet = ps.executeQuery();

		List<User> obj = new ArrayList<User>();
		User user = null;
		while (resultSet.next()) {
			user = new User();
			
			
			obj.add(user);
			user.setVendorid(resultSet.getInt(1));
			user.setVendorname(resultSet.getString(2));
			user.setContactname(resultSet.getString(3));
			user.setContacttitle(resultSet.getString(4));
			user.setContactphone(resultSet.getString(5));
			user.setContactemail(resultSet.getString(6));
			user.setAddress(resultSet.getString(7));
			user.setCity(resultSet.getString(8));
			user.setState(resultSet.getString(9));
			user.setZip_code(resultSet.getString(10));
			user.setCountry(resultSet.getString(11));
			user.setTaxidnumber(resultSet.getString(12));
			user.setPaymentterms(resultSet.getString(13));
			user.setPaymentmethod(resultSet.getString(14));
			user.setNotes(resultSet.getString(15));
		}
		return obj;
	}

	public List<User> getById(Integer vendorid) throws SQLException, ClassNotFoundException {
		// Connection connection = getConnection();//GetConnection
		Connection con = getConnection();
		String selectQuery = "select * from tb_nandha_vendor where vendor_id = '" + vendorid + "'";

		PreparedStatement ps = con.prepareStatement(selectQuery);

		ResultSet resultSet = ps.executeQuery();

		List<User> obj = new ArrayList<User>();
		User user = null;
		while (resultSet.next()) {
			user = new User();
			user.setVendorid(resultSet.getInt(1));
			user.setVendorname(resultSet.getString(2));
			user.setContactname(resultSet.getString(3));
			user.setContacttitle(resultSet.getString(4));
			user.setContactphone(resultSet.getString(5));
			user.setContactemail(resultSet.getString(6));
			user.setAddress(resultSet.getString(7));
			user.setCity(resultSet.getString(8));
			user.setState(resultSet.getString(9));
			user.setZip_code(resultSet.getString(10));
			user.setCountry(resultSet.getString(11));
			user.setTaxidnumber(resultSet.getString(12));
			user.setPaymentterms(resultSet.getString(13));
			user.setPaymentmethod(resultSet.getString(14));
			user.setNotes(resultSet.getString(15));
			obj.add(user);
		}
		return obj;
	}

	public void delete(Integer vendorid) throws SQLException, ClassNotFoundException {
		// Connection connection = getConnection();//GetConnection
		Connection con = getConnection();
		String selectQuery = "delete from tb_nandha_vendor where vendor_id = '" + vendorid + "'";

		PreparedStatement ps = con.prepareStatement(selectQuery);

		int resultSet = ps.executeUpdate();
		//ps.setLong(1, resultSet.getInt(1));
		

	}

	public void update(User user) throws Exception {
		Connection connection = getConnection(); // GetConnection
		String insertQuery = "update tb_nandha_vendor set vendor_name = ?,contact_name = ?,contact_title = ?,contact_phone = ?,contact_email = ?,address = ?,city = ?,state = ?,zip_code = ?,country=?,tax_id_number=?,payment_terms=?,payment_method=?,notes=? where vendor_id = ?";
		PreparedStatement ps = connection.prepareStatement(insertQuery);
		ps.setString(1, user.getVendorname());
		ps.setString(2, user.getContactname());
		ps.setString(3, user.getContacttitle());
		ps.setString(4, user.getContactphone());
		ps.setString(5, user.getContactemail());
		ps.setString(6, user.getAddress());
		ps.setString(7, user.getCity());
		ps.setString(8, user.getState());
		ps.setString(9, user.getZip_code());
		ps.setString(10, user.getCountry());
		ps.setString(11, user.getTaxidnumber());
		ps.setString(12, user.getPaymentterms());
		ps.setString(13, user.getPaymentmethod());
		ps.setString(14, user.getNotes());
		ps.setInt(15, user.getVendorid());
		ps.executeUpdate();

	}

}
