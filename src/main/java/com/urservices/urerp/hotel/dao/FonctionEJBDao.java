/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.dao;

import com.urservices.urerp.hotel.entities.Fonction;
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
public class FonctionEJBDao implements IFonctionEJBDaoLocal, IFonctionEJBDaoRemote, Serializable{

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;
    
    @Override
    public Fonction create(Fonction fonction) {
        em.persist(fonction);
        return fonction;
    }

    @Override
    public Fonction update(Fonction fonction) {
        Fonction updateFonction;
        updateFonction = em.merge(fonction);
        return updateFonction;
    }

    @Override
    public int delete(Fonction fonction) {
        int nombreDeLignesAffectees = 0;
        Query query = em.createQuery("DELETE FROM Fonction f WHERE f.id = :id");
        query.setParameter("id", fonction.getId());
        nombreDeLignesAffectees = query.executeUpdate();
        return nombreDeLignesAffectees;
    }

    @Override
    public Fonction findById(Long id) {
        Query query = em.createNamedQuery("Fonction.findById");
        query.setParameter("id", id);
        return (Fonction)query.getSingleResult();
    }

    @Override
    public List<Fonction> findAll() {
        Query query = em.createNamedQuery("Fonction.findAll");
        return (List<Fonction>)query.getResultList();
    }

    @Override
    public Fonction findByLibelle(String libelle) {
        Query query = em.createNamedQuery("Fonction.findByLibelle").setParameter("libelle", libelle);
        int nombreDeResultat = ((List<Fonction>)query.getResultList()).size();
        if (nombreDeResultat == 1) {
            return (Fonction)query.getSingleResult();
        }else{
            return null;
        }
    }
    
}
