/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.metier;

import com.urservices.urerp.hotel.entities.Employe;
import com.urservices.urerp.hotel.entities.Periode;
import java.util.List;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IEmployeEJBMetier {
    
    public Employe create(Employe employe);
    
    public Employe update(Employe employe);
    
    public int delete(Employe employe);
    
    public Employe findById(Long id);
    
    public Employe findByCni(String cni);
    
    public List<Employe> findAll();
    
    public void change(Employe employe, Periode periode);
    
    public void create(Employe employe, Periode periode);
    
    public Employe update(Employe employe, Periode periode);
}
