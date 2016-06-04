package servlets;

import data.models.DataModel;
import data.models.PageResponse;
import services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by g on 03.06.16.
 * Класс для формирования списка
 */
public class PageServlet extends BaseHttpServlet{
    public static final String PAGE_URL = "/pages";
    public static final int PAGE_SIZE = 10;

    public PageServlet(AccountService accountService) {
        super(accountService);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!checkAuth(req, resp)){
            return;
        }

        int page = getPage(req);


        ArrayList<DataModel> data = new ArrayList<>();
        for(int i = page * PAGE_SIZE; i< (page + 1) * PAGE_SIZE; i++){
            data.add(new DataModel(i, String.format("item %d", i)));
        }
        resp.getWriter().println(GSON.toJson(new PageResponse(data)));
    }
}
