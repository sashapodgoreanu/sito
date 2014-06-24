/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans.Notizia;

import com.service.DBController;
import com.service.QueryResult;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;

public class RealNotiziaHandler extends NotiziaHandler {

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
        ArrayList<Notizia> notizia = getNotizia(query);
        Collections.sort(notizia, new NotiziaConPrioritaComparator());
        return notizia;
    }

    private ArrayList<Notizia> getNotizia(String query) {
        QueryResult qr = null;
        ArrayList<Notizia> notizia = new ArrayList<>();
        try {
            qr = db.executeQuery(query);
            while (qr.next()) {
                Notizia toAdd = new Notizia(qr.getInt("ID"), qr.getString("NOME"), qr.getString("ARTICOLO"), qr.getString("TIPO"), qr.getInt("PRIORITA"), qr.getDate("DATA_CARICAMENTO"));
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
        Collections.sort(notizia, new NotiziaConPrioritaComparator());
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
        Collections.sort(notizia, new NotiziaConPrioritaComparator());
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
        Collections.sort(notizia, new NotiziaConPrioritaComparator());
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
        Collections.sort(notizia, new NotiziaConPrioritaComparator());
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
        Collections.sort(notizia, new NotiziaConPrioritaComparator());
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
        Collections.sort(notizia, new NotiziaConPrioritaComparator());
        return notizia;
    }

    @Override
    public ArrayList<Notizia> getNotiziaPosaPavimenti() {
        String query = "SELECT * FROM NOTIZIA WHERE TIPO ='" + Tipo.POSA_PAVIMENTI + "'";
        ArrayList<Notizia> notizia = getNotizia(query);
        Collections.sort(notizia, new NotiziaConPrioritaComparator());
        return notizia;
    }

    @Override
    public ArrayList<Notizia> getNotiziaAll() {
        String query = "SELECT * FROM NOTIZIA";
        ArrayList<Notizia> notizia = getNotizia(query);
        return notizia;
    }

    @Override
    public Notizia loadNotizia(int id) {
        String query = "SELECT * FROM NOTIZIA WHERE ID =" + id;
        QueryResult qr = null;
        Notizia notizia = null;
        try {
            qr = db.executeQuery(query);
            while (qr.next()) {
                notizia = new Notizia(qr.getInt("ID"), qr.getString("NOME"), qr.getString("ARTICOLO"), qr.getString("TIPO"), qr.getInt("PRIORITA"), qr.getDate("DATA_CARICAMENTO"));
            }
        } catch (SQLException ex) {
            LOG.severe(ex.getMessage());
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        }
        return notizia;
    }
}
