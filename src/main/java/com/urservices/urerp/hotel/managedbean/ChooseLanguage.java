/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.managedbean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@ManagedBean(name = "chooseLanguage")
@SessionScoped
public class ChooseLanguage implements Serializable{
    
    private String locale = "fr";

    public ChooseLanguage() {
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
    
    public String setFrenchLocale() {
        locale = "fr";
        return null;
    }
    
    public String setEnglishLocale() {
        locale = "en";
        return null;
    }
}
