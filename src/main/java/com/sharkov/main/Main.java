package com.sharkov.main;

import com.sharkov.servlets.AddUserServlet;
import com.sharkov.servlets.UserServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        UserServlet userServlet = new UserServlet();
        AddUserServlet addUserServlet = new AddUserServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(userServlet), "/users");
        context.addServlet(new ServletHolder(addUserServlet), "/users/add");

        Server server = new Server(3000);
        server.setHandler(context);
        server.start();
    }
}
