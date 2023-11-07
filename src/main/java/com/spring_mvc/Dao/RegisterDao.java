package com.spring_mvc.Dao;

import com.spring_mvc.DBConnection.DBConnection;
import com.spring_mvc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    private static Connection connection;
    private static String ADD_USER="INSERT INTO user(name,email,password,gender,state,language,qualification) VALUES(?,?,?,?,?,?,?)";

    public RegisterDao(){
        connection= DBConnection.getConnection();
    }

    public void addUser(User user, String language) throws SQLException {
        PreparedStatement statement= connection.prepareStatement(ADD_USER);
        statement.setString(1, user.getName());
        statement.setString(2,user.getEmail());
        statement.setString(3,user.getPassword());
        statement.setString(4,user.getGender());
        statement.setString(5,user.getState());
        statement.setString(6,language);
        statement.setString(7, user.getQualification().get(0));

        statement.executeUpdate();

    }
}
