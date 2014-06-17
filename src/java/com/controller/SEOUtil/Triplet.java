/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.SEOUtil;

/**
 *
 * @author SashaAlexandru
 */
class Triplet<T, U, V> {

    private T a;
    private U b;
    private V c;

    public Triplet(T a, U b, V c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T getFirst() {
        return a;
    }

    public U getSecond() {
        return b;
    }

    public V getThird() {
        return c;
    }
}
