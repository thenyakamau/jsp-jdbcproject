/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/assignment?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_STUDENTS_SQL = "INSERT INTO students" + "  (reg_no, fname, lname, email, gender, number, password) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_STUDENTS_BY_ID = "select * from students where id =?";
        private static final String SELECT_STUDENTS_BY_EMAIL = "select * from students where email = ? and password = ?";
	private static final String SELECT_ALL_STUDENTS = "select * from students";
	private static final String DELETE_STUDENTS_SQL = "delete from students where id = ?;";
	private static final String UPDATE_STUDENTS_SQL = "update students set reg_no = ?, fname = ?, lname = ?,email= ?, gender = ?, number =?, password = ?  where id = ?;";
	
	public StudentsDAO() {
		
	}
	
	//get Connection
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//create new student 
	public void registerNewStudent(Students students) throws SQLException {
		
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_SQL)){
			preparedStatement.setString(1, students.getReg_no());
			preparedStatement.setString(2, students.getFname());
			preparedStatement.setString(3, students.getLname());
			preparedStatement.setString(4, students.getEmail());
			preparedStatement.setString(5, students.getGender());
			preparedStatement.setString(6, students.getNumber());
			preparedStatement.setString(7, students.getPassword());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
        //login student 
	public Students loginStudent(String email, String password) throws SQLException {
		Students student = null;
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTS_BY_EMAIL)){
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
                        
                        // Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
                                int id = rs.getInt("id");
				String reg_no = rs.getString("reg_no");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String email2 = rs.getString("email");
				String gender = rs.getString("gender");
				String number = rs.getString("number");
				String password2 = rs.getString("password");
				student = new Students(id, reg_no, fname, lname, email2, gender, number, password2);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return student;
	}
	
        
	//update user
	public boolean updateUser(Students students) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENTS_SQL);) {
			preparedStatement.setString(1, students.getReg_no());
			preparedStatement.setString(2, students.getFname());
			preparedStatement.setString(3, students.getLname());
			preparedStatement.setString(4, students.getEmail());
			preparedStatement.setString(5, students.getGender());
			preparedStatement.setString(6, students.getNumber());
			preparedStatement.setString(7, students.getPassword());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//select student
	public Students selectStudent(int id) {
		Students student = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTS_BY_ID);) {
			preparedStatement.setInt(1, id);
			
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String reg_no = rs.getString("reg_no");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String number = rs.getString("number");
				String password = rs.getString("password");
				student = new Students(id, reg_no, fname, lname, email, gender, number, password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return student;
	}
	
	//select all students
	public List<Students> selectAllStudents() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Students> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String reg_no = rs.getString("reg_no");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String number = rs.getString("number");
				String password = rs.getString("password");
				users.add(new Students(id,reg_no, fname, lname, email, gender, number, password));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_STUDENTS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}


	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	
}

