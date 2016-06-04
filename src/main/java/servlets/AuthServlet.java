package servlets;

import com.google.gson.Gson;
import data.models.AuthResponse;
import services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by g on 03.06.16.
 */
public class AuthServlet extends BaseHttpServlet {

    public static final String PAGE_URL = "/auth";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";

    public AuthServlet(AccountService accountService) {
        super(accountService);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);

        String token = getAccountService().auth(login, password);
        resp.getWriter().println(GSON.toJson(new AuthResponse(true, token)));
    }

}
