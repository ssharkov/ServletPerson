package com.sharkov.servlets;

import com.sharkov.database.QueryExecutor;
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

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        List<Person> list;
        QueryExecutor queryExecutor = new QueryExecutor();
        list = queryExecutor.getAllPersons();

        pageVariables.put("users", list);
        resp.getWriter().println(PageGenerator.instance().getPage("users.html", pageVariables));
    }
}
