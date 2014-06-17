/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author SashaAlexandru
 */
public class NotiziaMultifileUpload extends Notizia {

    private List<MultipartFile> files;

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }

    @Override
    public void setPriorita(int priorita) {
        super.setPriorita(priorita);
    }

    @Override
    public void setTipo(String tipo) {
        super.setTipo(tipo);
    }

    @Override
    public String getTipo() {
        return super.getTipo();
    }

    @Override
    public void setArticolo(String articolo) {
        super.setArticolo(articolo);
    }

    @Override
    public String getArticolo() {
        return super.getArticolo();
    }

    @Override
    public void setTesto(String testo) {
        super.setTesto(testo);
    }

    @Override
    public String getTesto() {
        return super.getTesto();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }


}
