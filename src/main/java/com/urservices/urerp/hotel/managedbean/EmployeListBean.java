/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.managedbean;

import com.urservices.urerp.hotel.entities.Employe;
import com.urservices.urerp.hotel.metier.IEmployeEJBMetierLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@ManagedBean(name = "employeListBean")
@ViewScoped
public class EmployeListBean implements Serializable {
    
    private Employe employe;
    private List<Employe> employes;
    private boolean buttonDisabled = true;
    
    @EJB
    private IEmployeEJBMetierLocal iEmployeEJBMetierLocal;

    public EmployeListBean() {
        employe = new Employe();
        buttonDisabled = true;
    }

    public Employe getEmploye() {
        return employe;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
        buttonDisabled = false;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public List<Employe> getAllEmployes() {
        return iEmployeEJBMetierLocal.findAll();
    }
    
    public String getEditUrl() {
        return "/views/employe/edit";
    }
    
    public String getShowUrl() {
        return "/views/employe/show";
    }
    
    public String getDeleteUrl() {
        return "/views/employe/delete";
    }
}
