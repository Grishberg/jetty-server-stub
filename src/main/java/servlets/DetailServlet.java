package servlets;

import data.models.DetailDataResponse;
import services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by g on 03.06.16.
 */
public class DetailServlet extends BaseHttpServlet {
    public static final String PAGE_URL = "/detail";
    public static final String ID = "id";
    public static final String IMAGE_URL = "http://www.iconsearch.ru/uploads/icons/starwars/128x128/clone-old.png";

    public DetailServlet(AccountService accountService) {
        super(accountService);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!checkAuth(req, resp)) {
            return;
        }

        int id = getIntParameter(req, ID);

        resp.getWriter().println(GSON.toJson(
                new DetailDataResponse(id, String.format("item %d", id), IMAGE_URL))
        );
    }
}
