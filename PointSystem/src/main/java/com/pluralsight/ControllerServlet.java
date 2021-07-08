package com.pluralsight;

import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/points/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Student> students = StudentDAO.listAllStudents();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard.html");
		dispatcher.forward(request, response);
		request.setAttribute("student_list", students);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response, String username, String password) throws ServletException, IOException {
		Connection jdbcConnection;
		Statement statement = jdbcConnection.createStatement();
		String statementString = String.format("SELECT password FROM student WHERE username='%s'"), username);
		ResultSet result = statement.executeQuery(statementString);
		
		
		///code  to verify if password is correct
		if (password.equals(result)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard.html");
			dispatcher.forward(request, response);
			request.setAttribute(username, username);
					
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Homepage.html");
			dispatcher.forward(request, response);
					
		}
					
				
		}
		​
		
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter output = response.getWriter();
			
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		//output.println("Hello " + username);
		//output.println("Hello " + password);
				
		login(request,response, username, password);
				
				
		}
		​
	}
		