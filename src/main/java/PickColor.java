import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PickColor", urlPatterns = "/pick-color")

public class PickColor extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pickedColor = request.getParameter("color");
        request.getRequestDispatcher("/pick-color.jsp").forward(request,response);

        if (pickedColor.equals(null)) {
            response.sendRedirect("/pick-color");
        }else if(pickedColor != null) {
            request.setAttribute("color",pickedColor);
        }
    }

}

