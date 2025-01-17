package LoginDemo;
import java.util.*;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
   
	private static final long serialVersionUID = 1L;
	private static final String VALID_USERNAME = "student";
    private static final String VALID_PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Retrieve username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Prepare the response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Check the credentials
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            
            out.println("Login Successful!");
            out.println("Welcome, " + username );
         
        } else {
            
            out.println("Login Failed");
            out.println("Invalid username or password");
          
        }
       
    }
}

