/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.metier;

import com.urservices.urerp.hotel.entities.Chambre;
import java.util.List;

/**
 *
 * @author samuel   < snlfolong@gmail.com >
 */
public interface IChambreEJBMetier {
    
    public Chambre create(Chambre chambre);
    
    public Chambre update(Chambre chambre);
    
    public int delete(Chambre chambre);
    
    public Chambre findById(Long id);
    
    public Chambre findByNumero(String numero);
    
    public Chambre findByType(String type);
    
    public Chambre findByPosition(String position);
    
    public List<Chambre> findAll();
}
