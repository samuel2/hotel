/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.metier;

import com.urservices.urerp.hotel.dao.IEmployeEJBDaoLocal;
import com.urservices.urerp.hotel.dao.IFonctionEJBDaoLocal;
import com.urservices.urerp.hotel.dao.IPeriodeEJBDaoLocal;
import com.urservices.urerp.hotel.entities.Employe;
import com.urservices.urerp.hotel.entities.Periode;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Stateless
public class EmployeEJBMetier implements IEmployeEJBMetierLocal, IEmployeEJBMetierRemote, Serializable{

    @EJB
    private IEmployeEJBDaoLocal iEmployeEJBDaoLocal;
    
    @EJB
    private IPeriodeEJBDaoLocal iPeriodeEJBDaoLocal;
    
    @EJB
    private IFonctionEJBDaoLocal iFonctionEJBDaoLocal;
    
    @Override
    public Employe create(Employe employe) {
        return iEmployeEJBDaoLocal.create(employe);
    }

    @Override
    public Employe update(Employe employe) {
        return iEmployeEJBDaoLocal.update(employe);
    }

    @Override
    public int delete(Employe employe) {
        return iEmployeEJBDaoLocal.delete(employe);
    }

    @Override
    public Employe findById(Long id) {
        return iEmployeEJBDaoLocal.findById(id);
    }

    @Override
    public Employe findByCni(String cni) {
        return iEmployeEJBDaoLocal.findByCni(cni);
    }

    @Override
    public List<Employe> findAll() {
        return iEmployeEJBDaoLocal.findAll();
    }

    @Override
    public void change(Employe employe, Periode periode) {
        periode.setFonction(iFonctionEJBDaoLocal.findById(periode.getFonction().getId()));
        periode.setEmploye(employe);
        iPeriodeEJBDaoLocal.create(periode);
    }

    @Override
    public void create(Employe employe, Periode periode) {
        periode.setFonction(iFonctionEJBDaoLocal.findById(periode.getFonction().getId()));
        iEmployeEJBDaoLocal.create(employe);
        periode.setEmploye(employe);
        iPeriodeEJBDaoLocal.create(periode);
    }

    @Override
    public Employe update(Employe employe, Periode periode) {
        periode.setFonction(iFonctionEJBDaoLocal.findById(periode.getFonction().getId()));
        Employe updateEmploye = iEmployeEJBDaoLocal.update(employe);
        periode.setEmploye(updateEmploye);
        iPeriodeEJBDaoLocal.update(periode);
        
        return updateEmploye;
    }
    
}
