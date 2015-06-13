/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.dao;

import com.urservices.urerp.hotel.entities.Reglement;
import java.util.List;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IReglementEJBDao {
    
    public Reglement create(Reglement reglement);
    
    public Reglement update(Reglement reglement);
    
    public int delete(Reglement reglement);
    
    public Reglement findById(Long id);
    
    public Reglement findByNumero(String numero);
    
    public List<Reglement> findAll();
}
