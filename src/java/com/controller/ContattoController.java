/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.beans.Contatto;
import com.beans.ContattoValidation;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String sendContact(@Valid @ModelAttribute("contact") Contatto contact, BindingResult bindingResult, Model model) {
        System.out.println("Contact " + contact.toString());
        //bindingResult.rejectValue("nome", "messageCode", "Default error message");
        ContattoValidation cv = new ContattoValidation();
        cv.validate(contact, bindingResult);
        System.out.println("BR " + bindingResult.toString());

        if (bindingResult.hasErrors()) {
            return "contatti";
        }
        //ModelAndView mav = new ModelAndView("contatti");
        model.addAttribute("contact", contact);
        model.addAttribute("contact", new Contatto());
        model.addAttribute("success", "Inviato co successo");
        return "contatti";
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
