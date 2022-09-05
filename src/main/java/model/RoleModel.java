package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conncection.MySQLConnection;
import pojo.Role;

public class RoleModel {
	public List<Role> getAllRole() {
		List<Role> roles = new ArrayList<>();
		Connection connection = MySQLConnection.getConnection();
		String sql = "select * from role";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				Role role = new Role();
				role.setId(result.getInt("id"));
				role.setName(result.getString("name"));
				role.setDescription(result.getString("description"));
				roles.add(role);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roles;
	}
	
	public int addRole(Role role) {
		int result =-1;
		Connection connection = MySQLConnection.getConnection();
		String sql = "insert into role(name, description) values(?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			
			result = statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteRole(int id) {
		int result = -1;
		Connection connection = MySQLConnection.getConnection();
		String sql = "DELETE FROM role WHERE role.id = ?; ";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			result = statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
