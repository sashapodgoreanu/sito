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
public class MultiFileUpload {

    private List<MultipartFile> crunchifyFiles;

    public List<MultipartFile> getFiles() {
        return crunchifyFiles;
    }

    public void setFiles(List<MultipartFile> files) {
        this.crunchifyFiles = files;
    }

}
