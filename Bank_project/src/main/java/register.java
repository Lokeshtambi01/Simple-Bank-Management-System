import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regs")
public class register extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("holder_name");
		String phnumber = req.getParameter("holder_phonenumber");
		String address = req.getParameter("holder_address");
		String PIN = req.getParameter("Pin");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project","root","123456");
			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, phnumber);
			ps.setString(3, address);
			ps.setString(4, PIN);
			ps.setInt(5,0);
			
			int i = ps.executeUpdate();
			
			if(i>0) {
				resp.setContentType("text/html");
				out.print("<h3 color='blue'>User Registered Successfully</h3>");
				RequestDispatcher re = req.getRequestDispatcher("/Register.jsp");
				re.include(req, resp);
			}else {
				resp.setContentType("text/html");
				out.print("<h3 color='red'>Some error Occured</h3>");
				RequestDispatcher re = req.getRequestDispatcher("/Register.jsp");
				re.include(req, resp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h3 color='green'>Exception Occured: "+e.getMessage()+"</h3>");
			RequestDispatcher re = req.getRequestDispatcher("/Register.jsp");
			re.include(req, resp);
		}
	}
}
