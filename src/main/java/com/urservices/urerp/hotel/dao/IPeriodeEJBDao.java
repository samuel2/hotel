/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.dao;

import com.urservices.urerp.hotel.entities.Employe;
import com.urservices.urerp.hotel.entities.Periode;
import java.util.List;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IPeriodeEJBDao {
    
    public Periode create(Periode periode);
    
    public Periode update(Periode periode);
    
    public int delete(Periode periode);
    
    public void deletePeriodeEmploye(Long employeId);
    
    public Periode findById(Long id);
    
    public List<Periode> findAll();
    
    public Periode findPeriodeActiveEmploye(Employe employe);
    
    public List<Periode> findPeriodesEmploye(Employe employe);
}
