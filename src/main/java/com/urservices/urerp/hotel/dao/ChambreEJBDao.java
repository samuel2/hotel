/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.dao;

import com.urservices.urerp.hotel.entities.Chambre;
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
public class ChambreEJBDao implements IChambreEJBDaoLocal, IChambreEJBDaoRemote, Serializable{

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;
    
    @Override
    public Chambre create(Chambre chambre) {
        em.persist(chambre);
        return chambre;
    }

    @Override
    public Chambre update(Chambre chambre) {
        Chambre updateChambre;
        updateChambre = em.merge(chambre);
        return updateChambre;
    }

    @Override
    public int delete(Chambre chambre) {
        int nombreDeLignesAffectees = 0;
        Query query = em.createQuery("DELETE FROM Chambre c WHERE c.id = :id");
        query.setParameter("id", chambre.getId());
        nombreDeLignesAffectees = query.executeUpdate();
        return nombreDeLignesAffectees;
    }

    @Override
    public Chambre findById(Long id) {
        Query query = em.createNamedQuery("Chambre.findById");
        query.setParameter("id", id);
        return (Chambre)query.getSingleResult();
    }

    @Override
    public Chambre findByNumero(String numero) {
        Query query = em.createNamedQuery("Chambre.findByNumero");
        query.setParameter("numero", numero);
        
        int result = ((List<Chambre>)query.getResultList()).size();
        if (result == 1) {
            return (Chambre)query.getSingleResult();
        }else {
            return null;
        }
        
    }

    @Override
    public Chambre findByType(String type) {
        Query query = em.createNamedQuery("Chambre.findByType");
        query.setParameter("type", type);
        
        int result = ((List<Chambre>)query.getResultList()).size();
        if (result == 1) {
            return (Chambre)query.getSingleResult();
        }else {
            return null;
        }
    }

    @Override
    public Chambre findByPosition(String position) {
        Query query = em.createNamedQuery("Chambre.findByPosition");
        query.setParameter("position", position);
        
        int result = ((List<Chambre>)query.getResultList()).size();
        if (result == 1) {
            return (Chambre)query.getSingleResult();
        }else {
            return null;
        }
    }

    @Override
    public List<Chambre> findAll() {
        Query query = em.createNamedQuery("Chambre.findAll");
        return (List<Chambre>)query.getResultList();
    }
    
}
