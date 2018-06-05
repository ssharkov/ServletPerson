package com.sharkov;

import com.sharkov.dao.jdbc.PersonJDBCDao;
import com.sharkov.service.PersonService;
import com.sharkov.web.servlets.AddUserServlet;
import com.sharkov.web.servlets.DeleteUserServlet;
import com.sharkov.web.servlets.EditUserServlet;
import com.sharkov.web.servlets.UserServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        //config dao
        PersonJDBCDao personJDBCDao = new PersonJDBCDao();

        //config services
        PersonService personService = new PersonService();
        personService.setPersonJDBCDao(personJDBCDao);

        //config servlets
        AddUserServlet addUserServlet = new AddUserServlet();
        addUserServlet.setPersonService(personService);

        UserServlet userServlet = new UserServlet();
        userServlet.setPersonService(personService);

        DeleteUserServlet deleteUserServlet = new DeleteUserServlet();
        deleteUserServlet.setPersonService(personService);

        EditUserServlet editUserServlet = new EditUserServlet();
        editUserServlet.setPersonService(personService);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(userServlet), "/users");
        context.addServlet(new ServletHolder(addUserServlet), "/users/add");
        context.addServlet(new ServletHolder(deleteUserServlet), "/users/delete");
        context.addServlet(new ServletHolder(editUserServlet), "/users/edit");


        //config server
        Server server = new Server(3000);
        server.setHandler(context);
        server.start();
    }
}
