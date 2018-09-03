package com.example.demo;

import com.fasterxml.jackson.core.JsonEncoding;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JDBC {

    private String jdbcUrl = "jdbc:mysql://localhost:3306/test";
    private String username = "furbano";
    private String password = "fu082018";

    public JDBC() {}

    public int insertPerson (){
        try(
                Connection conn = DriverManager.getConnection(this.jdbcUrl, username, password);
                Statement stmnt = conn.createStatement();
        ) {
            String sqlInsert = "INSERT INTO Persons VALUES ('2','felix','urbano','cgts','caracas')";
            stmnt.executeQuery(sqlInsert);
            return 0;

        } catch (SQLException e){
            System.out.println(e);
            return 0;
        }
    }

    public List<Person> selectPersons (){
        ArrayList<Person> arr = new ArrayList<Person>();
        try(
                Connection conn = DriverManager.getConnection(this.jdbcUrl, username, password);
                Statement stmnt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM Persons";
            ResultSet  result = stmnt.executeQuery(sqlSelect);
            while (result.next()){

                arr.add(
                        new Person(
                                result.getString("PersonID"),
                                result.getString("LastName"),
                                result.getString("FirstName"),
                                result.getString("Address"),
                                result.getString("City")
                                )
                );
            }
            conn.close();
            return arr;

        } catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }
}
