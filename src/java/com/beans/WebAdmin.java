/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.service.DBController;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sasha Alexandru Podgoreanu
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class WebAdmin {

    private String nome;
    private String password;
    private String login;
    private boolean valid;
    private String lastOnline;

    public WebAdmin() {
        valid = false;
    }

    public String getLogin() {
        return login;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public WebAdmin(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean authenticate() {
        DBController dbc = DBController.getInstance();
        try {
            valid = dbc.verificaUtente(this);
            System.out.println(this.toString());
        } catch (SQLException ex) {
            Logger.getLogger(WebAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valid;

    }

    /**
     * register new user
     *
     * @return false if user allready exists
     */
    public boolean register() {
        DBController dbc = DBController.getInstance();
        java.util.Date date = new java.util.Date();
        String querry = "INSERT INTO WEB_ADMIN VALUES ('" + this.getLogin() + "','" + this.getNome() + "','" + this.getPassword() + "','"
                + (new Timestamp(date.getTime())) + "');";
        try {
            return dbc.execute(querry);
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public String toString() {
        return "WebAdmin{" + "nome=" + nome + ", password=" + password + ", login=" + login + ", valid=" + valid + ", lastOnline=" + lastOnline + '}';
    }

    /**
     * Aggiorna last login del utente;
     */
    public void cleanUp() {
        DBController dbc = DBController.getInstance();
        System.out.println("Cleaning up" + this.toString());
        java.util.Date date = new java.util.Date();
        String updateLastAccessQuerry = "UPDATE WEB_ADMIN "
                + " SET LASTLOGIN ='" + (new Timestamp(new java.util.Date().getTime())) + "'"
                + " WHERE LOGIN = '" + this.login + "';";
        try {
            dbc.execute(updateLastAccessQuerry);
        } catch (SQLException ex) {
            Logger.getLogger(WebAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        reset();
    }

    private void reset() {
        this.valid = false;
        this.nome = null;
        this.password = null;
        this.login = null;
        this.lastOnline = null;
    }

}
