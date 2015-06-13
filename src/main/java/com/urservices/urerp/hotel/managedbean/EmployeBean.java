/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.managedbean;

import com.urservices.urerp.hotel.entities.Employe;
import com.urservices.urerp.hotel.entities.Fonction;
import com.urservices.urerp.hotel.entities.Periode;
import com.urservices.urerp.hotel.metier.IEmployeEJBMetierLocal;
import com.urservices.urerp.hotel.metier.IFonctionEJBMetierLocal;
import com.urservices.urerp.hotel.metier.IPeriodeEJBMetierLocal;
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
@Named(value = "employeBean")
@RequestScoped
public class EmployeBean implements Serializable {
    
    private Long employeId;
    private Employe employe;
    private Periode periode;
    private Periode newPeriode;
    private List<Employe> employes;
    private List<Periode> periodes;
    private List<Fonction> fonctions;
    
    private FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private IEmployeEJBMetierLocal iEmployeEJBMetierLocal;
    
    @EJB
    private IPeriodeEJBMetierLocal iPeriodeEJBMetierLocal;
    
    @EJB
    private IFonctionEJBMetierLocal iFonctionEJBMetierLocal;

    public EmployeBean() {
        employe = new Employe();
        periode = new Periode();
        newPeriode = new Periode();
        employes = new ArrayList<Employe>();
    }

    public Long getEmployeId() {
        return employeId;
    }

    public Employe getEmploye() {
        return employe;
    }

    public List<Employe> getEmployes() {
        employes = iEmployeEJBMetierLocal.findAll();
        return employes;
    }

    public Periode getPeriode() {
        return periode;
    }

    public Periode getNewPeriode() {
        return newPeriode;
    }

    public List<Periode> getPeriodes() {
        periodes = iPeriodeEJBMetierLocal.findAll();
        return periodes;
    }

    public List<Fonction> getFonctions() {
        fonctions = iFonctionEJBMetierLocal.findAll();
        return fonctions;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public void setFonctions(List<Fonction> fonctions) {
        this.fonctions = fonctions;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public void setNewPeriode(Periode newPeriode) {
        this.newPeriode = newPeriode;
    }

    public void setPeriodes(List<Periode> periodes) {
        this.periodes = periodes;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public void setEmployeId(Long employeId) {
        this.employeId = employeId;
        employe = iEmployeEJBMetierLocal.findById(employeId);
        periodes = iPeriodeEJBMetierLocal.findPeriodesEmploye(employe);
    }
    
    public void setShowId(Long employeId) {
        this.employeId = employeId;
        employe = iEmployeEJBMetierLocal.findById(employeId);
        periodes = iPeriodeEJBMetierLocal.findPeriodesEmploye(employe);
    }
    
    public void setEditId(Long employeId) {
        this.employeId = employeId;
        employe = iEmployeEJBMetierLocal.findById(employeId);
        periodes = iPeriodeEJBMetierLocal.findPeriodesEmploye(employe);
    }
    
    public String doCreate() throws IOException {
        iEmployeEJBMetierLocal.create(employe, periode);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + employe.getId());
        return "show";
    }
    
    public String doNew() {
        return "/views/employe/new?faces-redirect=true";
    }
    
    public String doList() {
        return "/views/employe/list?faces-redirect=true";
    }
    
    public String doUpdate() throws IOException {
        iEmployeEJBMetierLocal.update(employe, periode);
        context.getExternalContext().redirect("show.xhtml?q=" + employe.getId());
        return "show";
    }
    
    public String doDelete() throws IOException {
        iPeriodeEJBMetierLocal.deletePeriodeEmploye(employe.getId());
        iEmployeEJBMetierLocal.delete(employe);
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
        employe = iEmployeEJBMetierLocal.findById(employeId);
    }
    
    public String doModification() throws IOException {
        iPeriodeEJBMetierLocal.update(employe, periode);
        iEmployeEJBMetierLocal.change(employe, newPeriode);
        context.getExternalContext().redirect("show.xhtml?q=" + employe.getId());
        return "show";
    }
}
