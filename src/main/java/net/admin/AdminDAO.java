/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
    
    
    private String jdbcURL = "jdbc:mysql://localhost:3306/assignment?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_ADMIN_SQL = "INSERT INTO admin" + "  (teac_no, teac_name, authority, password) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_ADMIN_BY_ID = "select * from admin where id =?";
        private static final String SELECT_ADMIN_BY_EMAIL = "select * from admin where teac_no = ? and password = ?";
	private static final String UPDATE_ADMIN_SQL = "update admin set teac_no = ?, teac_name = ?, authority = ?, password = ?  where id = ?;";
	
	public AdminDAO() {
		
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
	
	//create new admin 
	public void registerAdmin(Admin admin) throws SQLException {
		
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL)){
			preparedStatement.setString(1, admin.getTeac_no());
			preparedStatement.setString(2, admin.getTeac_name());
			preparedStatement.setString(3, admin.getAuthority());
			preparedStatement.setString(4, admin.getPassword());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
        //login admin 
	public Admin loginAdmin(String teac_no, String password) throws SQLException {
		Admin admin = null;
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_BY_EMAIL)){
			preparedStatement.setString(1, teac_no);
			preparedStatement.setString(2, password);
                        
                        // Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
                                int id = rs.getInt("id");
				String teac_no2 = rs.getString("teac_no");
				String teac_name = rs.getString("teac_name");
				String authority = rs.getString("authority");
				String password2 = rs.getString("password");
				admin = new Admin(id, teac_no2, teac_name, authority, password2);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return admin;
	}
	
        
	//update user
	public boolean updateUser(Admin admin) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADMIN_SQL);) {
			preparedStatement.setString(1, admin.getTeac_no());
			preparedStatement.setString(2, admin.getTeac_name());
			preparedStatement.setString(3, admin.getAuthority());
			preparedStatement.setString(4, admin.getPassword());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//select admin
	public Admin selectAdmin(int id) {
		Admin admin = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_BY_ID);) {
			preparedStatement.setInt(1, id);
			
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String teac_no2 = rs.getString("teac_no");
				String teac_name = rs.getString("teac_name");
				String authority = rs.getString("authority");
				String password2 = rs.getString("password");
				admin = new Admin(id, teac_no2, teac_name, authority, password2);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return admin;
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
