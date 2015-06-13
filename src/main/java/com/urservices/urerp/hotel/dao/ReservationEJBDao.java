/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.dao;

import com.urservices.urerp.hotel.entities.Reservation;
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
public class ReservationEJBDao implements IReservationEJBDaoLocal, IReservationEJBDaoRemote, Serializable{

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;
    
    @Override
    public Reservation create(Reservation reservation) {
        em.persist(reservation);
        return reservation;
    }

    @Override
    public Reservation update(Reservation reservation) {
        Reservation updateReservation;
        updateReservation = em.merge(reservation);
        return updateReservation;
    }

    @Override
    public int delete(Reservation reservation) {
        int nombreDeLigneAffectees = 0;
        Query query = em.createQuery("DELETE FROM Reservation r WHERE r.id = :id");
        query.setParameter("id", reservation.getId());
        nombreDeLigneAffectees = query.executeUpdate();
        return nombreDeLigneAffectees;
    }

    @Override
    public Reservation findById(Long id) {
        Query query = em.createNamedQuery("Reservation.findById");
        query.setParameter("id", id);
        return (Reservation)query.getSingleResult();
    }

    @Override
    public Reservation findByNumero(String numero) {
        Query query = em.createNamedQuery("Reservation.findByNumero");
        query.setParameter("numero", numero);
        
        int result = ((List<Reservation>)query.getResultList()).size();
        if (result == 1) {
            return (Reservation)query.getSingleResult();
        }else {
            return null;
        }
    }

    @Override
    public List<Reservation> findAll() {
        Query query = em.createNamedQuery("Reservation.findAll");
        return (List<Reservation>)query.getResultList();
    }
    
}
