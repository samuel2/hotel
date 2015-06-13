/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.managedbean;

import com.urservices.urerp.hotel.entities.Occupant;
import com.urservices.urerp.hotel.metier.IOccupantEJBMetierLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Named(value = "occupantBean")
@RequestScoped
public class OccupantBean implements Serializable{
    
    private Long occupantId;
    private Occupant occupant;
    private List<Occupant> occupants;
    
    private FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private IOccupantEJBMetierLocal iOccupantEJBMetierLocal;

    public OccupantBean() {
        occupant = new Occupant();
        occupants = new ArrayList<Occupant>();
    }

    public Long getOccupantId() {
        return occupantId;
    }

    public Occupant getOccupant() {
        return occupant;
    }

    public List<Occupant> getOccupants() {
        occupants = iOccupantEJBMetierLocal.findAll();
        return occupants;
    }

    public void setOccupantId(Long occupantId) {
        this.occupantId = occupantId;
        this.occupant = iOccupantEJBMetierLocal.findById(occupantId);
    }

    public void setOccupant(Occupant occupant) {
        this.occupant = occupant;
    }

    public void setOccupants(List<Occupant> occupants) {
        this.occupants = occupants;
    }
    
    public String doCreate() throws IOException {
        iOccupantEJBMetierLocal.create(occupant);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + occupant.getId());
        return "show";
    }
    
    public String doNew() {
        return "/views/occupant/new?faces-redirect=true";
    }
    
    public String doList() {
        return "/views/occupant/list?faces-redirect=true";
    }
    
    public String doUpdate() throws IOException {
        iOccupantEJBMetierLocal.update(occupant);
        context.getExternalContext().redirect("show.xhtml?q=" + occupant.getId());
        return "show";
    }
    
    public String doDelete() throws IOException {
        iOccupantEJBMetierLocal.delete(occupant);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression éffectuée avec succès", "Suppression éffectuée avec succès"));
        context.getExternalContext().redirect("list.xhtml");
        return "list";
    }
    
    public String doEdit() {
        return "edit";
    }
    
    public String doShow() {
        return "show";
    }
    
    public void doFind() {
        occupant = iOccupantEJBMetierLocal.findById(occupantId);
    }
}
