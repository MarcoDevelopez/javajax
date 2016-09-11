package com.marqo404.javajax.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.marqo404.javajax.factory.ConnectionFactory;
import com.marqo404.javajax.model.Group;

public class GroupDAO {

	public List<Group> list() throws ClassNotFoundException, SQLException {
		List<Group> groups = new ArrayList<>();
		String query = "SELECT * FROM Groups ORDER BY Name ASC";
		PreparedStatement ps = ConnectionFactory.open().prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			groups.add(fill(rs));
		}
		return groups;
	}
	
	private Group fill(ResultSet rs) throws SQLException {
		Group group = new Group();
		group.setId(rs.getInt("GroupId"));
		group.setName(rs.getString("Name"));
		return group;
	}
}
