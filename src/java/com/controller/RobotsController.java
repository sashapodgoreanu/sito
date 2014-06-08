/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 *
 * @author SashaAlexandru
 */
@Controller
public class RobotsController {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @RequestMapping(value = "/robots.txt", method = RequestMethod.GET)
    public String getRobots(HttpServletRequest request) {
        System.out.println(request.getServerName());
        return (Arrays.asList("damicicostruzioni.it", "www.damicicostruzioni.it", "damicicostruzioni").contains(request.getServerName()))
                ? "robotsAllowed" : "robotsDisallowed";
    }

    @RequestMapping(value = "/endpoints", method = RequestMethod.GET)
    public ModelAndView getEndPointsInView(Model model) {
        model.addAttribute("endPoints", requestMappingHandlerMapping.getHandlerMethods().keySet());

        return new ModelAndView("endpoints");
    }
}
