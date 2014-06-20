/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.SEOUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author SashaAlexandru
 */
@Component
public class Url {

    public static final String index = "index";
    public static final String azienda = "azienda";
    public static final String contatti = "contatti";
    public static final String noteLegali = "note-legali";
    public static final String POSA_PAVIMENTI = "posa-pavimenti";

    //public static final String aggiungiNotizia = "aggiungi-notizia";
    //public static final String login = "login";
    public Url() {
    }

    public ArrayList<Tupla> getFields() throws Exception {
        Class<?> objClass = this.getClass();
        ArrayList<Tupla> tupla = new ArrayList<>();
        Field[] fields = objClass.getFields();
        for (Field field : fields) {

            String value = (String) field.get(this);

            Tupla temp = new Tupla(value, "", "");
            tupla.add(temp);
        }
        return tupla;
    }

    //test
    public static void main(String args[]) throws Exception {
    }

}
