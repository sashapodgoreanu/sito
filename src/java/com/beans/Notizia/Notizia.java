/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans.Notizia;

import com.beans.Notizia.NotiziaHandler;
import com.service.DBController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author SashaAlexandru
 */
@Component
@Scope("prototype")
public class Notizia extends Observable {
    
    
    @Autowired
    NotiziaHandler notiziaHandler;
    private static final Logger LOG = Logger.getLogger(Notizia.class.getName());
    private String nome;
    private int id;
    private String articolo;
    private String tipo;
    private int priorita;
    private Date dataCaricamento;
    private int numVis;
    private int popularita;
    public ArrayList<Immagine> immagini;

    public Notizia() {
        immagini = new ArrayList<>();
    }

    public Notizia(String nome, String testo, String tipo, Date dataCaricamento) {
        this.nome = nome;
        this.articolo = testo;
        this.tipo = tipo;
        this.dataCaricamento = dataCaricamento;
        immagini = new ArrayList<>();
       
    }

    public Notizia(String nome, String testo, String tipo, int priorita, Date dataCaricamento) {
        this.nome = nome;
        this.articolo = testo;
        this.tipo = tipo;
        this.priorita = priorita;
        this.dataCaricamento = dataCaricamento;
        immagini = new ArrayList<>();
    }

    public Notizia(String nome, int priorita) {
        this.nome = nome;
        this.priorita = priorita;
    }

    public boolean salva() {
        System.out.println("Notizia Handler***********" + notiziaHandler);
        boolean result = false;
        this.addObserver(notiziaHandler);//add an observer
        setChanged();
        notifyObservers();
        DBController dbc = DBController.getInstance();
        String queryInsert = querryInsert();
        try {
            int newID = dbc.executeUpdateAndReturnKey(queryInsert);
            if (newID != -1) {
                this.id = newID;
                System.out.println("INFO DATA:" + this.getClass() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Aggiunto con successo " + this.toString());
                result = true;
                //salva riferimento notizia_immagine
                for (Immagine img : immagini) {
                    System.out.println(img.getId());
                    String queryInsertImgNotizia = queryInsertImgNotizia(img);
                    result = dbc.execute(queryInsertImgNotizia) && result;// se almeno un fallimento allora result =  false
                    //se è stato un errore return false
                    if (result == false) {
                        return false;
                    } else {
                        System.out.println("INFO DATA:" + this.getClass() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Query eseguita: " + queryInsertImgNotizia);
                    }
                }
            }//se newID = -1 allora è stato un errore nel inserimento nel db;
            else {
                LOG.severe("Errore: non è stato possibile salvare la notizia");
                return false;
            }
        } catch (SQLException ex) {
            LOG.severe(ex.getMessage());
        }
        return result;
    }

    private String queryInsertImgNotizia(Immagine img) {
        String queryInsertImgNotizia = "INSERT INTO NOTIZIA_IMMAGINI(ID_NOTIZIA,ID_IMMAGINE)"
                + "VALUES("
                + this.id
                + ","
                + img.getId()
                + ")";
        return queryInsertImgNotizia;
    }

    private String querryInsert() {
        String queryInsert = "INSERT INTO NOTIZIA(NOME,ARTICOLO,TIPO,PRIORITA,DATA_CARICAMENTO)"
                + "VALUES('"
                + this.getNome()
                + "','"
                + this.getTesto()
                + "','"
                + this.tipo
                + "','"
                + this.priorita
                + "','"
                + this.getDataCaricamento()
                + "')";
        return queryInsert;
    }

    public void addImmagine(Immagine img) {
        immagini.add(img);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTesto() {
        return articolo;
    }

    public void setTesto(String testo) {
        this.articolo = testo;
    }

    public int getNumVis() {
        return numVis;
    }

    public void setNumVis(int numVis) {
        this.numVis = numVis;
    }

    public int getPopularita() {
        return popularita;
    }

    public void setPopularita(int popularita) {
        this.popularita = popularita;
    }

    public ArrayList<Immagine> getImmagini() {
        return immagini;
    }

    public void setImmagini(ArrayList<Immagine> immagini) {
        this.immagini = immagini;
    }

    public Date getDataCaricamento() {
        return dataCaricamento;
    }

    public void setDataCaricamento(Date dataCaricamento) {
        this.dataCaricamento = dataCaricamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticolo() {
        return articolo;
    }

    public void setArticolo(String articolo) {
        this.articolo = articolo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPriorita() {
        return priorita;
    }

    public void setPriorita(int priorita) {
        this.priorita = priorita;
    }

    @Override
    public String toString() {
        if (immagini != null) {
            return "Notizia{" + "nome=" + nome + ", id=" + id + ", testo=" + articolo + ", tipo=" + tipo + ", priorita=" + priorita + ", dataCaricamento=" + dataCaricamento + ",\n immagini=" + immagini.toString() + '}';
        } else {
            return "Notizia{" + "nome=" + nome + ", id=" + id + ", testo=" + articolo + ", tipo=" + tipo + ", priorita=" + priorita + ", dataCaricamento=" + dataCaricamento + '}';
        }
    }
}
