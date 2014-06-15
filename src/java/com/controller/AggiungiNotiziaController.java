/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.beans.Immagine;
import com.beans.MultiFileUpload;
import com.beans.Notizia;
import com.beans.NotiziaProxy.ProxyNotiziaHandler;
import com.beans.WebAdmin;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sasha Alexandru Podgoreanu
 */
@Controller
@MultipartConfig //to enable multipart parsing
public class AggiungiNotiziaController {

    private Log log;

    @Autowired
    LoginController loginController;

    //path dell http://www.damicicostruzioni.it/images/ 
    //private static final String imagesPath = "C:/PROGRA~1/APACHE~1/TOMCAT~1.34/instances/tomcat7.0.34_835/images";
    @Autowired
    ServletContext servletContext;
    @Autowired
    private HttpSession session;
    @Autowired
    private WebAdmin webAdmin;
    //private static final String imagesPath = "C://XML//";
    private String imagesPath;

    @RequestMapping(value = "aggiungi-notizia/upload", method = RequestMethod.POST)
    public ModelAndView handleFormUpload(@ModelAttribute("uploadForm") MultiFileUpload mfu,
            @RequestParam("tipoNotizia") String tipoNotizia,
            @RequestParam("titoloNotizia") String titoloNotizia,
            @RequestParam("corpoNotizia") String corpoNotizia
    ) {

        //webAdmin = (WebAdmin) session.getAttribute("webAdminSession");
        if (!webAdmin.isValid()) {
            //utente non autenticato
            loginController.redirectLogin();
        }
        //per prevenire che la stessa notizia venga salvata piu di una volta al click del refresh del browser
        boolean idNotizia = (boolean) session.getAttribute("idNotizia");
        System.out.println("***********************************" + idNotizia);
        if (idNotizia == false) {
            return new ModelAndView("redirect:/aggiungi-notizia/");
         } else {
            session.setAttribute("idNotizia", false);
        }
        Notizia notizia = new Notizia(titoloNotizia, corpoNotizia, tipoNotizia, (new Timestamp(new java.util.Date().getTime())));
        List<MultipartFile> filePartsList = mfu.getFiles();
        boolean success = true;
        for (MultipartFile filePart : filePartsList) {
            //Inizia Salvataggio su disco
            String filename = filePart.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            filename = uuid + "_" + filename;
            try {
                InputStream filecontent = filePart.getInputStream();
                try (OutputStream out
                        = new FileOutputStream(imagesPath + "/" + filename)) {
                    IOUtils.copy(filecontent, out);
                    out.flush();
                }
            } catch (IOException ex) {
                Logger.getLogger(AggiungiNotiziaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Fine salvataggio su disco
            Immagine img = new Immagine(0, filename, "Ok come stai", (new Timestamp(new java.util.Date().getTime())), filePart.getSize());//creea una nuova immagine
            success = img.salva() && success;//salva imagine, il risultato si evalua con quello precedente. Se esiste almeno un falimento, success sara false.
            notizia.addImmagine(img);
        }
        notizia.salva();
        ModelAndView mav = new ModelAndView("upload_status");
        mav.addObject("success", success);
        mav.addObject("notizia", notizia);
        return mav;
    }

    @RequestMapping(value = "aggiungi-notizia/upload", method = RequestMethod.GET)
    public String handleFormUploadGET() {
        return "redirect:/aggiungi-notizia/";
    }

    @RequestMapping(value = "aggiungi-notizia/", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView aggiungiNotizia() {
        //System.out.println("imagesPath  " + imagesPath);
        ProxyNotiziaHandler proxy = ProxyNotiziaHandler.getInstance();
        //webAdmin = (WebAdmin) session.getAttribute("webAdminSession");
        if (!webAdmin.isValid()) {
            loginController.redirectLogin();
        }

        //per prevenire che la stessa notizia venga salvata piu di una volta al click del refresh del browser
        session.setAttribute("idNotizia", true);
        ModelAndView mav = new ModelAndView("aggiungi_notizia");
        MultiFileUpload uploadImmagini = new MultiFileUpload();
        mav.addObject("uploadImmagini", uploadImmagini);
        return mav;
    }

    @RequestMapping(value = {"aggiungi-notizia"}, method = {RequestMethod.GET})
    public String redirectAggiungiNotizia() {
        return "redirect:aggiungi-notizia/";
    }

    @PostConstruct
    public void Init() {
        log = LogFactory.getLog(AggiungiNotiziaController.class);
        imagesPath = servletContext.getRealPath("/WEB-INF/resources/immagini/");
        //session.setAttribute("webAdminSession", null);
    }
}
