package com.pluralsight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class StudentDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/point_management";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private Connection jdbcConnection;
	
	public void connect() throws ClassNotFoundException {
		try {
			if (jdbcConnection == null || jdbcConnection.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				jdbcConnection = DriverManager.getConnection(
						jdbcURL, jdbcUsername, jdbcPassword);
				
				System.out.println("MySQL Connection Established");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MySQL Connection Established");			
		}

	}

	public void disconnect() {
		try {
			
			if (jdbcConnection != null && !jdbcConnection.isClosed()) {
				jdbcConnection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student> listAllStudents() throws ClassNotFoundException {
		connect();
		ArrayList<Student> studentList = new ArrayList<>();
		try {
			Statement statement = jdbcConnection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
			//while there are more rows, get the information for each row and store it
			//as a student instance. Take that book instance and add is to the array list
			while (resultSet.next()) {
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String track = resultSet.getString("track");
				int score = resultSet.getInt("score");
				Student student = new Student(firstName, lastName, track, score);
				studentList.add(student);
			}
			
			resultSet.close();
			statement.close();	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
		
		return studentList;
	}
	
	
	
	
}
