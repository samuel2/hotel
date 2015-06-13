/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.managedbean;

import com.urservices.urerp.hotel.entities.Reglement;
import com.urservices.urerp.hotel.metier.IReglementEJBMetierLocal;
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
@Named(value = "reglementBean")
@RequestScoped
public class ReglementBean implements Serializable {
    
    private Long reglementId;
    private Reglement reglement;
    private List<Reglement> reglements;
    
    private FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private IReglementEJBMetierLocal iReglementEJBMetierLocal;

    public ReglementBean() {
        reglement = new Reglement();
        reglements = new ArrayList<Reglement>();
    }
    
    public Long getReglementId() {
        return reglementId;
    }

    public Reglement getReglement() {
        return reglement;
    }

    public List<Reglement> getReglements() {
        reglements = iReglementEJBMetierLocal.findAll();
        return reglements;
    }

    public void setReglementId(Long reglementId) {
        this.reglementId = reglementId;
        this.reglement = iReglementEJBMetierLocal.findById(reglementId);
    }

    public void setReglement(Reglement reglement) {
        this.reglement = reglement;
    }

    public void setReglements(List<Reglement> reglements) {
        this.reglements = reglements;
    }
    
    public String doCreate() throws IOException {
        iReglementEJBMetierLocal.create(reglement);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + reglement.getId());
        return "show";
    }
    
    public String doDelete() throws IOException {
        iReglementEJBMetierLocal.delete(reglement);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression éffectuée avec succès", "Suppression éffectuée avec succès"));
        context.getExternalContext().redirect("list.xhtml");
        return "list";
    }
    
    public String doUpdate() throws IOException {
        iReglementEJBMetierLocal.update(reglement);
        context.getExternalContext().redirect("show.xhtml?q=" + reglement.getId());
        return "show";
    }
    
    public String doNew() {
        return "/views/reglement/new?faces-redirect=true";
    }
    
    public String doList() {
        return "/views/reglement/list?faces-redirect=true";
    }
    
    public String doEdit() {
        return "edit";
    }
    
    public String doShow() {
        return "show";
    }
    
    public void doFind() {
        reglement = iReglementEJBMetierLocal.findById(reglementId);
    }
}
