package com.spring_mvc.controller;

import com.spring_mvc.Dao.RegisterDao;
import com.spring_mvc.model.Student;
import com.spring_mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("/register")

public class RegisterController {
    @RequestMapping(value = "/registerForm",method = RequestMethod.GET)
    public String register(Model model){
        User user=new User();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/registerAddUser",method = RequestMethod.POST)
    public String registerAddUser(@ModelAttribute("user") User user) throws SQLException {
        if (user.getPassword().equals(user.getcPassword())) {
//            String name = user.getName();
//            String email = user.getEmail();
//            String password=user.getPassword();
//            String gender= user.getGender();
//            String state=user.getState();
            String[] languages = user.getLanguage();
            String selectedLanguagesString = String.join(",", languages);
//            String qualification= user.getQualification().get(0);
//            System.out.println(qualification);
            RegisterDao registerDao=new RegisterDao();
            registerDao.addUser(user,selectedLanguagesString);

        }
        return "index";
    }
}
