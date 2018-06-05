package com.sharkov.servlets;

import com.sharkov.database.UserJDBCDao;
import com.sharkov.entity.Person;
import com.sharkov.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        List<Person> list;
        UserJDBCDao dataBase = new UserJDBCDao();
        list = dataBase.getAllPersons();

        pageVariables.put("users", list);
        resp.getWriter().println(PageGenerator.instance().getPage("adduser.html", pageVariables));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserJDBCDao userJDBCDao = new UserJDBCDao();

        Person person = new Person();
        person.setName(req.getParameter("name"));
        person.setLastName(req.getParameter("lastname"));
        person.setSalary(Integer.parseInt(req.getParameter("salary")));
        userJDBCDao.insert(person);

        resp.sendRedirect("http://localhost:3000/users");
    }
}
