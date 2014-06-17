/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller.SEOUtil;

/**
 *
 * @author SashaAlexandru
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Controller
public class EndpointDocController {

    private final RequestMappingHandlerMapping handlerMapping;

    @Autowired
    public EndpointDocController(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    @RequestMapping(value = "/endpointdoc", method = RequestMethod.GET)
    public void show(Model model) {
        model.addAttribute("handlerMethods", this.handlerMapping.getHandlerMethods());
        System.out.println("aaaa " + model.toString());
        System.out.println("bbbb " + handlerMapping.getHandlerMethods().keySet());
    }
}
