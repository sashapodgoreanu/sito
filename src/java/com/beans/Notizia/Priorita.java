/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans.Notizia;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author SashaAlexandru
 */
@Component
public class Priorita {

    public static final int ALTA = 1;
    public static final int MEDIO = 2;
    public static final int BASSA = 3;


    public Priorita() {
    }

    public Map<String, Integer> getAllPriorita() {
        Field[] fields = Priorita.class.getFields();
        Map<String, Integer> map = new HashMap<>();
        for (Field field : fields) {
            try {
                map.put(field.getName(), (int) field.get(this));
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(Priorita.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Priorita p = new Priorita();
        System.out.println(p.getAllPriorita().toString());

    }
}
