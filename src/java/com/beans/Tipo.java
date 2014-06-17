/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import java.util.ArrayList;

/**
 *
 * @author SashaAlexandru
 */
public enum Tipo {

    RISTRUTTURAZIONE("Ristrutturazione"),
    HOME("Home"),
    BAGNO("Bagno"),
    CUCINA("Cucina"),
    APPARTAMENTO("Appartamento"),
    AZIENDA("Azienda"),
    DECORAZIONI("Decorazioni"),
    CONDOMINIO("Condominio");

    private String value;

    Tipo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static ArrayList<String> getValues() {
        ArrayList<String> lista = new ArrayList<String>();
        for (Tipo tipo : Tipo.values()) {
            lista.add(tipo.getValue());
        }
        return lista;
    }
}
