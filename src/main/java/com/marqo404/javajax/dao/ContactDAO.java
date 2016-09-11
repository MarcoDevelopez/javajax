package com.marqo404.javajax.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.marqo404.javajax.factory.ConnectionFactory;
import com.marqo404.javajax.model.Contact;

public class ContactDAO {
	
	public List<Contact> list() throws SQLException, ClassNotFoundException {
		List<Contact> contacts = new ArrayList<>();
		String query = "SELECT * FROM Contacts";
		PreparedStatement ps = ConnectionFactory.open().prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			contacts.add(fill(rs));
		}
		return contacts;
	}
	
	public List<Contact> getByGroupId(Integer groupId) throws ClassNotFoundException, SQLException {
		List<Contact> contacts = new ArrayList<>();
		String query = "SELECT * FROM Contacts WHERE GroupId=?";
		PreparedStatement ps = ConnectionFactory.open().prepareStatement(query);
		ps.setInt(1, groupId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			contacts.add(fill(rs));
		}
		return contacts;
	}
	
	private Contact fill(ResultSet rs) throws SQLException {
		Contact contact = new Contact();
		contact.setId(rs.getInt("ContactId"));
		contact.setPhoto(rs.getString("Photo"));
		contact.setFirstName(rs.getString("FirstName"));
		contact.setLastName(rs.getString("LastName"));
		contact.setBirthDate(toDatePattern(rs.getDate("BirthDate"), "dd/MM/yyyy"));
		contact.setEmail(rs.getString("Email"));
		contact.setActive(rs.getBoolean("Active"));
		return contact;
	}
	
	private Date toDatePattern(java.sql.Date date, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		String s = dateFormat.format(date);
		Date dateWithFormat = null;
		try {
			dateWithFormat = dateFormat.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateWithFormat;
	}
	
}
