package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import models.Task;
import models.User;

public class DatabaseUtil {

	private static DatabaseUtil instance;

	private Connection connection;

	public DatabaseUtil() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(Commons.connectionString, Commons.dbUsername, Commons.dbPassword);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public synchronized static DatabaseUtil getInstance() {
		if (instance == null) {
			instance = new DatabaseUtil();
		}
		return instance;
	}

	public String getUserId(String username) {
		String query = "SELECT user_id FROM user WHERE user_name=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				return resultSet.getString(1);
		} catch (SQLException e) {
			System.out.println(e.toString());
			return "Server error " + e.getMessage();
		}
		return "";
	}

	public String getUserType(String username, String password) {
		try {

			String query = "SELECT type_value from user, types " + "WHERE user_type = type_no AND user_name=? "
					+ " AND user_password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString(1);
			}
			return "";
		}

		catch (SQLException e) {
			System.out.println(e.toString());
			return "Server error " + e.getMessage();
		}

	}
	
	public List<User> getAllUsers () {
		List<User>users = new ArrayList<>();
		String query = "SELECT user_id,user_name, user_password"
				+ ", (SELECT type_value from types where user_type=type_no)"
				+ " FROM user";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				User developer = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
				users.add(developer);
			}
		} catch (SQLException e) {
			System.out.println("Exception from Get All Uesrs Method");
		}
		
		return users;
	}
	
	public static List<User> getUsers() {
		return DatabaseUtil.getInstance().getAllUsers();
	}
	

	public List<User> getUsersForManager(String managerId) {
		List<User> users = new ArrayList<>();
		try {
			String query = "SELECT u2.user_id,u2.user_name,u2.user_password"
					+ ",(SELECT type_value from types where u2.user_type=type_no) "
					+ " FROM user u1,user u2, user_rel ur" + " WHERE ur.teamleader=u1.user_id"
					+ " AND ur.developer=u2.user_id AND u1.user_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, managerId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User developer = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
				users.add(developer);
			}

		} catch (SQLException e) {
			System.out.println("Exception from Get Users Method" + e.getMessage());
		}
		return users;
	}

	public String getUserTeamLeader(String userId) {
		String query = "SELECT u2.user_name FROM user u1, user u2, user_rel ur  " + "WHERE u1.user_id=?"
				+ " AND u2.user_id=ur.teamleader AND u1.user_id=ur.developer";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				return resultSet.getString(1);

		} catch (SQLException e) {
			System.out.println("Exception from get User Team Leader Method: " + e.getMessage());
		}
		return "";
	}

	public boolean insertUser(User user, String managerId) {
		String query = "INSERT INTO user (user_name, user_password, user_type) VALUES (?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getType());

			preparedStatement.execute();
			return insertUsertoManger(managerId);

		} catch (SQLException e) {
			System.out.println("Exception from Inser Team Leader Method: " + e.getMessage());
		}
		return false;
	}

	private boolean insertUsertoManger(String managerId) throws SQLException {
		String query = "INSERT INTO user_rel VALUES(?,(SELECT MAX(user_id) FROM user))";
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, managerId);
		return preparedStatement.execute();

	}

	public List<Task> getUserTasks(String userId) {
		List<Task> tasks = new ArrayList<>();
		try {
			String query = "SELECT t.task_id, t.task_name, t.task_desc, t.task_deadline"
					+ ", (select state_value from states WHERE state_no=t.task_state)"
					+ " FROM task t, user u, user_task ut"
					+ " WHERE u.user_id=ut.user_id AND t.task_id=ut.task_id AND u.user_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Task task = new Task(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getDate(4), resultSet.getString(5));
				tasks.add(task);
			}

		} catch (SQLException e) {
			System.out.println("Exception from GetUserTask Method: " + e.getMessage());
		}
		return tasks;
	}

	public boolean assignTask(String taskId, String receiverId) {
		String query = "UPDATE user_task SET user_id =? WHERE task_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, receiverId);
			preparedStatement.setString(2, taskId);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Exception from Delete User Task Method" + e.getMessage());
		}

		return false;
	}

	public boolean insertTask(Task task, String userId) {
		String query = "INSERT INTO task (task_name, task_desc, task_deadline,task_state) VALUES (?,?,?, '0')";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, task.getName());
			preparedStatement.setString(2, task.getDesc());
			preparedStatement.setString(3, Commons.simpleDateFormat.format(task.getDeadline()));
			preparedStatement.execute();
			insertUserTask(userId);
			return true;
		} catch (SQLException e) {
			System.out.println("Exception from Insert Task Method " + e.getMessage());
			return false;
		}
	}

	private boolean insertUserTask(String userId) throws SQLException {
		String query = "INSERT INTO user_task VALUES (?, (SELECT MAX(task_id) FROM task))";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, userId);
		preparedStatement.execute();
		return true;

	}

	public Task getATask(String taskId) {
		Task task = null;
		String query = "SELECT task_id, task_name, task_desc,task_deadline"
				+ ", (select state_value from states WHERE state_no=task_state)" + " FROM task WHERE task_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, taskId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				task = new Task(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2),
						resultSet.getString(3), Commons.simpleDateFormat.parse(resultSet.getString(4)),
						resultSet.getString(5));
			}
		} catch (SQLException e) {
			System.out.println("Exception from get A Task Method " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Exception from get A Task Method " + e.getMessage());
		} catch (ParseException e) {
			System.out.println("Exception from get A Task Method " + e.getMessage());
		}
		return task;
	}

	public static Task getTask(String taskId) {
		return DatabaseUtil.getInstance().getATask(taskId);
	}

	public boolean changeTaskState(String taskId, int state) {
		String query = "UPDATE task SET task_state=? WHERE task_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, state);
			preparedStatement.setString(2, taskId);
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println("Exception from Change State Method" + e.getMessage());
		}
		return false;

	}

}
