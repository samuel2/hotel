/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.dao;

import com.urservices.urerp.hotel.entities.Occupant;
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
public class OccupantEJBDao implements IOccupantEJBDaoLocal, IOccupantEJBDaoRemote, Serializable{

    @PersistenceContext(name = "hotelPU")
    private EntityManager em;
    
    @Override
    public Occupant create(Occupant occupant) {
        em.persist(occupant);
        return occupant;
    }

    @Override
    public Occupant update(Occupant occupant) {
        Occupant updateOccupant;
        updateOccupant = em.merge(occupant);
        return updateOccupant;
    }

    @Override
    public int delete(Occupant occupant) {
        int nombreDeLignesAffectees = 0;
        Query query = em.createQuery("DELETE FROM Occupant o WHERE o.id = :id");
        query.setParameter("id", occupant.getId());
        nombreDeLignesAffectees = query.executeUpdate();
        return nombreDeLignesAffectees;
    }

    @Override
    public Occupant findById(Long id) {
        Query query = em.createNamedQuery("Occupant.findById").setParameter("id", id);
        return (Occupant)query.getSingleResult();
    }

    @Override
    public Occupant findByCni(String cni) {
        Query query = em.createNamedQuery("Occupant.findByCni");
        query.setParameter("cni", cni);
        
        int result = ((List<Occupant>)query.getResultList()).size();
        if (result == 1) {
            return (Occupant)query.getSingleResult();
        }else {
            return null;
        }
        
    }

    @Override
    public List<Occupant> findByProfession(String profession) {
        Query query = em.createNamedQuery("Occupant.findByProfsession");
        query.setParameter("profession", profession);
        return (List<Occupant>)query.getResultList();
    }

    @Override
    public List<Occupant> findByNationalite(String nationalite) {
        Query query = em.createNamedQuery("Occupant.findByNationalite");
        query.setParameter("nationalite", nationalite);
        return (List<Occupant>)query.getResultList();
    }

    @Override
    public List<Occupant> findBySexe(String sexe) {
        Query query = em.createNamedQuery("Occupant.findBySexe");
        query.setParameter("sexe", sexe);
        return (List<Occupant>)query.getResultList();
    }

    @Override
    public List<Occupant> findAll() {
        Query query = em.createNamedQuery("Occupant.findAll");
        return (List<Occupant>)query.getResultList();
    }
    
}
