package com.sharkov.database;

import com.sharkov.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJDBCDao {
    public List<Person> getAllPersons() {
        Statement statement = establishConnection();
        List<Person> list = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("Select * from Persons");
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(Integer.parseInt(resultSet.getString("id")));
                person.setName(resultSet.getString("Name"));
                person.setLastName(resultSet.getString("LastName"));
                person.setSalary(Integer.parseInt(resultSet.getString("Salary")));
                list.add(person);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Person person) {
        Statement statement = establishConnection();
        try {
            statement.executeUpdate(prepareInsertStatement(person));
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String prepareInsertStatement(Person person) {
        return "INSERT INTO persons (`Name`, `LastName`, `Salary`) " +
                "VALUES ('" +
                person.getName() + "', " + "'" +
                person.getLastName() + "', '" +
                person.getSalary() +
                "')";
    }

    private Statement establishConnection() {
        Connection connection;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sqlquery?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC\n", "root", "root");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
