/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.metier;

import com.urservices.urerp.hotel.dao.IClientEJBDaoLocal;
import com.urservices.urerp.hotel.entities.Client;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Stateless
public class ClientEJBMetier implements IClientEJBMetierLocal, IClientEJBMetierRemote, Serializable{

    @EJB
    private IClientEJBDaoLocal iClientEJBDaoLocal;
    
    @Override
    public Client create(Client client) {
        return iClientEJBDaoLocal.create(client);
    }

    @Override
    public Client update(Client client) {
        return iClientEJBDaoLocal.update(client);
    }

    @Override
    public int delete(Client client) {
        return iClientEJBDaoLocal.delete(client);
    }

    @Override
    public Client findById(Long id) {
        return iClientEJBDaoLocal.findById(id);
    }

    @Override
    public Client findByCode(String code) {
        return iClientEJBDaoLocal.findByCode(code);
    }

    @Override
    public Client findByNom(String nom) {
        return iClientEJBDaoLocal.findByNom(nom);
    }

    @Override
    public List<Client> findAll() {
        return iClientEJBDaoLocal.findAll();
    }
    
}
