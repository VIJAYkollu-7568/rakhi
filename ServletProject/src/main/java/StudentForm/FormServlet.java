package StudentForm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<b>Form Handling Using service Method</b><br>");

        String sid = request.getParameter("id");
        String sname = request.getParameter("name");
        String sgender = request.getParameter("gender");

        out.println("Student ID: " + sid + "<br>");
        out.println("Student Name: " + sname + "<br>");
        out.println("Student Gender: " + sgender + "<br>");
    }
}
