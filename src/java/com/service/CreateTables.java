package com.service;

import com.beans.Notizia;
import com.beans.NotiziaProxy.ProxyNotiziaHandler;
import com.beans.Tipo;
import com.beans.WebAdmin;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sasha Alexandru Podgoreanu
 */
public class CreateTables {

    static Log log = LogFactory.getLog(CreateTables.class.getName());
    @Autowired
    static WebAdmin webAdmin;

    public static void main(String[] args) {
        try {

            DBController dbc = DBController.getInstance();
            dbc.registerDB();
            dbc.createTables();

            webAdmin.setLogin("Sasha");
            webAdmin.setNome("Sasha Alexandru");
            webAdmin.setPassword("645128wasd");
            webAdmin.register();

            Notizia home = new Notizia("<h3>Ristrutturare casa: <small>guida agli incentivi</small></h3> ",
                    "<h4 class=\"text-primary\">RISTRUTTURAZIONI E DETRAZIONI</h4>\n"
                    + "                            <h4 class =\"text-info\"><strong>Quanto puoi detrarre</strong></h4>\n"
                    + "                            <p>È possibile detrarre dalle imposte della dichiarazione dei redditi una parte delle spese che hai sostenuto per ristrutturare casa.</p>\n"
                    + "                            <ul>\n"
                    + "                                <li>Per le spese sostenute prima del 25 giugno 2012 puoi detrarre il 36% della spesa, per un massimo di 48.000 euro.</li>\n"
                    + "                                <li> Per le spese sostenute dal 26 giugno 2012 al 31 dicembre 2014 puoi detrarre il 50% della spesa per un massimo di 96.000 euro.<br></li>\n"
                    + "                                <li>Per le spese sostenute dal 1° gennaio 2015 potrai detrarre il 40% della spesa sostenuta per un massimo di 96.000 euro.</li> \n"
                    + "                            </ul>\n"
                    + "                            <h4 class =\"text-info\"><strong>Quali interventi sono detraibili?</strong></h4>\n"
                    + "                            <ol>\n"
                    + "                                <li>Interventi di manutenzione ordinaria</li>\n"
                    + "                                <li>Interventi di manutenzione straordinaria</li>\n"
                    + "                                <li>Ricostruzione dopo evento calamitoso</li>\n"
                    + "                                <li>Eliminazione delle barriere architettoniche</li>\n"
                    + "                            </ol>\n"
                    + "                            <p class=\"text-muted\"><small>articolo visto su <a href=\"http://www.altroconsumo.it\">www.altroconsumo.it</a></small></p>",
                    Tipo.HOME,
                    (new Timestamp(new java.util.Date().getTime()))
            );
            home.salva();
            ProxyNotiziaHandler proxy = ProxyNotiziaHandler.getInstance();
            System.out.println(Arrays.toString(proxy.getNotiziaHome().toArray()));//test db access
            System.out.println(Arrays.toString(proxy.getNotiziaHome().toArray()));//test proxy access


        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

}
