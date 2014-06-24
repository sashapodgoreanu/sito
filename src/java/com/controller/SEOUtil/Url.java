/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.SEOUtil;

import com.beans.Notizia.Notizia;
import com.beans.Notizia.NotiziaHandler;
import com.beans.Notizia.Tipo;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author SashaAlexandru
 */
@Component
public class Url {

    @Autowired
    @Qualifier("proxy")
    NotiziaHandler notiziaHandler;

    public static final String index = "index";
    public static final String azienda = "azienda";
    public static final String contatti = "contatti";
    public static final String noteLegali = "note-legali";
    public static final String POSA_PAVIMENTI = "posa-pavimenti";

    //public static final String aggiungiNotizia = "aggiungi-notizia";
    //public static final String login = "login";
    public Url() {
    }

    public ArrayList<Tupla> getURLs() throws Exception {
        ArrayList<Notizia> notizia = notiziaHandler.getNotiziaAll();
        ArrayList<Tupla> tupla = getFields();
        for (Notizia notizia1 : notizia) {
            if (!notizia1.getTipo().equals(Tipo.Per_il_Test.getValue())) {
                tupla.add(new Tupla(notizia1.getTipo() + "/" + notizia1.getId(), notizia1.getDataCaricamento().toString(), Priority.MEDIUM));
            }
        }
        System.out.println(tupla.toString());
        return tupla;
    }

    private ArrayList<Tupla> getFields() throws Exception {
        Class<?> objClass = this.getClass();
        ArrayList<Tupla> tupla = new ArrayList<>();
        Field[] fields = objClass.getFields();
        for (Field field : fields) {

            String value = (String) field.get(this);

            Tupla temp = new Tupla(value, new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()), Priority.HIGH);
            tupla.add(temp);
        }
        return tupla;
    }

    //test
    public static void main(String args[]) throws Exception {
    }

}
