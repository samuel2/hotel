/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.managedbean;

import com.urservices.urerp.hotel.entities.Reglement;
import com.urservices.urerp.hotel.metier.IReglementEJBMetierLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@ManagedBean(name = "reglementListBean")
@ViewScoped
public class ReglementListBean implements Serializable {
    
    private Reglement reglement;
    private List<Reglement> reglements;
    private boolean buttonDisabled = true;
    
    @EJB
    private IReglementEJBMetierLocal iReglementEJBMetierLocal;

    public ReglementListBean() {
        reglement = new Reglement();
        buttonDisabled = true;
    }

    public Reglement getReglement() {
        return reglement;
    }

    public List<Reglement> getReglements() {
        return reglements;
    }

    public void setReglement(Reglement reglement) {
        this.reglement = reglement;
        buttonDisabled = false;
    }

    public void setReglements(List<Reglement> reglements) {
        this.reglements = reglements;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public List<Reglement> getAllReglements() {
        return iReglementEJBMetierLocal.findAll();
    }
    
    public String getEditUrl() {
        return "/views/reglement/edit";
    }
    
    public String getShowUrl() {
        return "/views/reglement/show";
    }
    
    public String getDeleteUrl() {
        return "/views/reglement/delete";
    }
}
