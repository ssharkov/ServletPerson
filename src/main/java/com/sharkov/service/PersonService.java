package com.sharkov.service;

import com.sharkov.dao.jdbc.PersonJDBCDao;
import com.sharkov.entity.Person;

import java.util.List;

public class PersonService {
    private PersonJDBCDao personJDBCDao;

    public void setPersonJDBCDao(PersonJDBCDao personJDBCDao) {
        this.personJDBCDao = personJDBCDao;
    }

    public List<Person> getAll() {
        return personJDBCDao.getAll();
    }

    public void insert(Person person) {
        personJDBCDao.insert(person);
    }

    public void delete(long id) {
        personJDBCDao.delete(id);
    }

    public void update(Person person) {
        personJDBCDao.update(person);
    }
}
