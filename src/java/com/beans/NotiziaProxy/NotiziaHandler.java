/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans.NotiziaProxy;

import com.beans.Notizia;
import java.util.ArrayList;

/**
 *
 * @author SashaAlexandru
 */
public interface NotiziaHandler {

    public ArrayList<Notizia> getNotiziaPopulare();

    public ArrayList<Notizia> getNotiziaNuova();

    public ArrayList<Notizia> getNotiziaHome();

    public ArrayList<Notizia> getNotiziaRistrutturazione();

    public ArrayList<Notizia> getNotiziaBagno();

    public ArrayList<Notizia> getNotiziaAppartamenti();

    public ArrayList<Notizia> getNotiziaCucina();

    public ArrayList<Notizia> getNotiziaDecorazioni();

    public ArrayList<Notizia> getNotiziaCondominio();


}
