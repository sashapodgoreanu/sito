package com.controller.SEOUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SashaAlexandru
 */
@XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "url")
public class XmlUrl {

    @XmlElement
    private String loc;

    @XmlElement
    private String lastmod;

    @XmlElement
    private String changefreq = "weekly";

    @XmlElement
    private String priority;

    public XmlUrl() {
    }

    public XmlUrl(String loc, Priority priority) {
        this.loc = loc;
        this.priority = priority.getValue();
        this.lastmod = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    }

    public XmlUrl(String loc, Priority priority, String lastmod) {
        this.loc = loc;
        this.priority = priority.getValue();
        this.lastmod = lastmod;
    }

    public String getLoc() {
        return loc;
    }

    public String getPriority() {
        return priority;
    }

    public String getChangefreq() {
        return changefreq;
    }

    public String getLastmod() {
        return lastmod;
    }
}
