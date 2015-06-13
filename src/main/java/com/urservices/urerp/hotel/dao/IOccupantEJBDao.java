/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.dao;

import com.urservices.urerp.hotel.entities.Occupant;
import java.util.List;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IOccupantEJBDao {
    
    public Occupant create(Occupant occupant);
    
    public Occupant update(Occupant occupant);
    
    public int delete(Occupant occupant);
    
    public Occupant findById(Long id);
    
    public Occupant findByCni(String cni);
    
    public List<Occupant> findByProfession(String profession);
    
    public List<Occupant> findByNationalite(String nationalite);
    
    public List<Occupant> findBySexe(String sexe);
    
    public List<Occupant> findAll();
}
