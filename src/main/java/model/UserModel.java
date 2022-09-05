package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.User;
import conncection.MySQLConnection;

public class UserModel {
	public List<User> getAllUser() {
		List<User> users = new ArrayList<>();
		Connection connection = MySQLConnection.getConnection();
		
		String sql = "select * from user";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setCode(resultSet.getString("code"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setRoleId(resultSet.getInt("role_id"));
				
				users.add(user);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	}
	
	public boolean addUser(User user) {
		Connection connection = MySQLConnection.getConnection();
		String sql = "insert into user(code, name, email, address, phone, role_id) values (?, ?, ?, ?, ?, ?)";
		boolean isSussses = false;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getCode());
			statement.setString(2, user.getName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getPhone());
			statement.setInt(6, user.getRoleId());
			
			int result = statement.executeUpdate();
			if(result > 0 ) {
				isSussses = true;
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSussses;
				
	}
	
	public void deleteUser(int id) {
		Connection connection = MySQLConnection.getConnection();
		String sql = "DELETE FROM user WHERE user.id = ?; ";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User checkLogin(String email, String password) {
		User user = null;
		Connection connection = MySQLConnection.getConnection();
		String sql = "select * FROM user WHERE email = ? and password=?; ";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				user = new User();
				user.setEmail(result.getString("email"));
				user.setPassword(result.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	
}
