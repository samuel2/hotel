/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.metier;

import com.urservices.urerp.hotel.entities.Chambre;
import com.urservices.urerp.hotel.entities.Client;
import com.urservices.urerp.hotel.entities.Occupant;
import com.urservices.urerp.hotel.entities.Reglement;
import com.urservices.urerp.hotel.entities.Reservation;
import java.util.List;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IReservationEJBMetier {
    
    public Reservation create(Reservation reservation);
    
    public Reservation create(Reservation reservation, Client client, List<Chambre> chambres, Reglement reglement, List<Occupant> occupants);
    
    public Reservation create(Reservation reservation, Occupant occupant, List<Chambre> chambres, Reglement reglement);
    
    public Reservation update(Reservation reservation);
    
    public int delete(Reservation reservation);
    
    public Reservation findById(Long id);
    
    public Reservation findByNumero(String numero);
    
    public List<Reservation> findAll();
}
