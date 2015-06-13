/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.dao;

import com.urservices.urerp.hotel.entities.Client;
import java.util.List;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IClientEJBDao {
    
    public Client create(Client client);
    
    public Client update(Client client);
    
    public int delete(Client client);
    
    public Client findById(Long id);
    
    public Client findByCode(String code);
    
    public Client findByNom(String nom);
    
    public List<Client> findAll();
}
