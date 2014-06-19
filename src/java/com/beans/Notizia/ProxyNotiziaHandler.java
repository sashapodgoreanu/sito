/*
 Classe SINGLETON
 */
package com.beans.Notizia;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author SashaAlexandru
 */
@Component(value = "proxy")
public class ProxyNotiziaHandler extends NotiziaHandler{

    private final RealNotiziaHandler realHandler;
    protected ArrayList<Notizia> notiziaPopulare;
    protected ArrayList<Notizia> notiziaNuova;
    protected ArrayList<Notizia> notiziaHome;
    protected ArrayList<Notizia> notiziaRistrutturazione;
    protected ArrayList<Notizia> notiziaBagno;
    protected ArrayList<Notizia> notiziaAppartamenti;
    protected ArrayList<Notizia> notiziaCucina;
    protected ArrayList<Notizia> notiziaDecorazioni;
    protected ArrayList<Notizia> notiziaCondominio;

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
        super.dirty = false;
        realHandler = new RealNotiziaHandler();
    }

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
            dirty = false;
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
            dirty = false;
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
            dirty = false;
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
            dirty = false;
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
            dirty = false;
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
            dirty = false;
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
            dirty = false;
        } else {
            System.out.println("Sto carricando notizia dal proxy");
        }
        return notiziaCondominio;
    }

    
}
