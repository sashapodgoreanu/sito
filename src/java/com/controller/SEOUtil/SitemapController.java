/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller.SEOUtil;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author SashaAlexandru
 */
@Controller
public class SitemapController {

    @Autowired
    Url url;

    @RequestMapping(value = "/sitemap.xml", method = RequestMethod.GET)
    @ResponseBody//serve per serializare un oggetto e inviarlo al browser
    public XmlUrlSet main() throws Exception {
        XmlUrlSet xmlUrlSet = new XmlUrlSet();
        create(xmlUrlSet, "", Priority.HIGH);
        ArrayList<Tupla> tupla = url.getURLs();
        for (Tupla tupla1 : tupla) {
            create(xmlUrlSet, "/" + tupla1.url() + "/", tupla1.priorita(), tupla1.dataModifica());
        }
        return xmlUrlSet;
    }

    private void create(XmlUrlSet xmlUrlSet, String link, Priority priority) {
        xmlUrlSet.addUrl(new XmlUrl("http://www.damicicostruzioni.it" + link, priority));
    }
    private void create(XmlUrlSet xmlUrlSet, String link, Priority priority, String lastMod) {
        xmlUrlSet.addUrl(new XmlUrl("http://www.damicicostruzioni.it" + link, priority, lastMod));
    }

}
