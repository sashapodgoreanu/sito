/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.beans.Notizia.NotiziaHandler;
import com.beans.WebAdmin;
import com.beans.WebAdminValidator;
import com.service.CreateTables;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    @Autowired
    private HttpSession session;
    @Autowired
    WebAdminValidator webAdminValidator;
    @Autowired
    private WebAdmin webAdmin;
    @Autowired
    CreateTables createTables;
    @Autowired
    @Qualifier("proxy")
    NotiziaHandler notiziaHandler;

    @RequestMapping(value = {"login/"}, method = RequestMethod.GET)
    public ModelAndView login() {
        System.out.println("login" + webAdmin.toString());
        ModelAndView mav = new ModelAndView("login");
        session.setAttribute("webAdminSession", webAdmin);
        mav.addObject("webAdminForm", webAdmin);
        return mav;
    }

    @RequestMapping(value = {"login/enter"})
    public ModelAndView enter(@ModelAttribute("webAdminForm") WebAdmin webAdminForm,
            BindingResult bindingResult, HttpServletRequest request) {
        //ModelAndView mav = new ModelAndView("area_privata");
        webAdmin.setLogin(webAdminForm.getLogin());
        webAdmin.setPassword(webAdminForm.getPassword());
        webAdmin.authenticate();
        webAdminValidator.validate(webAdmin, bindingResult);
        //Guarda login()
        session.setAttribute("webAdminSession", webAdmin);
        return areaPrivata();
    }

    @RequestMapping(value = {"login/logout"})
    public ModelAndView logout(HttpServletResponse response) {
        System.out.println("Loging out");
        webAdmin.cleanUp(); //timeStamp to user lastlogin
        session.invalidate();
        ModelAndView mav = new ModelAndView("redirect:/login/");
        return mav;
    }

    @RequestMapping(value = {"login"}, method = {RequestMethod.GET})
    public String redirectLogin() {
        return "redirect:login/";
    }

    /**
     * ****************************************
     */
    @RequestMapping(value = {"area-privata/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView areaPrivata() {

        System.out.println(webAdmin.toString());
        if (!webAdmin.isValid()) {
            System.out.println("Not valid");
            return new ModelAndView("redirect:/login/");
        }
        ModelAndView mav = new ModelAndView("area_privata");
        mav.addObject("notizia", notiziaHandler.getNotiziaAll());

        return mav;
    }

    @RequestMapping(value = {"create-tables/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String createTables() {
        if (!webAdmin.isValid()) {
            System.out.println("Not valid");
            return "redirect:/login/";
        }
        createTables.createTables();
        return "redirect:/area-privata/";
    }

    /**
     * ********************************************
     */
    
}
