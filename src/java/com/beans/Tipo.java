/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author SashaAlexandru
 */
public class Tipo {

    public static final String RISTRUTTURAZIONE = "Ristrutturazione";
    public static final String HOME = "Home";
    public static final String BAGNO = "Bagno";
    public static final String CUCINA = "Cucina";
    public static final String APPARTAMENTO = "Appartamento";
    public static final String AZIENDA = "Azienda";
    public static final String DECORAZIONI = "Decorazioni";
    public static final String CONDOMINIO = "Condominio";

    private static final Field[] fields = Tipo.class.getFields();

    public static ArrayList<String> getAllTipo() {
        ArrayList<String> tipo = new ArrayList<>();
        for (Field field : fields) {
            tipo.add(field.getName());
        }
        return tipo;
    }
}
