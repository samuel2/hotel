/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.metier;

import com.urservices.urerp.hotel.dao.IFonctionEJBDaoLocal;
import com.urservices.urerp.hotel.entities.Fonction;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Stateless
public class FonctionEJBMetier implements IFonctionEJBMetierLocal, IFonctionEJBMetierRemote, Serializable{

    @EJB
    private IFonctionEJBDaoLocal iFonctionEJBDaoLocal;
    
    @Override
    public Fonction create(Fonction fonction) {
        return iFonctionEJBDaoLocal.create(fonction);
    }

    @Override
    public Fonction update(Fonction fonction) {
        return iFonctionEJBDaoLocal.update(fonction);
    }

    @Override
    public int delete(Fonction fonction) {
        return iFonctionEJBDaoLocal.delete(fonction);
    }

    @Override
    public Fonction findById(Long id) {
        return iFonctionEJBDaoLocal.findById(id);
    }

    @Override
    public List<Fonction> findAll() {
        return iFonctionEJBDaoLocal.findAll();
    }

    @Override
    public Fonction findByLibelle(String libelle) {
        return iFonctionEJBDaoLocal.findByLibelle(libelle);
    }
    
}
