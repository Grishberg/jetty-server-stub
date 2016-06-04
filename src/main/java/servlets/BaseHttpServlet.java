package servlets;

import com.google.gson.Gson;
import com.sun.deploy.net.HttpRequest;
import data.models.BaseResponse;
import services.AccountService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by g on 03.06.16.
 */
public class BaseHttpServlet extends HttpServlet {
    public static final String PAGE = "page";
    public static final String TOKEN = "token";
    static final Gson GSON = new Gson();
    private final AccountService accountService;

    public BaseHttpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    protected AccountService getAccountService() {
        return accountService;
    }

    protected int getPage(HttpServletRequest request) {
        String page = request.getParameter(PAGE);
        if (page != null && !page.isEmpty()) {
            try {
                return Integer.valueOf(page);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    protected int getIntParameter(HttpServletRequest request, String name) {
        String val = request.getParameter(name);
        if (val != null && !val.isEmpty()) {
            try {
                return Integer.valueOf(val);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    protected boolean checkAuth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = request.getParameter(TOKEN);

        if (!getAccountService().checkToken(token)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().println(
                    GSON.toJson(new BaseResponse(BaseResponse.INVALID_ACCESS_TOKEN)));
            return false;
        }
        return true;
    }
}
