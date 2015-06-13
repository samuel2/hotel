/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.managedbean;

import com.urservices.urerp.hotel.entities.Fonction;
import com.urservices.urerp.hotel.metier.IFonctionEJBMetierLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@ManagedBean(name = "fonctionListBean")
@ViewScoped
public class FonctionListBean implements Serializable{
    
    private Fonction fonction;
    private List<Fonction> fonctions;
    private boolean buttonDisabled = true;

    @EJB
    private IFonctionEJBMetierLocal iFonctionEJBMetierLocal;
    
    public FonctionListBean() {
        fonction = new Fonction();
        buttonDisabled = true;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public List<Fonction> getFonctions() {
        return fonctions;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
        buttonDisabled = false;
    }

    public void setFonctions(List<Fonction> fonctions) {
        this.fonctions = fonctions;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public List<Fonction> getAllFonctions() {
        return iFonctionEJBMetierLocal.findAll();
    }
    
    public String getEditUrl() {
        return "/views/fonction/edit";
    }
    
    public String getShowUrl() {
        return "/views/fonction/show";
    }
    
    public String getDeleteUrl() {
        return "/views/fonction/delete";
    }
}
