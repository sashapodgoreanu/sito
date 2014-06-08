/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

/**
 *
 * @author SashaAlexandru
 */
public class Utilitys {
    
    /**
     * il metodo restituisce data della ultima modifica del file che ha il path @param reqPath
     * @param reqPath Path del file
     * @param ctx ServletContext
     * @return ultima modifica del file
     * @throws FileNotFoundException 
     */
    public static String fetchDate(String reqPath, ServletContext ctx) throws FileNotFoundException { 
        String jspPath = ctx.getRealPath(reqPath); 
        File jspFile = new File(jspPath);
        System.out.println("test: "+ jspFile.lastModified());
        Date lastModified = new Date(jspFile.lastModified()); 
        SimpleDateFormat fmt = new SimpleDateFormat("EEEE, dd-MMMM-yyyy, HH:mm (zzzzz)");
        return fmt.format(lastModified); 
    }
    
    /**
     * Restituice il nome del file caricato in formato multipart dal browser web
     * @param part multipart file
     * @return nome del file che il web browser a fatto upload.
     */
    public static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
}
