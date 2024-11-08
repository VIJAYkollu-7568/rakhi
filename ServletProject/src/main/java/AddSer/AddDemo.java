package AddSer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddDem
 */
@WebServlet("/AddDem")
public class AddDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDemo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve parameters "num" and "num2" from the request
		String num1Str = request.getParameter("num");
		String num2Str = request.getParameter("num2");

		try {
			// Parse the parameters as integers
			int num1 = Integer.parseInt(num1Str);
			int num2 = Integer.parseInt(num2Str);

			// Calculate the sum
			int sum = num1 + num2;

			// Set response content type and write the result
			response.setContentType("text/html");
			response.getWriter().println("The sum of " + num1 + " and " + num2 + " is: " + sum);
		} catch (NumberFormatException e) {
			// Handle invalid input
			response.getWriter().println("Please enter valid numbers for num and num2.");
		}
	}
}