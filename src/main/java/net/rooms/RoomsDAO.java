/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rooms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomsDAO {
    
    private String jdbcURL = "jdbc:mysql://localhost:3306/assignment?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_ROOM_SQL = "INSERT INTO accomodation_rooms" + "  (room_name,room_type, room_location, monthly_charge, room_status, payment_status) VALUES "
			+ " (?,?, ?, ?, ?, ?);";

	private static final String SELECT_ROOM_BY_ID = "select * from accomodation_rooms where id =?";
	private static final String SELECT_ALL_ROOMS = "select * from accomodation_rooms";
	private static final String DELETE_ROOM_SQL = "delete from accomodation_rooms where id = ?;";
	private static final String UPDATE_ROOM_SQL = "update accomodation_rooms set room_name = ?, room_type = ?, room_location = ?, monthly_charge = ?,room_status= ?, payment_status = ?  where id = ?;";
        private static final String BOOK_ROOM_SQL = "update accomodation_rooms set  room_type = ?, reg_no = ?, room_location = ?, monthly_charge = ?,room_status= ?, payment_status = ?  where id = ?;";
	
	public RoomsDAO() {
		
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
	
	//create new room 
	public void registerRoom(Rooms room) throws SQLException {
		
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM_SQL)){
                    preparedStatement.setString(1, room.getRoom_name());
                    preparedStatement.setString(2, room.getRoom_type());
			preparedStatement.setString(3, room.getRoom_location());
			preparedStatement.setString(4, room.getMonthly_charge());
			preparedStatement.setString(5, room.getRoom_status());
			preparedStatement.setString(6, room.getPayment_status());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
     
	
        
	//update room
	public boolean updateRoom(Rooms room) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROOM_SQL);) {
                    preparedStatement.setString(1, room.getRoom_name());
                    preparedStatement.setString(2, room.getRoom_type());
			preparedStatement.setString(3, room.getRoom_location());
			preparedStatement.setString(4, room.getMonthly_charge());
			preparedStatement.setString(5, room.getRoom_status());
			preparedStatement.setString(6, room.getPayment_status());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
        
            
	//update room
	public boolean bookRoom(Rooms room) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(BOOK_ROOM_SQL);) {
			preparedStatement.setString(1, room.getRoom_type());
                        preparedStatement.setString(2, room.getReg_no());
			preparedStatement.setString(3, room.getRoom_location());
			preparedStatement.setString(4, room.getMonthly_charge());
			preparedStatement.setString(5, room.getRoom_status());
			preparedStatement.setString(6, room.getPayment_status());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
       
	//select room
	public Rooms selectStudent(int id) {
		Rooms room = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROOM_BY_ID);) {
			preparedStatement.setInt(1, id);
			
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
                            String room_name = rs.getString("room_name");
				String room_type = rs.getString("room_type");
				String reg_no = rs.getString("reg_no");
				String room_location = rs.getString("room_location");
				String monthly_charge = rs.getString("monthly_charge");
				String room_status = rs.getString("room_status");
				String payment_status = rs.getString("payment_status");
				room = new Rooms(id, room_name, room_type, reg_no, room_location, monthly_charge, room_status, payment_status);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return room;
	}
	
	//select all students
	public List<Rooms> selectAllStudents() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Rooms> room = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOMS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
                                String room_name = rs.getString("room_name");
				String room_type = rs.getString("room_type");
				String reg_no = rs.getString("reg_no");
				String room_location = rs.getString("room_location");
				String monthly_charge = rs.getString("monthly_charge");
				String room_status = rs.getString("room_status");
				String payment_status = rs.getString("payment_status");
				room.add(new Rooms(id,room_name, room_type, reg_no, room_location, monthly_charge, room_status, payment_status));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return room;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ROOM_SQL);) {
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
