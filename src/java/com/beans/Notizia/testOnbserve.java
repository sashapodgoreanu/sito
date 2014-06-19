/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans.Notizia;

import java.sql.Timestamp;

/**
 *
 * @author SashaAlexandru
 */
public class testOnbserve {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        Notizia home = new Notizia("<h3>Ristrutturare casa: <small>guida agli incentivi</small></h3> ",
                "<h4 class=\"text-primary\">RISTRUTTURAZIONI E DETRAZIONI</h4>\n"
                + "                            <h4 class =\"text-info\"><strong>Quanto puoi detrarre</strong></h4>\n"
                + "                            <p class=\"text-muted\"><small>articolo visto su <a href=\"http://www.altroconsumo.it\">www.altroconsumo.it</a></small></p>",
                Tipo.HOME.getValue(), 9,
                (new Timestamp(new java.util.Date().getTime()))
        );
        home.salva();
        //System.out.println("proxy" + someService.isDirty());
    }

}
