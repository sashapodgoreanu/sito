package com.service;

import com.beans.Notizia.Notizia;
import com.beans.Notizia.Tipo;
import com.beans.WebAdmin;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sasha Alexandru Podgoreanu
 */
@Service
public class CreateTables {

    static Log log = LogFactory.getLog(CreateTables.class.getName());

    @Autowired
    Notizia notizia;
    public CreateTables() {
    }
    
    public void createTables() {
        try {
            DBController dbc = DBController.getInstance();
            dbc.createTables();

            WebAdmin webAdmin = new WebAdmin();
            CreateTables ct = new CreateTables();
            webAdmin.setLogin("Sasha");
            webAdmin.setNome("Sasha Alexandru");
            webAdmin.setPassword("645128wasd");
            webAdmin.register();

            notizia.setNome("Ristrutturare casa: <small>guida agli incentivi</small>");
            notizia.setArticolo("<h4 class=\"text-primary\">RISTRUTTURAZIONI E DETRAZIONI</h4>\n"
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
                    + "                            <p class=\"text-muted\"><small>articolo visto su <a href=\"http://www.altroconsumo.it\">www.altroconsumo.it</a></small></p>");
            notizia.setTipo(Tipo.HOME.getValue());
            notizia.setPriorita(1);
            notizia.setDataCaricamento(new Timestamp(new java.util.Date().getTime()));
            notizia.salva();

            //ProxyNotiziaHandler proxy = ProxyNotiziaHandler.getInstance();
            //System.out.println(Arrays.toString(proxy.getNotiziaHome().toArray()));//test db access
            //System.out.println(Arrays.toString(proxy.getNotiziaHome().toArray()));//test proxy access

            //ProxyNotiziaHandler pr = ProxyNotiziaHandler.getInstance();
            //System.out.println(pr.getNotiziaHome());
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        CreateTables t = new CreateTables();
        t.createTables();
        
    }

}
