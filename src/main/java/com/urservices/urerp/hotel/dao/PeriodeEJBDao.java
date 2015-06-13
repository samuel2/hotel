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
 * @author samuel
 */
@Stateless
public class PeriodeEJBDao implements IPeriodeEJBDaoLocal, IPeriodeEJBDaoRemote, Serializable{

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;
    
    @Override
    public Periode create(Periode periode) {
        em.persist(periode);
        return periode;
    }

    @Override
    public Periode update(Periode periode) {
        Periode updatePeriode;
        updatePeriode = em.merge(periode);
        return updatePeriode;
    }

    @Override
    public int delete(Periode periode) {
        int nombreDeLignesAffectees = 0;
        Query query = em.createQuery("DELETE FROM Periode p WHERE p.id = :id");
        query.setParameter("id", periode.getId());
        nombreDeLignesAffectees = query.executeUpdate();
        return nombreDeLignesAffectees;
    }

    @Override
    public Periode findById(Long id) {
        Query query = em.createNamedQuery("Periode.findById").setParameter("id", id);
        return (Periode)query.getSingleResult();
    }

    @Override
    public List<Periode> findAll() {
        Query query = em.createNamedQuery("Periode.findAll");
        return (List<Periode>)query.getResultList();
    }

    @Override
    public Periode findPeriodeActiveEmploye(Employe employe) {
        Query query = em.createQuery("SELECT p FROM Periode p WHERE p.employe = :employe AND p.dateFin=null");
        query.setParameter("employe", employe);
        return (Periode)query.getSingleResult();
    }

    @Override
    public List<Periode> findPeriodesEmploye(Employe employe) {
        Query query = em.createQuery("SELECT p FROM Periode p WHERE p.employe = :employe");
        query.setParameter("employe", employe);
        return (List<Periode>)query.getResultList();
    }

    @Override
    public void deletePeriodeEmploye(Long employeId) {
        Query query = em.createQuery("DELETE FROM Periode p WHERE p.employe.id = :employeId");
        query.setParameter("employeId", employeId);
        query.executeUpdate();
    }
    
}
