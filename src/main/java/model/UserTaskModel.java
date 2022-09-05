package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conncection.MySQLConnection;

public class UserTaskModel {
	public int deleteUserTask(int id) {
		int result = -1;
		Connection connection = MySQLConnection.getConnection();
		String sql = "DELETE FROM user_task WHERE task_id = ?; ";
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
