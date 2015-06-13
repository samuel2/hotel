/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.dao;

import com.urservices.urerp.hotel.entities.Employe;
import com.urservices.urerp.hotel.entities.Periode;
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
public class EmployeEJBDao implements IEmployeEJBDaoLocal, IEmployeEJBDaoRemote, Serializable{

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;
    
    @Override
    public Employe create(Employe employe) {
        em.persist(employe);
        return employe;
    }

    @Override
    public Employe update(Employe employe) {
        Employe updateEmploye;
        updateEmploye = em.merge(employe);
        return updateEmploye;
    }

    @Override
    public int delete(Employe employe) {
        int nombreDeLigneAffectees = 0;
        Query query = em.createQuery("DELETE FROM Employe e WHERE e.id = :id");
        query.setParameter("id", employe.getId());
        nombreDeLigneAffectees = query.executeUpdate();
        return nombreDeLigneAffectees;
    }

    @Override
    public Employe findById(Long id) {
        Query query = em.createNamedQuery("Employe.findById");
        query.setParameter("id", id);
        return (Employe)query.getSingleResult();
    }

    @Override
    public Employe findByCni(String cni) {
        Query query = em.createNamedQuery("Employe.findByCni");
        query.setParameter("cni", cni);
        
        int result = ((List<Employe>)query.getResultList()).size();
        if (result == 1) {
            return (Employe)query.getSingleResult();
        }else {
            return null;
        }
    }

    @Override
    public List<Employe> findAll() {
        Query query = em.createNamedQuery("Employe.findAll");
        return (List<Employe>)query.getResultList();
    }
}
