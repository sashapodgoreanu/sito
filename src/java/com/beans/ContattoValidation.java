/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author SashaAlexandru
 */
public class ContattoValidation implements Validator {

    /**
     * This Validator validates Customer instances, and any subclasses of
     * Customer too
     */
    @Override
    public boolean supports(Class clazz) {
        return Contatto.class.isAssignableFrom(clazz);
    }
    String error1 = "Questo campo e richiesto";
    String messageCode = "messageCode";

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", messageCode, error1);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", messageCode, error1);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messaggio", messageCode, error1);
        Contatto contatto = (Contatto) o;
        if (contatto.getTelefono().length() > 1) {

            if (!isNumeric(contatto.getTelefono())) {
                errors.rejectValue("telefono", messageCode, "Telefono non valido");
            }
            System.out.println("helllo");
        }

        if (contatto.getMessaggio().length() < 10 || contatto.getMessaggio().length() > 5000) {
            errors.rejectValue("messaggio", messageCode, "Questo campo deve contenere almeno 10 caratteri");
        }
    }

    private static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
