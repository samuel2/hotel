/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.managedbean;

import com.urservices.urerp.hotel.entities.Fonction;
import com.urservices.urerp.hotel.metier.IFonctionEJBMetierLocal;
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
@Named(value = "fonctionBean")
@RequestScoped
public class FonctionBean implements Serializable {
    
    private Long fonctionId;
    private Fonction fonction;
    private List<Fonction> fonctions;
    private FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private IFonctionEJBMetierLocal iFonctionEJBMetierLocal;

    public FonctionBean() {
        fonction = new Fonction();
        fonctions = new ArrayList<Fonction>();
    }

    public Long getFonctionId() {
        return fonctionId;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public List<Fonction> getFonctions() {
        return fonctions;
    }

    public void setFonctionId(Long fonctionId) {
        this.fonctionId = fonctionId;
        fonction = iFonctionEJBMetierLocal.findById(fonctionId);
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    public void setFonctions(List<Fonction> fonctions) {
        this.fonctions = fonctions;
    }
    
    public String doCreate() throws IOException {
        iFonctionEJBMetierLocal.create(fonction);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + fonction.getId());
        return "show";
    }
    
    public String doNew() {
        return "/views/fonction/new?faces-redirect=true";
    }
    
    public String doList() {
        return "/views/fonction/list?faces-redirect=true";
    }
    
    public String doUpdate() throws IOException {
        iFonctionEJBMetierLocal.update(fonction);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification éffectuée avec succès", "Modification éffectuée avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + fonction.getId());
        return "show";
    }
    
    public String doDelete() throws IOException {
        iFonctionEJBMetierLocal.delete(fonction);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression éffectuée avec succès", "Suppression éffectuée avec succès"));
        context.getExternalContext().redirect("list.xhtml");
        return "list";
    }
    
    public String doShow() {
        return "show";
    }
    
    public String doEdit() {
        return "edit";
    }
    
    public void doFind() {
        fonction = iFonctionEJBMetierLocal.findById(fonctionId);
    }
}
