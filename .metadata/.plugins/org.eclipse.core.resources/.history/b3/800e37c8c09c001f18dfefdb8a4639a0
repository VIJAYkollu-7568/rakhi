package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yourdb", "username", "password");
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";  // Note: check the hashed password
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);  // Compare the hashed password
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                response.sendRedirect("dashboard.html");  // Redirect to dashboard on successful login
            } else {
                response.sendRedirect("login.html");  // Redirect back to login on failure
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
