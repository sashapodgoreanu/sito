/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans.Notizia;

import com.beans.Notizia.Notizia;
import java.util.Comparator;

/**
 *
 * @author SashaAlexandru
 */
public class NotiziaConPrioritaComparator implements Comparator<Notizia> {

    @Override
    public int compare(Notizia o1, Notizia o2) {
        if (o1 == null || o2 == null) {
            throw new NullPointerException("Puntatore nullo nel comparatore");
        }
        if (o1.getPriorita() <= o2.getPriorita()) {
            return -1;
        } else if (o1.getPriorita() >= o2.getPriorita()) {
            return 1;
        }
        return 0;
    }

}
