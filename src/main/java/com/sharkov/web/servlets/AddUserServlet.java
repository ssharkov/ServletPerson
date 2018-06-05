package com.sharkov.web.servlets;

import com.sharkov.dao.jdbc.PersonJDBCDao;
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

public class AddUserServlet extends HttpServlet {
    private PersonService personService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        List<Person> list;
        list = personService.getAll();
        pageVariables.put("users", list);
        resp.getWriter().println(PageGenerator.instance().getPage("adduser.html", pageVariables));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = new Person();
        person.setName(req.getParameter("name"));
        person.setLastName(req.getParameter("lastname"));
        person.setSalary(Integer.parseInt(req.getParameter("salary")));
        personService.insert(person);
        resp.sendRedirect("http://localhost:3000/users");
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
