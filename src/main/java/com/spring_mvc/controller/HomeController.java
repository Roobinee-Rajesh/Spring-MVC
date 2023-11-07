package com.spring_mvc.controller;

import com.spring_mvc.Dao.HomeDao;
import com.spring_mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
//    @RequestMapping("/showForm")
//    public String showForm(){
//        return "showForm";
//    }
//    @RequestMapping("/processForm")
//    public String processForm(){
//        return "processForm";
//    }
//@RequestMapping("/processFormTwo")
//    public  String processFormTwo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model)
//    {
//        String name=httpServletRequest.getParameter("sname");
//        model.addAttribute("message",name);
//        return "processForm";
//    }
//
//    @RequestMapping("/processFormThree")
//    public  String processFormThree(@RequestParam("sname") String name, Model model)
//    {
//        model.addAttribute("message",name);
//        return "processForm";
//    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome(Model model) {
        ArrayList<User> users=new ArrayList<>();
        users = homeDao.getUser();
        model.addAttribute("users", users);
        return "home";
    }

}
