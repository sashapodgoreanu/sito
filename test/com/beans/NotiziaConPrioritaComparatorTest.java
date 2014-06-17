/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;

/**
 *
 * @author SashaAlexandru
 */
public class NotiziaConPrioritaComparatorTest {

    public NotiziaConPrioritaComparatorTest() {
    }

    /**
     * Test of compare method, of class NotiziaConPrioritaComparator.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        
        Notizia o3 = new Notizia("c", 5);
        Notizia o4 = new Notizia("d", 4);
        Notizia o1 = new Notizia("A", 1);
        Notizia o7 = new Notizia("X", 1);
        Notizia o8 = new Notizia("Y", 1);
        Notizia o9 = new Notizia("Z", 1);
        Notizia o2 = new Notizia("B", 2);

        ArrayList<Notizia> lista = new ArrayList<>();
       
        lista.add(o3);
        lista.add(o4);
        lista.add(o1);
        lista.add(o8);
        lista.add(o7);
        lista.add(o9);
        lista.add(o2);
        Collections.sort(lista, new NotiziaConPrioritaComparator());
        System.out.println(lista.toString());
    }

}
