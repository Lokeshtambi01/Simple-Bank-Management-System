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

@WebServlet("/DepositServlet")
public class deposit extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String amt = req.getParameter("damount");
		double deposit_amount = Double.parseDouble(amt);
		Double Balance = (Double) req.getSession().getAttribute("amount");

		String name = (String) req.getSession().getAttribute("user");
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project","root","123456");
			double update_amount = deposit_amount + Balance;
			PreparedStatement ps = con.prepareStatement("UPDATE register SET amount=? WHERE name=?");
			ps.setDouble(1, update_amount);
			ps.setString(2, name);
			int i =  ps.executeUpdate();
			
			if(i>0) {
				resp.setContentType("text/html");
				out.print("<h3>Amount Added Successfully </h3>");
				RequestDispatcher re = req.getRequestDispatcher("/Deposit.jsp");
				re.include(req, resp);
			}else {
				resp.setContentType("text/html");
				out.print("<h3>Some Error Occured </h3>");
				RequestDispatcher re = req.getRequestDispatcher("/Deposit.jsp");
				re.include(req, resp);
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h3>Exception Occured: "+e.getMessage()+" </h3>");
			RequestDispatcher re = req.getRequestDispatcher("/Deposit.jsp");
			re.include(req, resp);
			
		}
	}
}
