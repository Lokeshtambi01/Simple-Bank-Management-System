import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logs")
public class login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name");
		String pin = req.getParameter("pin");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project","root","123456");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM register WHERE name = ? AND pin = ?");
			
			ps.setString(1, name);
			ps.setString(2, pin);
			
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				resp.setContentType("text/html");
				out.print("<h3 color='blue'>Login Successfully</h3>");
				HttpSession session = req.getSession();
				session.setAttribute("user", name);
				RequestDispatcher re = req.getRequestDispatcher("/Services.jsp");
				re.include(req, resp);
			}else {
				resp.setContentType("text/html");
				out.print("<h3 color='red'>Incorrect Name or PIN</h3>");
				RequestDispatcher re = req.getRequestDispatcher("/Login.jsp");
				re.include(req, resp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h3 color='red'>Exception Occured:"+e.getMessage()+"</h3>");
			RequestDispatcher re = req.getRequestDispatcher("/Login.jsp");
			re.include(req, resp);
		}
	}
}
