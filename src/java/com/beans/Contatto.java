/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.service.DBController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SashaAlexandru
 */
public class Contatto {

    private static final Logger LOG = Logger.getLogger(Contatto.class.getName());

    private String nome;
    private String telefono;
    private String email;
    private String messaggio;

    public Contatto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public boolean salva() {
        boolean result = false;
        DBController dbc = DBController.getInstance();
        String queryInsert = querryInsert();
        try {
            int newID = dbc.executeUpdateAndReturnKey(queryInsert);
            if (newID != -1) {
                System.out.println("INFO DATA:" + this.getClass() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Aggiunto con successo " + this.toString());
                result = true;
            }//se newID = -1 allora è stato un errore nel inserimento nel db;
            else {
                LOG.log(Level.SEVERE, "Errore: non \u00e8 stato possibile salvare {0}", this.toString());
                return false;
            }
        } catch (SQLException ex) {
            LOG.severe(ex.getMessage());
        }
        return result;
    }

    private String querryInsert() {
        String queryInsert = "INSERT INTO Contatto(NOME,TELEFONO,EMAIL,MESSAGGIO)"
                + "VALUES('"
                + this.getNome()
                + "','"
                + this.getTelefono()
                + "','"
                + this.getEmail()
                + "','"
                + this.getMessaggio()
                + "')";
        return queryInsert;
    }


    @Override
    public String toString() {
        return "Contatto{" + "nome=" + nome + ", telefono=" + telefono + ", email=" + email + ", messaggio=" + messaggio + '}';
    }

}
