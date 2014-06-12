/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;
import com.beans.WebAdmin;
import com.service.DBController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author liliana
 */
@Controller
public class PageController {

    private Log log;
    
    @ModelAttribute
    public void createWebAdminSession(HttpSession session) {
        WebAdmin webAdminSession =(WebAdmin) session.getAttribute("webAdminSession");
        session.setAttribute("webAdminSession", webAdminSession);
        System.out.println(webAdminSession);
    }

    @RequestMapping(value = {"index/"}, method = RequestMethod.GET)
    public ModelAndView wellcome(HttpSession session) {
        String h = "Heloooo";
        session.setAttribute("heloString", h);
        ModelAndView mav = new ModelAndView("index");//add view - index.jsp
        String s = "Hi!! This content has been produced by MyController!!";
        mav.addObject("helloMessage", s);//add model
        return mav;
    }

    @RequestMapping(value = {"index", "/"}, method = {RequestMethod.GET})
    public String redirectIngHome() {
        return "redirect:index/";
    }

    @RequestMapping(value = {"note-legali/"}, method = RequestMethod.GET)
    public ModelAndView noteLegali() {
        ModelAndView mav = new ModelAndView("noteLegali");//add view - noteLegali.jsp  
        return mav;
    }

    @RequestMapping(value = {"note-legali"}, method = {RequestMethod.GET})
    public String redirectNotelegali() {
        return "redirect:note-legali/";
    }

    @RequestMapping(value = {"azienda/"}, method = RequestMethod.GET)
    public ModelAndView azienda() {
        ModelAndView mav = new ModelAndView("chi_siamo");//add view - chi_siamo.jsp  
        return mav;
    }

    @RequestMapping(value = {"azienda"}, method = {RequestMethod.GET})
    public String redirectAzienda() {
        return "redirect:azienda/";
    }

    @PostConstruct
    public void Init() {
        log = LogFactory.getLog(LoginController.class.getName());
        log.warn("Init");
        DBController dbc = DBController.getInstance();
        try {
            dbc.registerDB();
        } catch (SQLException ex) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PreDestroy
    public void cleanUp(){
        DBController dbc = DBController.getInstance();
        try {
            dbc.unregisterDB();
        } catch (SQLException ex) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
