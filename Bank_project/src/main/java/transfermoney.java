import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/transfer")
public class transfermoney extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null){
            response.sendRedirect("Login.jsp");
            return;
        }

        String sender = (String) session.getAttribute("user");

        if(sender == null){
            response.sendRedirect("Login.jsp");
            return;
        }

        String receiver = request.getParameter("receiver");
        int amount = Integer.parseInt(request.getParameter("tamount"));

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank_project",
                    "root",
                    "123456");

            con.setAutoCommit(false);

            // Sender balance check
            PreparedStatement ps1 =
                    con.prepareStatement(
                            "SELECT amount FROM register WHERE name=?");

            ps1.setString(1, sender);

            ResultSet rs = ps1.executeQuery();

            if(!rs.next()){
                response.getWriter().println("Sender not found");
                return;
            }

            int senderAmount = rs.getInt("amount");

            if(senderAmount < amount){
                response.getWriter().println("Insufficient Balance");
                return;
            }

            // Receiver check
            PreparedStatement ps2 =
                    con.prepareStatement(
                            "SELECT * FROM register WHERE name=?");

            ps2.setString(1, receiver);

            ResultSet rs2 = ps2.executeQuery();

            if(!rs2.next()){
                response.getWriter().println("Receiver not found");
                return;
            }

            // Debit sender
            PreparedStatement ps3 =
                    con.prepareStatement(
                            "UPDATE register SET amount = amount - ? WHERE name=?");

            ps3.setInt(1, amount);
            ps3.setString(2, sender);

            int debitRows = ps3.executeUpdate();

            // Credit receiver
            PreparedStatement ps4 =
                    con.prepareStatement(
                            "UPDATE register SET amount = amount + ? WHERE name=?");

            ps4.setInt(1, amount);
            ps4.setString(2, receiver);

            int creditRows = ps4.executeUpdate();

            if(debitRows > 0 && creditRows > 0){
                con.commit();
                response.sendRedirect("Services.jsp");
            }else{
                con.rollback();
                response.getWriter().println("Transfer Failed");
            }

        } catch(Exception e) {

            try{
                if(con != null){
                    con.rollback();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }

            e.printStackTrace();
            response.getWriter().println("Error : " + e.getMessage());

        } finally {

            try{
                if(con != null){
                    con.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}