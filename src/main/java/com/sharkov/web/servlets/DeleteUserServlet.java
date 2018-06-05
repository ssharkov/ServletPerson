package com.sharkov.web.servlets;

import com.sharkov.dao.jdbc.PersonJDBCDao;
import com.sharkov.entity.Person;
import com.sharkov.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {
    private PersonService personService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        personService.delete(id);
        resp.sendRedirect("http://localhost:3000/users");
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
