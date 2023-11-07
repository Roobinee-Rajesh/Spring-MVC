package com.spring_mvc.Dao;

import com.spring_mvc.DBConnection.DBConnection;
import com.spring_mvc.model.Login;
import com.spring_mvc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class HomeDao {
    private static Connection connection;
    private static String GET_USER="SELECT id,name,email,password,gender,state,language,qualification FROM user";

    public HomeDao(){
        connection= DBConnection.getConnection();
    }

    public ArrayList<User> getUser(){
        ArrayList<User> users=new ArrayList<>();
    User user=null;
        try{
        PreparedStatement statement=connection.prepareStatement(GET_USER);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            user=new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
//            user.setEmail(rs.getString("email"));
//            user.setPassword(rs.getString("password"));
//            user.setGender(rs.getString("gender"));
//            user.setState(rs.getString("state"));
//            user.setLanguage(rs.getString("language"));
//            user.setQualification(Collections.singletonList(rs.getString("qualification")));
        users.add(user);
        }

    } catch (
    SQLException e) {
        e.printStackTrace();
    }
        return users;
}
}
