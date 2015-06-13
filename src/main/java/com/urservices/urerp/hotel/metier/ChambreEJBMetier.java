/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.metier;

import com.urservices.urerp.hotel.dao.IChambreEJBDaoLocal;
import com.urservices.urerp.hotel.entities.Chambre;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Stateless
public class ChambreEJBMetier implements IChambreEJBMetierLocal, IChambreEJBMetierRemote, Serializable{

    @EJB
    private IChambreEJBDaoLocal iChambreEJBDaoLocal;
    
    @Override
    public Chambre create(Chambre chambre) {
        Chambre createChambre;
        createChambre = iChambreEJBDaoLocal.create(chambre);
        System.out.println("Chambre cree ID = " + createChambre.getId());
        return createChambre;
    }

    @Override
    public Chambre update(Chambre chambre) {
        return iChambreEJBDaoLocal.update(chambre);
    }

    @Override
    public int delete(Chambre chambre) {
        return iChambreEJBDaoLocal.delete(chambre);
    }

    @Override
    public Chambre findById(Long id) {
        return iChambreEJBDaoLocal.findById(id);
    }

    @Override
    public Chambre findByNumero(String numero) {
        return iChambreEJBDaoLocal.findByNumero(numero);
    }

    @Override
    public Chambre findByType(String type) {
        return iChambreEJBDaoLocal.findByType(type);
    }

    @Override
    public Chambre findByPosition(String position) {
        return iChambreEJBDaoLocal.findByPosition(position);
    }

    @Override
    public List<Chambre> findAll() {
        return iChambreEJBDaoLocal.findAll();
    }
    
}
