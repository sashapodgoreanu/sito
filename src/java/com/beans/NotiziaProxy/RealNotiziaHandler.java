/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans.NotiziaProxy;

import com.beans.Notizia;
import com.beans.Tipo;
import com.service.DBController;
import com.service.QueryResult;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class RealNotiziaHandler implements NotiziaHandler {

    DBController db;
    private static final Logger LOG = Logger.getLogger(RealNotiziaHandler.class.getName());


    public RealNotiziaHandler() {
        db = DBController.getInstance();
    }

    @Override
    public ArrayList<Notizia> getNotiziaPopulare() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Notizia> getNotiziaNuova() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Notizia> getNotiziaHome() {
        String query = "SELECT * FROM NOTIZIA WHERE TIPO ='" + Tipo.HOME + "'";
        QueryResult qr = null;
        
        ArrayList<Notizia> notizia = new ArrayList<>();
        try {
            qr = db.executeQuery(query);
            while (qr.next()) {
                Notizia toAdd = new Notizia(qr.getString("NOME"), qr.getString("ARTICOLO"), qr.getString("TIPO"), qr.getInt("PRIORITA"), qr.getDate("DATA_CARICAMENTO"));
                notizia.add(toAdd);
            }
        } catch (SQLException ex) {
            LOG.severe(ex.getMessage());
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        }
        return notizia;
    }

    @Override
    public ArrayList<Notizia> getNotiziaRistrutturazione() {
        String query = "SELECT * FROM NOTIZIA WHERE TIPO = " + Tipo.RISTRUTTURAZIONE;
        QueryResult qr = null;
        ArrayList<Notizia> notizia = new ArrayList<>();
        try {
            qr = db.executeQuery(query);
            while (qr.next()) {
                Notizia toAdd = new Notizia(qr.getString("NOME"), qr.getString("ARTICOLO"), qr.getString("TIPO"), qr.getDate("DATA_CARICAMENTO"));
                notizia.add(toAdd);
            }
        } catch (SQLException ex) {
            LOG.severe(ex.getMessage());
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        }
        return notizia;
    }

    @Override
    public ArrayList<Notizia> getNotiziaBagno() {
        String query = "SELECT * FROM NOTIZIA WHERE TIPO = " + Tipo.BAGNO;
        QueryResult qr = null;
        ArrayList<Notizia> notizia = new ArrayList<>();
        try {
            qr = db.executeQuery(query);
            while (qr.next()) {
                Notizia toAdd = new Notizia(qr.getString("NOME"), qr.getString("ARTICOLO"), qr.getString("TIPO"), qr.getDate("DATA_CARICAMENTO"));
                notizia.add(toAdd);
            }
        } catch (SQLException ex) {
            LOG.severe(ex.getMessage());
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        }
        return notizia;
    }

    @Override
    public ArrayList<Notizia> getNotiziaAppartamenti() {
        String query = "SELECT * FROM NOTIZIA WHERE TIPO = " + Tipo.APPARTAMENTO;
        QueryResult qr = null;
        ArrayList<Notizia> notizia = new ArrayList<>();
        try {
            qr = db.executeQuery(query);
            while (qr.next()) {
                Notizia toAdd = new Notizia(qr.getString("NOME"), qr.getString("ARTICOLO"), qr.getString("TIPO"), qr.getDate("DATA_CARICAMENTO"));
                notizia.add(toAdd);
            }
        } catch (SQLException ex) {
            LOG.severe(ex.getMessage());
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        }
        return notizia;
    }

    @Override
    public ArrayList<Notizia> getNotiziaCucina() {
        String query = "SELECT * FROM NOTIZIA WHERE TIPO = " + Tipo.CUCINA;
        QueryResult qr = null;
        ArrayList<Notizia> notizia = new ArrayList<>();
        try {
            qr = db.executeQuery(query);
            while (qr.next()) {
                Notizia toAdd = new Notizia(qr.getString("NOME"), qr.getString("ARTICOLO"), qr.getString("TIPO"), qr.getDate("DATA_CARICAMENTO"));
                notizia.add(toAdd);
            }
        } catch (SQLException ex) {
            LOG.severe(ex.getMessage());
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        }
        return notizia;
    }

    @Override
    public ArrayList<Notizia> getNotiziaDecorazioni() {
        String query = "SELECT * FROM NOTIZIA WHERE TIPO = " + Tipo.DECORAZIONI;
        QueryResult qr = null;
        ArrayList<Notizia> notizia = new ArrayList<>();
        try {
            qr = db.executeQuery(query);
            while (qr.next()) {
                Notizia toAdd = new Notizia(qr.getString("NOME"), qr.getString("ARTICOLO"), qr.getString("TIPO"), qr.getDate("DATA_CARICAMENTO"));
                notizia.add(toAdd);
            }
        } catch (SQLException ex) {
            LOG.severe(ex.getMessage());
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        }
        return notizia;
    }

    @Override
    public ArrayList<Notizia> getNotiziaCondominio() {
        String query = "SELECT * FROM NOTIZIA WHERE TIPO = " + Tipo.CONDOMINIO;
        QueryResult qr = null;
        ArrayList<Notizia> notizia = new ArrayList<>();
        try {
            qr = db.executeQuery(query);
            while (qr.next()) {
                Notizia toAdd = new Notizia(qr.getString("NOME"), qr.getString("ARTICOLO"), qr.getString("TIPO"), qr.getDate("DATA_CARICAMENTO"));
                notizia.add(toAdd);
            }
        } catch (SQLException ex) {
            LOG.severe(ex.getMessage());
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        }
        return notizia;
    }

    @Override
    public boolean IsDirty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDirty(boolean isDirty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
