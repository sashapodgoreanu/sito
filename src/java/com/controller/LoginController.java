/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.beans.WebAdmin;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sasha Alexandru Podgoreanu
 */
@Controller
public class LoginController {

    @Autowired
    private HttpSession session;
    private Log log = LogFactory.getLog(LoginController.class.getName());

    private WebAdmin webAdminForm;

    @PostConstruct
    void init() {
        webAdminForm = new WebAdmin();
        webAdminForm.setNome(null);
    }

    @RequestMapping(value = {"login/"}, method = RequestMethod.GET)
    public ModelAndView login(/*@CookieValue(value = "username", defaultValue = "0") String username,
             @CookieValue(value = "password", defaultValue = "0") String password,
             HttpServletResponse response*/) {
        //WebAdmin webAdmin = new WebAdmin();
        //webAdmin.setLogin(username);
        //webAdmin.setPassword(password);
        //webAdmin.authenticate();
        //session.setAttribute("webAdminSession", webAdmin);
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("webAdmin", webAdminForm);
        return mav;
    }

    @RequestMapping(value = {"login/enter"})
    public ModelAndView enter(@ModelAttribute("webAdmin") WebAdmin webAdmin, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("redirect:/login/");
        if (request.getMethod().equalsIgnoreCase("POST")) {
            webAdmin.authenticate();
            session.setAttribute("webAdminSession", webAdmin);
        }
        return mav;
    }

    @RequestMapping(value = {"login/logout"})
    public ModelAndView logout(HttpServletResponse response) {
        WebAdmin webAdminSession = (WebAdmin) session.getAttribute("webAdminSession");
        if (webAdminSession != null) {
            webAdminSession.cleanUp(); //timeStamp to user lastlogin
        }
        session.removeAttribute("webAdminSession");
        //Cookie cookieUsername = new Cookie("username", "");
        //Cookie cookiePassword = new Cookie("password", "");
        //response.addCookie(cookieUsername);
        //response.addCookie(cookiePassword);
        ModelAndView mav = new ModelAndView("redirect:/login/");
        return mav;
    }

    @RequestMapping(value = {"login"}, method = {RequestMethod.GET})
    public String redirectLogin() {
        return "redirect:login/";
    }

    /*
     @PreDestroy
     public void cleanUp() throws Exception {
     userData.cleanUp();
     }*/
}
