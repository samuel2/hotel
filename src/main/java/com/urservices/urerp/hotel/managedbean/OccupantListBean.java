/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.managedbean;

import com.urservices.urerp.hotel.entities.Occupant;
import com.urservices.urerp.hotel.metier.IOccupantEJBMetierLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@ManagedBean(name = "occupantListBean")
@ViewScoped
public class OccupantListBean implements Serializable{
    
    private Occupant occupant;
    private List<Occupant> occupants;
    private boolean buttonDisabled = true;
    
    @EJB
    private IOccupantEJBMetierLocal iOccupantEJBMetierLocal;

    public OccupantListBean() {
        occupant = new Occupant();
        buttonDisabled = true;
    }

    public Occupant getOccupant() {
        return occupant;
    }

    public List<Occupant> getOccupants() {
        return occupants;
    }

    public void setOccupant(Occupant occupant) {
        this.occupant = occupant;
        buttonDisabled = false;
    }

    public void setOccupants(List<Occupant> occupants) {
        this.occupants = occupants;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public List<Occupant> getAllOccupants() {
        return iOccupantEJBMetierLocal.findAll();
    }
    
    public String getEditUrl() {
        return "/views/occupant/edit";
    }
    
    public String getShowUrl() {
        return "/views/occupant/show";
    }
    
    public String getDeleteUrl() {
        return "/views/occupant/delete";
    }
}
