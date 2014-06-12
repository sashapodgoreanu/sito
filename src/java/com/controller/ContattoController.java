/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.beans.Contatto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SashaAlexandru
 */
@Controller
public class ContattoController {

    @RequestMapping(value = {"contatti/send-contact"}, method = {RequestMethod.POST})
    public ModelAndView sendContact(@ModelAttribute("contact") Contatto contact) {
        System.out.println("Contact " + contact.toString());

        ModelAndView mav = new ModelAndView("contatti");
        mav.addObject("contact", contact);
        return mav;
    }

    @RequestMapping(value = {"contatti/"}, method = RequestMethod.GET)
    public ModelAndView contatti(@ModelAttribute("contact") Contatto contact) {
        System.out.println("Contact " + contact.toString());
        ModelAndView mav = new ModelAndView("contatti");//add view - contatti.jsp
        mav.addObject("contact", contact);
        return mav;
    }

    @RequestMapping(value = {"contatti"}, method = {RequestMethod.GET})
    public String redirectContatti() {
        return "redirect:contatti/";
    }


}
