package com.spring_mvc.controller;

import com.spring_mvc.Dao.AuthDao;
import com.spring_mvc.Dao.HomeDao;
import com.spring_mvc.model.Login;
import com.spring_mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {

    private HomeDao homeDao;

    public HomeController() {
        homeDao = new HomeDao();
    }

    @RequestMapping("/")
    public String showPage() {
        return "index";
    }

    @RequestMapping(value = "/home")
    public String showHome(Model model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String email=httpServletRequest.getParameter("email");
        String password=httpServletRequest.getParameter("password");
        model.addAttribute("email",email);
        model.addAttribute("password",password);

        AuthDao authDao=new AuthDao();
        authDao.validateUser(email,password);

        Login login = authDao.validateUser(email, password);
        if (login != null) {
            ArrayList<User> users = homeDao.getUsers();
            model.addAttribute("users", users);
            return "home";
        } else {
            httpServletRequest.setAttribute("error", true);
            return "index";
        }

    }

}
