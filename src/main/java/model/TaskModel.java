package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conncection.MySQLConnection;
import pojo.Role;
import pojo.Task;

public class TaskModel {
	UserTaskModel userTaskModel = new UserTaskModel();
	public List<Task> getAllTask() {
		List<Task> tasks = new ArrayList<>();
		Connection connection = MySQLConnection.getConnection();
		String sql = "select * from task";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Task task = new Task();
				task.setId(result.getInt("id"));
				task.setName(result.getString("name"));
				task.setProjectId(result.getInt("project_id"));
				task.setStartDate(result.getDate("start_date"));
				task.setEndDate(result.getDate("end_date"));
				task.setStatus(result.getString("status"));
				tasks.add(task);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}
	
	public int deleteTask(int id) {
		int result = -1;
//		userTaskModel.deleteUserTask(id);
		Connection connection = MySQLConnection.getConnection();
		String sql = "DELETE FROM task WHERE task.id = ?; ";
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
