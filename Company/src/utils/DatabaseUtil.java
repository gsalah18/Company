package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.SkipPageException;

import models.Task;
import models.User;

public class DatabaseUtil {
	private Connection connection;

	public DatabaseUtil() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(Commons.connectionString,
					Commons.dbUsername, Commons.dbPassword);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public String getUserType(int id, String password) {
		try {
			Statement stm = connection.createStatement();
			String query = "SELECT type_value from user, types " + "WHERE user_type = type_no " + "AND user_id='" + id
					+ "' " + "AND user_password='" + password + "'";
			ResultSet resultSet = stm.executeQuery(query);
			if (resultSet.next()) {
				return resultSet.getString(1);
			}
			return "";
		}

		catch (SQLException e) {
			return e.getMessage();
		}

	}

	public List<User> getUsers(int teamleader_id) {
		List<User> developers = new ArrayList<>();
		try {
			Statement stm = connection.createStatement();
			String query = "SELECT u2.user_id,u2.user_name,u2.user_password"
					+ ",(SELECT type_value from types where u2.user_type=type_no) "
					+ " FROM user u1,user u2, user_rel ur" + " WHERE ur.teamleader=u1.user_id"
					+ " AND ur.developer=u2.user_id AND u1.user_id='" + teamleader_id + "'";
			System.out.println(query);
			ResultSet resultSet = stm.executeQuery(query);
			while (resultSet.next()) {
				User developer = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
				developers.add(developer);
			}

			return developers;
		} catch (SQLException e) {
			return null;
		}
	}

	public List<Task> getUserTasks(int userId) {
		List<Task> tasks = new ArrayList<>();
		try {
			Statement stm = connection.createStatement();
			String query = "SELECT t.task_id, t.task_desc, t.task_deadline"
					+ ", (select state_value from states WHERE state_no=t.task_state)"
					+ " FROM task t, user u, user_task ut"
					+ " WHERE u.user_id=ut.user_id AND t.task_id=ut.task_id AND u.user_id='" + userId + "'";

			ResultSet resultSet = stm.executeQuery(query);
			while (resultSet.next()) {
				Task task = new Task(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3),
						resultSet.getString(4));
				tasks.add(task);
			}

			return tasks;
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean insertTeamLeader(User teamLeader, int managerId) {
		String query = "INSERT INTO user (user_name, user_password, user_type) VALUES " + "(?,?,'1')";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, teamLeader.getName());
			preparedStatement.setString(2, teamLeader.getPassword());
			preparedStatement.execute();
			return addDevelopertoTeamLeader(managerId);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				throw new SkipPageException();
			} catch (SkipPageException e1) {
			}
		}
		return false;
	}

	public boolean insertDeveloper(User developer, int teamLeaderId) {
		String query = "INSERT INTO user (user_name, user_password, user_type) VALUES " + "(?,?,'2')";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, developer.getName());
			preparedStatement.setString(2, developer.getPassword());
			preparedStatement.execute();
			return addDevelopertoTeamLeader(teamLeaderId);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				throw new SkipPageException();
			} catch (SkipPageException e1) {
			}
		}
		return false;
	}

	private boolean addDevelopertoTeamLeader(int teamLeaderId) throws SQLException {
		String query = "INSERT INTO user_rel VALUES(?,(SELECT MAX(user_id) FROM user))";
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, teamLeaderId);
		return preparedStatement.execute();

	}

}
