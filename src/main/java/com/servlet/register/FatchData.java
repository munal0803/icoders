package com.servlet.register;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Search")
public class FatchData extends HttpServlet
{
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        String teamname = request.getParameter ("teamname");
        try
        {
            Class.forName ("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql:///firstdb","root","password");
            PreparedStatement ps =
         con.prepareStatement ("select * from user where technology=?");
            ps.setString (1, teamname);
            ResultSet rs = ps.executeQuery ();
            ResultSetMetaData rsmd = rs.getMetaData ();
            out.print ("<tr>");
            out.print ("</tr>");
            while (rs.next ())
         {
out.print("<style>@import url(\"https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;700&display=swap\");\r\n"
		+ "\r\n"
		+ "* {\r\n"
		+ "  margin: 0;\r\n"
		+ "  padding: 0;\r\n"
		+ "  box-sizing: border-box;\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ "body {\r\n"
		+ "  height: 100vh;\r\n"
		+ "  font-family: \"Open Sans\", sans-serif;\r\n"
		+ "  background-color: #eee;\r\n"
		+ "  display: flex;\r\n"
		+ "  align-items: center;\r\n"
		+ "  justify-content: center;\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ ".card {\r\n"
		+ "  width: 360px;\r\n"
		+ "  background-color: #fff;\r\n"
		+ "  box-shadow: 0 0 7px rgba(0, 0, 0, 0.6);\r\n"
		+ "  border-radius: 0.5rem;\r\n"
		+ "  padding: 0.5rem;\r\n"
		+ "  margin: 1.5rem;\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ ".card-header {\r\n"
		+ "  width: 100%;\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ ".card-header img {\r\n"
		+ "  width: 100%;\r\n"
		+ "  border-top-left-radius: 0.5rem;\r\n"
		+ "  border-top-right-radius: 0.5rem;\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ ".card-content {\r\n"
		+ "  padding: 1rem;\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ ".card-content span {\r\n"
		+ "  background-color: #51adc4;\r\n"
		+ "  color: #fff;\r\n"
		+ "  font-weight: 300;\r\n"
		+ "  font-size: 10px;\r\n"
		+ "  padding: 0.5rem 0.75rem;\r\n"
		+ "  border-radius: 1rem;\r\n"
		+ "  text-transform: uppercase;\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ ".card-content h3 {\r\n"
		+ "  margin: 1rem 0 0.5rem 0;\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ ".card-content p {\r\n"
		+ "  font-size: 14px;\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ ".card-footer {\r\n"
		+ "  display: flex;\r\n"
		+ "  align-items: center;\r\n"
		+ "  justify-content: space-between;\r\n"
		+ "  padding: 1rem;\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ ".card-footer img {\r\n"
		+ "  width: 2.5rem;\r\n"
		+ "  height: 2.5rem;\r\n"
		+ "  border-radius: 50%;\r\n"
		+ "  object-fit: cover;\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ ".card-footer .author {\r\n"
		+ "  flex: 1;\r\n"
		+ "  margin-left: 1rem;\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ ".author p {\r\n"
		+ "  font-weight: 700;\r\n"
		+ "  font-size: 14px;\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ ".author small {\r\n"
		+ "  font-size: 12px;\r\n"
		+ "}\r\n"
		+ "</style>"
		+ "<div class=\"card\">\r\n"
		+ "  <div class=\"card-header\">\r\n"
		+ "    <img src=\"https://media.geeksforgeeks.org/wp-content/cdn-uploads/20190626123927/untitlsssssed.png\" alt=\"\">\r\n"
		+ "  </div>\r\n"
		+ "  <div class=\"card-content\">\r\n"
		+ "    <span>"+ rs.getString(2) +"</span>\r\n"
		+ "    <h3>"+rs.getString(1)+"</h3>\r\n"
		+ "    <p>Team Leader : " + rs.getString(5)+"</p>\r\n"
		+ "    <p>Hackathon Name : " + rs.getString(3)+"</p>\r\n"
		+ "    <p>Date Of Hackathon : " + rs.getString(4)+"</p>\r\n"
		+ "    <p>Maximum No. of Member : " + rs.getString(6)+"</p>\r\n"
		
		+ "  </div>\r\n"
		+ "  </div>\r\n"
		+ "</div>");

             
         }
            out.print( "<div><a href='index.html'>             To Home page >->> </a></div>" );      }
        catch (Exception e2)
        {
            e2.printStackTrace ();
        }
        finally
        {
            out.close ();
        }
    }
}