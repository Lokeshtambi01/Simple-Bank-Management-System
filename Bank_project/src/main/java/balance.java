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

@WebServlet("/Balance")
public class balance extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String name = (String) req.getSession().getAttribute("user");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project","root","123456");
			PreparedStatement ps = con.prepareStatement("SELECT amount FROM register WHERE name = ?");
			ps.setString(1, name);
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				double amount = rs.getDouble("amount");
				HttpSession session = req.getSession();
				session.setAttribute("amount", amount);
				req.getRequestDispatcher("/Balance.jsp").forward(req, resp);
			}else {
				resp.setContentType("text/html");
				out.print("<h3> Some Error Occured </h3>");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h3>Exception Occured: "+e.getMessage()+" </h3>");
			RequestDispatcher re = req.getRequestDispatcher("/Balance.jsp");
			re.include(req, resp);
		}
	}
}
