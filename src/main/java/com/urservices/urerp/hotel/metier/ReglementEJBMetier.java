/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.metier;

import com.urservices.urerp.hotel.dao.IReglementEJBDaoLocal;
import com.urservices.urerp.hotel.entities.Reglement;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel   < snlfolong@gmail.com >
 */
@Stateless
public class ReglementEJBMetier implements IReglementEJBMetierLocal, IReglementEJBMetierRemote, Serializable{

    @EJB
    private IReglementEJBDaoLocal iReglementEJBDaoLocal;
    
    @Override
    public Reglement create(Reglement reglement) {
        return iReglementEJBDaoLocal.create(reglement);
    }

    @Override
    public Reglement update(Reglement reglement) {
        return iReglementEJBDaoLocal.update(reglement);
    }

    @Override
    public int delete(Reglement reglement) {
        return iReglementEJBDaoLocal.delete(reglement);
    }

    @Override
    public Reglement findById(Long id) {
        return iReglementEJBDaoLocal.findById(id);
    }

    @Override
    public Reglement findByNumero(String numero) {
        return iReglementEJBDaoLocal.findByNumero(numero);
    }

    @Override
    public List<Reglement> findAll() {
        return iReglementEJBDaoLocal.findAll();
    }
    
}
