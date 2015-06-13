/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.managedbean;

import com.urservices.urerp.hotel.entities.Chambre;
import com.urservices.urerp.hotel.metier.IChambreEJBMetierLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@ManagedBean(name = "chambreListBean")
@ViewScoped
public class ChambreListBean implements Serializable {
    
    private Chambre chambre;
    private List<Chambre> chambres;
    private boolean buttonDisabled = true;
    
    @EJB
    private IChambreEJBMetierLocal iChambreEJBMetierLocal;

    public ChambreListBean() {
        chambre = new Chambre();
        buttonDisabled = true;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
        buttonDisabled = false;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public List<Chambre> getAllChambres() {
        return iChambreEJBMetierLocal.findAll();
    }
    
    public String getEditUrl() {
        return "/views/chambre/edit";
    }
    
    public String getShowUrl() {
        return "/views/chambre/show";
    }
    
    public String getDeleteUrl() {
        return "/views/chambre/delete";
    }
}
