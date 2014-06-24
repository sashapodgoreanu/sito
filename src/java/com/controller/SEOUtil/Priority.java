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
public enum Priority {

    HIGH("1.0"), MEDIUM("0.5"), LOW("0.1");

    private String value;

    Priority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
