/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author samuel < smlfolong@gmail.com >
 */
@Embeddable
public class Adresse implements Serializable{
    
    protected String telephone;
    protected String email;
    protected String boitePostal;

    public Adresse() {
    }

    public Adresse(String telephone, String email, String boitePostal) {
        this.telephone = telephone;
        this.email = email;
        this.boitePostal = boitePostal;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getBoitePostal() {
        return boitePostal;
    }

    public String getEmail() {
        return email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBoitePostal(String boitePostal) {
        this.boitePostal = boitePostal;
    }
}
