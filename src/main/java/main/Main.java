package main;

import org.apache.logging.log4j.LogManager;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import services.AccountSercviceImpl;
import services.AccountService;
import servlets.AuthServlet;

import javax.servlet.MultipartConfigElement;

import org.apache.logging.log4j.LogManager;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.*;

import javax.servlet.MultipartConfigElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by g on 03.06.16.
 */
public class Main {
    public static final int PORT = 8080;
    private static org.apache.logging.log4j.Logger logger = null;
    private static final String VERSION = "1.3.3";
    public static final int PAGE_SIZE = 30;

    public static void main(String[] args) throws Exception {
        System.setProperty("log4j.configurationFile", "cfg/log4j2.xml");
        logger = LogManager.getLogger(Main.class.getName());

        AccountService accountService = new AccountSercviceImpl();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        AuthServlet authServlet = new AuthServlet(accountService);
        context.addServlet(new ServletHolder(authServlet), AuthServlet.PAGE_URL);

        DetailServlet detailServlet = new DetailServlet(accountService);
        context.addServlet(new ServletHolder(detailServlet), DetailServlet.PAGE_URL);

        PageServlet pageServlet = new PageServlet(accountService);
        context.addServlet(new ServletHolder(pageServlet), PageServlet.PAGE_URL);

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(PORT);
        server.setHandler(handlers);
        server.start();
        logger.info("--------------");
        logger.info(String.format("stub server v.%s", VERSION));
        logger.info(String.format("Starting at http://127.0.0.1:%d", PORT));
        logger.info("--------------");
        server.join();
    }
}
