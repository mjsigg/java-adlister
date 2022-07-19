import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ads/create")

//        this.id = id;
//                this.userId = userId;
//                this.title = title;
//                this.description = description;


public class AdsCreate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        req.getRequestDispatcher("/ads/create.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        Ads adsDao = DaoFactory.getAdsDao();

        String name = req.getParameter("name");
        String userId = req.getParameter("userId");
        String title = req.getParameter("title");
        String description = req.getParameter("description");

//        Ad ad = new Ad();
//        adsDao.insert(ad);
//        resp.sendRedirect("/ads");

    }
}
