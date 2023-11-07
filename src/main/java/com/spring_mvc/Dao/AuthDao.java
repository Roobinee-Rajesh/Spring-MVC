package com.spring_mvc.Dao;

import com.spring_mvc.DBConnection.DBConnection;
import com.spring_mvc.model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDao {
    private static Connection connection;
    private static String LOGIN_QUERY="SELECT id, email, password FROM user WHERE email=? and password=?";


    public AuthDao() {
        connection= DBConnection.getConnection();
    }

    public Login validateUser(String email,String password){
        Login login=null;
        try{
            PreparedStatement statement=connection.prepareStatement(LOGIN_QUERY);
            statement.setString(1,email);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                login=new Login();
                login.setId(rs.getInt("id"));
                login.setEmail(rs.getString("email"));
                login.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }
}
