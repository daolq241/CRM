package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conncection.MySQLConnection;
import pojo.Project;

public class ProjectModel {
	public List<Project> getAllProject() {
		List<Project> projects = new ArrayList<>();
		Connection connection = MySQLConnection.getConnection();
		String sql = "select * from project";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				Project project = new Project();
				project.setName(result.getString("name"));
				project.setDescription(result.getString("description"));
				project.setStartDate(result.getDate("start_date"));
				project.setEndDate(result.getDate("end_date"));
				projects.add(project);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projects;
	}
}
