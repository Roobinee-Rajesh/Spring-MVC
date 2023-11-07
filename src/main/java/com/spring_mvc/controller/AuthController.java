package com.spring_mvc.controller;

import com.spring_mvc.Dao.AuthDao;
import com.spring_mvc.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping(value = "/validate",method = RequestMethod.POST)
    public String validate(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model){
        String email=httpServletRequest.getParameter("email");
        String password=httpServletRequest.getParameter("password");
        model.addAttribute("email",email);
        model.addAttribute("password",password);
        AuthDao authDao=new AuthDao();
        authDao.validateUser(email,password);

        Login login = authDao.validateUser(email, password);
        if (login != null) {
            return "home";
        } else {
            httpServletRequest.setAttribute("error", true);
            return "index";
        }
    }
}
