package com.sharkov.web.servlets;

import com.sharkov.entity.Person;
import com.sharkov.service.PersonService;
import com.sharkov.web.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServlet extends HttpServlet {

    private PersonService personService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        List<Person> list;
        list = personService.getAll();

        pageVariables.put("users", list);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println(PageGenerator.instance().getPage("users.html", pageVariables));
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
