import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("name");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        firstName = ("Nobody. ");
        out.println("<h1> Hello " + firstName + "You are the real hero!</h1>");
        out.println("<img width=\"100\" height=\"200\" src=\"/Users/michaelsigg/IdeaProjects/coffee-project/img/will-smith-chris-rock.gif\">\n");


    }
}
