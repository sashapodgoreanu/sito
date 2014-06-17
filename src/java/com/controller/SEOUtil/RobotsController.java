/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.SEOUtil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @Autowired
    Url url;

    /*
     @RequestMapping(value = "/robots.txt", method = RequestMethod.GET)
     @ResponseBody
     public String getRobots(HttpServletRequest request) {
     System.out.println(request.getServerName());
     return (Arrays.asList("damicicostruzioni.it", "www.damicicostruzioni.it", "damicicostruzioni").contains(request.getServerName()))
     ? "robotsAllowed" : "robotsDisallowed";
     }
     */
    @RequestMapping(value = "/robots.txt", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String getRobots() {
        List<Tupla> lista = null;
        try {
            lista = url.getFields();
        } catch (Exception ex) {
            Logger.getLogger(RobotsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        StringBuilder sb = new StringBuilder();

        sb.append("User-agent: *\n");
        sb.append("Disallow: /aggiungi-notizia/*\n");
        sb.append("Disallow: /endpointdoc\n");
        sb.append("Disallow: /login/*\n");
        for (Tupla arrayList : lista) {
            sb.append("Allow: /").append(arrayList.url()).append("\n");
            sb.append("Allow: /").append(arrayList.url()).append("/\n");
        }
        sb.append("Sitemap: http://www.damicicostruzioni.it/sitemap.xml\n");

        return sb.toString();
    }

    @RequestMapping(value = "/endpoints", method = RequestMethod.GET)
    public ModelAndView getEndPointsInView(Model model) {
        model.addAttribute("endPoints", requestMappingHandlerMapping.getHandlerMethods().keySet());

        return new ModelAndView("endpoints");
    }
}
