/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.dao;

import com.urservices.urerp.hotel.entities.Client;
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
public class ClientEJBDao implements IClientEJBDaoLocal, IClientEJBDaoRemote, Serializable{

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;
    
    @Override
    public Client create(Client client) {
        em.persist(client);
        return client;
    }

    @Override
    public Client update(Client client) {
        Client updateClient;
        updateClient = em.merge(client);
        return updateClient;
    }

    @Override
    public int delete(Client client) {
        int nombresDeLignesAffectees = 0;
        Query query = em.createQuery("DELETE FROM Client c WHERE c.id = :id");
        query.setParameter("id", client.getId());
        nombresDeLignesAffectees = query.executeUpdate();
        return nombresDeLignesAffectees;
    }

    @Override
    public Client findById(Long id) {
        Query query = em.createNamedQuery("Client.findById");
        query.setParameter("id", id);
        return (Client)query.getSingleResult();
    }

    @Override
    public Client findByCode(String code) {
        Query query = em.createNamedQuery("Client.findByCode");
        query.setParameter("code", code);
        
        int result = ((List<Client>)query.getResultList()).size();
        if (result == 1) {
            return (Client)query.getSingleResult();
        }else {
            return null;
        }
        
    }

    @Override
    public Client findByNom(String nom) {
        Query query = em.createNamedQuery("Client.findByNom");
        query.setParameter("nom", nom);
        
        int result = ((List<Client>)query.getResultList()).size();
        if (result == 1) {
            return (Client)query.getSingleResult();
        }else {
            return null;
        }
    }

    @Override
    public List<Client> findAll() {
        Query query = em.createNamedQuery("Client.findAll");
        return (List<Client>)query.getResultList();
    }
    
}
