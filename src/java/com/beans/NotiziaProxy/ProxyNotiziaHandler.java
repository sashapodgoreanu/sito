/*
 Classe SINGLETON
 */
package com.beans.NotiziaProxy;

import com.beans.Notizia;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author SashaAlexandru
 */
@Component(value = "proxy")
public class ProxyNotiziaHandler implements NotiziaHandler {

    private ArrayList<Notizia> notiziaPopulare;
    private ArrayList<Notizia> notiziaNuova;
    private ArrayList<Notizia> notiziaHome;
    private ArrayList<Notizia> notiziaRistrutturazione;
    private ArrayList<Notizia> notiziaBagno;
    private ArrayList<Notizia> notiziaAppartamenti;
    private ArrayList<Notizia> notiziaCucina;
    private ArrayList<Notizia> notiziaDecorazioni;
    private ArrayList<Notizia> notiziaCondominio;
    private boolean dirty; //se si aggiungi una nuova notizia nella DB, dirty = true
    private final RealNotiziaHandler realHandler;

    //singleton Instance
    //private static ProxyNotiziaHandler instance;

    public ProxyNotiziaHandler() {
        this.notiziaPopulare = null;
        this.notiziaNuova = null;
        this.notiziaHome = null;
        this.notiziaRistrutturazione = null;
        this.notiziaBagno = null;
        this.notiziaAppartamenti = null;
        this.notiziaCucina = null;
        this.notiziaDecorazioni = null;
        this.notiziaCondominio = null;
        this.dirty = false;
        this.realHandler = new RealNotiziaHandler();
    }

    /*public static synchronized ProxyNotiziaHandler getInstance() {        if (instance == null) {
            instance = new ProxyNotiziaHandler();
            System.out.println("Creating a new instance of ProxyNotiziaHandler");
        }
        return instance;
    }*/

    @Override
    public synchronized ArrayList<Notizia> getNotiziaPopulare() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized ArrayList<Notizia> getNotiziaNuova() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized ArrayList<Notizia> getNotiziaHome() {
        if (this.notiziaHome == null || dirty) {
            System.out.println("Sto accedendo al DB");
            notiziaHome = realHandler.getNotiziaHome();
        } else {
            System.out.println("Sto carricando notizia dal proxy");
        }
        return notiziaHome;
    }

    @Override
    public synchronized ArrayList<Notizia> getNotiziaRistrutturazione() {
        if (this.notiziaRistrutturazione == null || dirty) {
            System.out.println("Sto accedendo al DB");
            notiziaRistrutturazione = realHandler.getNotiziaHome();
        } else {
            System.out.println("Sto carricando notizia dal proxy");
        }
        return notiziaRistrutturazione;
    }

    @Override
    public synchronized ArrayList<Notizia> getNotiziaBagno() {
        if (this.notiziaBagno == null || dirty) {
            System.out.println("Sto accedendo al DB");
            notiziaBagno = realHandler.getNotiziaHome();
        } else {
            System.out.println("Sto carricando notizia dal proxy");
        }
        return notiziaBagno;
    }

    @Override
    public synchronized ArrayList<Notizia> getNotiziaAppartamenti() {
        if (this.notiziaAppartamenti == null || dirty) {
            System.out.println("Sto accedendo al DB");
            notiziaAppartamenti = realHandler.getNotiziaHome();
        } else {
            System.out.println("Sto carricando notizia dal proxy");
        }
        return notiziaAppartamenti;
    }

    @Override
    public synchronized ArrayList<Notizia> getNotiziaCucina() {
        if (this.notiziaCucina == null || dirty) {
            System.out.println("Sto accedendo al DB");
            notiziaCucina = realHandler.getNotiziaHome();
        } else {
            System.out.println("Sto carricando notizia dal proxy");
        }
        return notiziaCucina;
    }

    @Override
    public synchronized ArrayList<Notizia> getNotiziaDecorazioni() {
        if (this.notiziaDecorazioni == null || dirty) {
            System.out.println("Sto accedendo al DB");
            notiziaDecorazioni = realHandler.getNotiziaHome();
        } else {
            System.out.println("Sto carricando notizia dal proxy");
        }
        return notiziaDecorazioni;
    }

    @Override
    public synchronized ArrayList<Notizia> getNotiziaCondominio() {
        if (this.notiziaCondominio == null || dirty) {
            System.out.println("Sto accedendo al DB");
            notiziaCondominio = realHandler.getNotiziaHome();
        } else {
            System.out.println("Sto carricando notizia dal proxy");
        }
        return notiziaCondominio;
    }

    public boolean IsDirty() {
        return dirty;
    }

    public void setDirty(boolean isDirty) {
        this.dirty = isDirty;
    }


}
