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
public class PeriodeEJBMetier implements IPeriodeEJBMetierLocal, IPeriodeEJBMetierRemote, Serializable{

    @EJB
    private IPeriodeEJBDaoLocal iPeriodeEJBDaoLocal;
    
    @EJB
    private IEmployeEJBDaoLocal iEmployeEJBDaoLocal;
    
    @EJB
    private IFonctionEJBDaoLocal iFonctionEJBDaoLocal;
    
    @Override
    public Periode create(Periode periode) {
        return iPeriodeEJBDaoLocal.create(periode);
    }

    @Override
    public Periode update(Periode periode) {
        return iPeriodeEJBDaoLocal.update(periode);
    }

    @Override
    public int delete(Periode periode) {
        return iPeriodeEJBDaoLocal.delete(periode);
    }

    @Override
    public Periode findById(Long id) {
        return iPeriodeEJBDaoLocal.findById(id);
    }

    @Override
    public List<Periode> findAll() {
        return iPeriodeEJBDaoLocal.findAll();
    }

    @Override
    public Periode findPeriodeActiveEmploye(Employe employe) {
        return iPeriodeEJBDaoLocal.findPeriodeActiveEmploye(employe);
    }

    @Override
    public List<Periode> findPeriodesEmploye(Employe employe) {
        return iPeriodeEJBDaoLocal.findPeriodesEmploye(employe);
    }

    @Override
    public void update(Employe employe, Periode periode) {
        periode.setFonction(iFonctionEJBDaoLocal.findById(periode.getFonction().getId()));
        periode.setEmploye(employe);
        iEmployeEJBDaoLocal.update(employe);
    }

    @Override
    public void deletePeriodeEmploye(Long employeId) {
        iPeriodeEJBDaoLocal.deletePeriodeEmploye(employeId);
    }
}
