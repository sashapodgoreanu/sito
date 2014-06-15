/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author SashaAlexandru
 */
@Component
public class WebAdminValidator implements Validator {

    String error1 = "Questo campo e richiesto";
    String messageCode = "messageCode";

    @Override
    public boolean supports(Class clazz) {
        return WebAdminValidator.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", messageCode, error1);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", messageCode, error1);
        WebAdmin webAdmin = (WebAdmin) o;
        if (!webAdmin.isValid()) {
            errors.rejectValue("valid", messageCode, "La password o il login inserito non è corretto");
        }
    }

}
