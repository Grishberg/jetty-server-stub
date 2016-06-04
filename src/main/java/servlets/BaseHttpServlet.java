package servlets;

import com.google.gson.Gson;
import com.sun.deploy.net.HttpRequest;
import services.AccountService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by g on 03.06.16.
 */
public class BaseHttpServlet extends HttpServlet {
    public static final String PAGE = "page";
    static final Gson GSON = new Gson();

    private final AccountService accountService;
    public BaseHttpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    AccountService getAccountService(){
        return accountService;
    }
    int getPage(HttpServletRequest request){
        String page = request.getParameter(PAGE);
        if(page != null && !page.isEmpty()){
            try {
                return Integer.valueOf(page);
            } catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        return -1;
    }

}
