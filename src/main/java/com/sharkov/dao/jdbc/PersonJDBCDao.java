package com.sharkov.dao.jdbc;

import com.sharkov.dao.jdbc.mapper.PersonRowMapper;
import com.sharkov.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonJDBCDao {

    public List<Person> getAll() {
        List<Person> list = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("Select * from Persons");
            PersonRowMapper personRowMapper = new PersonRowMapper();
            while (resultSet.next()) {
                list.add(personRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Person person) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(prepareInsertStatement(person));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM persons WHERE  id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Person person) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("UPDATE persons SET Name='" + person.getName() +
                    "', LastName='" + person.getLastName() +
                    "', Salary='" + person.getSalary() +
                    "' WHERE  id=" + person.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String prepareInsertStatement(Person person) {
        return "INSERT INTO persons (`Name`, `LastName`, `Salary`) " +
                "VALUES ('" +
                person.getName() + "', " + "'" +
                person.getLastName() + "', '" +
                person.getSalary() +
                "')";
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sqlquery?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC\n", "root", "root");
        return connection;
    }

}
