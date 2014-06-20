/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.service;

import com.beans.Notizia.Notizia;
import com.beans.Notizia.NotiziaConPrioritaComparator;
import java.util.ArrayList;
import java.util.Collections;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author SashaAlexandru
 */
@Aspect
public class NotiziaSortAOP {

    /**
     * Following is the definition for a pointcut to select all the methods
     * available. So advice will be called for all the methods.
     */
    @Pointcut("execution(* com.beans.Notizia.NotiziaHandler.*(..))")
    //@Pointcut("execution(* com.controller.*.*(..))")
    //@Pointcut("execution(* com.beans.Notizia.salva(..))")
    private void selectAll() {
    }

    /**
     * This is the method which I would like to execute before a selected method
     * execution.
     */
    @Before("selectAll()")
    public void beforeAdvice() {
        System.out.println("before");
    }

    /**
     * This is the method which I would like to execute after a selected method
     * execution.
     */
    @After("selectAll()")
    public void afterAdvice() {
        System.out.println("after");
    }

    /**
     * This is the method which I would like to execute when any method returns.
     */
    @AfterReturning(pointcut = "selectAll()", returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        ArrayList<Notizia> list = (ArrayList<Notizia>) retVal;
        Collections.sort(list, new NotiziaConPrioritaComparator());
    }

    /**
     * This is the method which I would like to execute if there is an exception
     * raised by any method.
     */
    @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
    public void AfterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("There has been an exception: " + ex.toString());
    }

}
