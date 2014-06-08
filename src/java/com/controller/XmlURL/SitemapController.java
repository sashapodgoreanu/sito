/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller.XmlURL;

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

    @RequestMapping(value = "/sitemap.xml", method = RequestMethod.GET)
    @ResponseBody
    public XmlUrlSet main() {
        XmlUrlSet xmlUrlSet = new XmlUrlSet();
        create(xmlUrlSet, "", XmlUrl.Priority.HIGH);
        create(xmlUrlSet, "/index", XmlUrl.Priority.HIGH);
        create(xmlUrlSet, "/azzienda", XmlUrl.Priority.MEDIUM);
        create(xmlUrlSet, "/contatti", XmlUrl.Priority.HIGH);

        // for loop to generate all the links by querying against database
        return xmlUrlSet;
    }

    private void create(XmlUrlSet xmlUrlSet, String link, XmlUrl.Priority priority) {
        xmlUrlSet.addUrl(new XmlUrl("http://www.damicicostruzioni.it" + link, priority));
    }

}
