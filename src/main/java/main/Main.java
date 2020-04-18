package main;

import frontend.SignUpServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        //servlets
        contextHandler.addServlet(new ServletHolder(new SignUpServlet()), "/authform");

        server.setHandler(contextHandler);
        server.start();
        server.join();
    }
}
