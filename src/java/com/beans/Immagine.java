/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.service.DBController;
import java.sql.SQLException;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Sasha Alexandru Podgoreanu
 */
public class Immagine {

    private Log log = LogFactory.getLog(Immagine.class);

    private int id;
    private String nome;
    private String descrizione;
    private int numVis;
    private Date dataCaricamento;
    private long dim;

    public Immagine(int id, String nome, String descrizione, Date dataCaricamento, long dim) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataCaricamento = dataCaricamento;
        this.dim = dim;
    }

    public boolean salva() {
        boolean result = false;
        DBController dbc = DBController.getInstance();
        String queryInsert = "INSERT INTO IMMAGINE(NOME,DESCRIZIONE,DATA_CARICAMENTO,SIZE)"
                + "VALUES('"
                + this.getNome()
                + "','"
                + this.getDescrizione()
                + "','"
                + this.getDataCaricamento()
                + "',"
                + this.getDim()
                + ")";
        try {
            int newID = dbc.executeUpdateAndReturnKey(queryInsert);
            if (newID != -1) {
                this.id = newID;
                System.out.println("INFO DATA:" + this.getClass() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Aggiunto con successo " + this.toString());
                System.out.println(true);
                return true;
            }//se newID = -1 allora è stato un errore nel inserimento nel db;
            else {
                System.out.println(false);
                log.fatal("Errore: non è stato possibile salvare l'immagine");
                return false;
            }
        } catch (SQLException ex) {
            log.fatal(ex.getMessage());
        }
        return result;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int aId) {
        this.id = aId;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String aDescrizione) {
        this.descrizione = aDescrizione;
    }

    public int getNumVis() {
        return this.numVis;
    }

    public void setNumVis(int aNumVis) {
        this.numVis = aNumVis;
    }

    public Date getDataCaricamento() {
        return dataCaricamento;
    }

    public void setDataCaricamento(Date dataCaricamento) {
        this.dataCaricamento = dataCaricamento;
    }


    public long getDim() {
        return this.dim;
    }

    public void setDim(long aDim) {
        this.dim = aDim;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Immagine{" + "id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", numVis=" + numVis + ", dataCaricamento=" + dataCaricamento + ", dim=" + dim + '}';
    }


}
