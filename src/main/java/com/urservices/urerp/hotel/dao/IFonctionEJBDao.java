/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.dao;

import com.urservices.urerp.hotel.entities.Fonction;
import java.util.List;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IFonctionEJBDao {
    
    public Fonction create(Fonction fonction);
    
    public Fonction update(Fonction fonction);
    
    public int delete(Fonction fonction);
    
    public Fonction findById(Long id);
    
    public List<Fonction> findAll();
    
    public Fonction findByLibelle(String libelle);
}
