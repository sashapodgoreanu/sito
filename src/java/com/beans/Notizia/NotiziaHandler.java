/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans.Notizia;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author SashaAlexandru
 */
public abstract class NotiziaHandler implements Observer {

    protected boolean dirty; //se si aggiungi una nuova notizia nella DB, dirty = true

    public abstract ArrayList<Notizia> getNotiziaPopulare();

    public abstract ArrayList<Notizia> getNotiziaNuova();

    public abstract ArrayList<Notizia> getNotiziaHome();

    public abstract ArrayList<Notizia> getNotiziaRistrutturazione();

    public abstract ArrayList<Notizia> getNotiziaBagno();

    public abstract ArrayList<Notizia> getNotiziaAppartamenti();

    public abstract ArrayList<Notizia> getNotiziaCucina();

    public abstract ArrayList<Notizia> getNotiziaDecorazioni();

    public abstract ArrayList<Notizia> getNotiziaCondominio();

    public abstract ArrayList<Notizia> getNotiziaPosaPavimenti();

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean isDirty) {
        this.dirty = isDirty;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Notizia) {
            dirty = true;
        }
    }

}
