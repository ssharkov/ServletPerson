package com.sharkov.dao.jdbc.mapper;

import com.sharkov.entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper {
    public Person mapRow(ResultSet resultSet) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("Name"));
        person.setLastName(resultSet.getString("LastName"));
        person.setSalary(resultSet.getInt("Salary"));
        return person;
    }
}
