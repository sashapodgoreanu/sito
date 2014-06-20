/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.beans.Contatto;
import com.beans.ContattoValidator;
import com.service.GmailMail;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ContattoValidator contattoValidator;
    @Autowired    
    GmailMail gmailMail;

    @RequestMapping(value = {"contatti/send-contact"}, method = {RequestMethod.POST})
    public String sendContact(@ModelAttribute("contact") Contatto contact, BindingResult bindingResult, Model model) {
        contattoValidator.validate(contact, bindingResult); //bindingResult needs to be filled with errors if any. 
        if (bindingResult.hasErrors()) {
            return "contatti";
        } else {
            if (contact.salva()) {
                gmailMail.sendMail(contact.getEmail(),
                        "p.alxzeta@gmail.com",
                        "Messaggio dal Sito Internet",
                        "Messaggio: " + contact.getMessaggio()
                        + "\nTelefono: " + contact.getTelefono()
                        + "\nEmail. " + contact.getEmail()
                );
                /*gmailMail.sendMail(contact.getEmail(),                        "damicisorin@ymail.com",
                        "Messaggio dal Sito Internet",
                        "Messaggio: " + contact.getMessaggio()
                        + "\nTelefono: " + contact.getTelefono()
                        + "\nEmail. " + contact.getEmail()
                );*/
                model.addAttribute("success", "Inviato con successo, verrai contatatatto non appena possibile per un preventivo gratuito.");//put some message in view 
            } else {
                model.addAttribute("notSuccess", "Siamo spiacenti, è sato un errore sui nostri server, riprova piu tardi.");//put some message in view  
            }
            model.addAttribute("contact", new Contatto());//if no error then create new contact
        }
        return "contatti";
    }

    @RequestMapping(value = {"contatti/"}, method = RequestMethod.GET)
    public ModelAndView contatti(@ModelAttribute("contact") Contatto contact) {
        ModelAndView mav = new ModelAndView("contatti");//add view - contatti.jsp
        mav.addObject("contact", contact);
        return mav;
    }

    @RequestMapping(value = {"contatti"}, method = {RequestMethod.GET})
    public String redirectContatti() {
        return "redirect:contatti/";
    }

}
