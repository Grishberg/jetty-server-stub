package servlets;

import services.AccountService;

/**
 * Created by g on 03.06.16.
 */
public class DetailServlet {
    private final AccountService accountService;

    public DetailServlet(AccountService accountService) {
        this.accountService = accountService;
    }
}
