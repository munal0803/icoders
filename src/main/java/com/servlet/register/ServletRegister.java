package com.servlet.register;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class ServletRegister extends HttpServlet{
	
	//create the query
//	private static final String INSERT_QUERY ="INSERT INTO USER(NAME,CITY,MOBILE,DOB) VALUES(?,?,?,?)";
	private static final String INSERT_QUERY ="INSERT INTO USER(teamname,technology,hackathon,doh,member1,num) VALUES(?,?,?,?,?,?)";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set Content type
		res.setContentType("text/hmtl");
		//read the form values
		String teamname = req.getParameter("teamname");
		String technology = req.getParameter("technology");
		String hackathon = req.getParameter("hackathon");
		String doh = req.getParameter("doh");
		String member1 = req.getParameter("member1");
		String num = req.getParameter("num");
		
		//load the jdbc driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//create the connection
		try(Connection con = DriverManager.getConnection("jdbc:mysql:///firstdb","root","password");
				PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
			//set the values
			ps.setString(1, teamname);
			ps.setString(2, technology);
			ps.setString(3, hackathon);
			ps.setString(4, doh);
			ps.setString(5, member1);
			ps.setString(6, num);
			//execute the query
			int count = ps.executeUpdate();
			
			if(count==0) {
				pw.print("Record not stored into database");
				 
			}else {
				pw.println("Record Stored into Database");
				res.sendRedirect("fatch.html");
			}
		}catch(SQLException se) {
			pw.println(se.getMessage());
			se.printStackTrace();
		}catch(Exception e) {
			pw.println(e.getMessage());
			e.printStackTrace();
		}
		
		//close the stream
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}