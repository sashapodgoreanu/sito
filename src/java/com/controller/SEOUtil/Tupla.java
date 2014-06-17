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
public class Tupla extends Triplet {

    public Tupla(Object a, Object b, Object c) {
        super(a, b, c);
    }

    public String url() {
        return (String) super.getFirst();
    }

    public String dataModifica() {
        return (String) super.getSecond();
    }

    public String priorita() {
        return (String) super.getThird();
    }

}
