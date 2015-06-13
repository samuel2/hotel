/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.managedbean;

import com.urservices.urerp.hotel.entities.Chambre;
import com.urservices.urerp.hotel.metier.IChambreEJBMetierLocal;
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
@Named(value = "chambreBean")
@RequestScoped
public class ChambreBean implements Serializable {
    
    private Long chambreId;
    private Chambre chambre;
    private List<Chambre> chambres;
    
    private FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private IChambreEJBMetierLocal iChambreEJBMetierLocal;

    public ChambreBean() {
        chambre = new Chambre();
        chambres = new ArrayList<Chambre>();
    }

    public Long getChambreId() {
        return chambreId;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public List<Chambre> getChambres() {
        chambres = iChambreEJBMetierLocal.findAll();
        return chambres;
    }

    public void setChambreId(Long chambreId) {
        this.chambreId = chambreId;
        this.chambre = iChambreEJBMetierLocal.findById(chambreId);
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }
    
    public String doCreate() throws IOException{
        iChambreEJBMetierLocal.create(chambre);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + chambre.getId());
        return "show";
    }
    
    public String doDelete() throws IOException{
        iChambreEJBMetierLocal.delete(chambre);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression éffectuée avec succès", "Suppression éffectuée avec succès"));
        context.getExternalContext().redirect("list.xhtml");
        return "list";
    }
    
    public String doNew() {
        return "/views/chambre/new?faces-redirect=true";
    }
    
    public String doList() {
        return "/views/chambre/list?faces-redirect=true";
    }
    
    public String doUpdate() throws IOException {
        iChambreEJBMetierLocal.update(chambre);
        context.getExternalContext().redirect("show.xhtml?q=" + chambre.getId());
        return "show";
    }
    
    public String doEdit() {
        return "edit";
    }
    
    public String doShow() {
        return "show";
    }
    
    public void doFind() {
        chambre = iChambreEJBMetierLocal.findById(chambreId);
    }
}
