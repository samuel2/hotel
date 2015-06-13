/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.dao;

import com.urservices.urerp.hotel.entities.Reglement;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Stateless
public class ReglementEJBDao implements IReglementEJBDaoLocal, IReglementEJBDaoRemote, Serializable{

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;
    
    @Override
    public Reglement create(Reglement reglement) {
        em.persist(reglement);
        return reglement;
    }

    @Override
    public Reglement update(Reglement reglement) {
        Reglement updateReglement;
        updateReglement = em.merge(reglement);
        return updateReglement;
    }

    @Override
    public int delete(Reglement reglement) {
        int nombreDeLigneAffectees = 0;
        Query query = em.createQuery("DELETE FROM Reglement r WHERE r.id = :id");
        query.setParameter("id", reglement.getId());
        nombreDeLigneAffectees = query.executeUpdate();
        return nombreDeLigneAffectees;
    }

    @Override
    public Reglement findById(Long id) {
        Query query = em.createNamedQuery("Reglement.findById");
        query.setParameter("id", id);
        return (Reglement)query.getSingleResult();
    }

    @Override
    public Reglement findByNumero(String numero) {
        Query query = em.createNamedQuery("Reglement.findByNumero");
        query.setParameter("numero", numero);
        int result = ((List<Reglement>)query.getResultList()).size();
        if (result == 1) {
            return (Reglement)query.getSingleResult();
        }else {
            return null;
        }
    }

    @Override
    public List<Reglement> findAll() {
        Query query = em.createNamedQuery("Reglement.findAll");
        return (List<Reglement>)query.getResultList();
    }
    
}
