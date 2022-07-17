import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewColor", urlPatterns = "/view-color")

public class ViewColor extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String[] postStuff = request.getParameterValues("pickedColor");
        request.getRequestDispatcher("/pick-color").forward(request,response);

        for (String str: postStuff) {
            response.getWriter().println(str);

        }

    }

}

