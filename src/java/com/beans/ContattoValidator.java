/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author SashaAlexandru
 */
@Component
public class ContattoValidator implements Validator {

    private static final Logger LOG = Logger.getLogger(ContattoValidator.class.getName());

    String error1 = "Questo campo e richiesto";
    String messageCode = "messageCode";

    /**
     * This Validator validates Contatto instances, and any subclasses of
     * Customer too
     */
    @Override
    public boolean supports(Class clazz) {
        return Contatto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", messageCode, error1);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", messageCode, error1);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messaggio", messageCode, error1);
        Contatto contatto = (Contatto) o;
        if (!isNumeric(contatto.getTelefono()) && contatto.getTelefono().length() != 0) {
            errors.rejectValue("telefono", messageCode, "Telefono non valido");
        }

        if (contatto.getTelefono().length() < 10) {
            errors.rejectValue("telefono", messageCode, "Telefono non valido, devi inserire almeno 10 numeri");
        }

        if (contatto.getMessaggio().length() < 10 || contatto.getMessaggio().length() > 2048) {
            errors.rejectValue("messaggio", messageCode, "Questo campo deve contenere almeno 10 caratteri");
        }
    }

    private static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            LOG.severe(nfe.getMessage());
            return false;
        }
        return true;
    }

}
