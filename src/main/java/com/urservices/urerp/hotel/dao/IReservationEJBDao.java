/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.dao;

import com.urservices.urerp.hotel.entities.Reservation;
import java.util.List;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IReservationEJBDao {
    
    public Reservation create(Reservation reservation);
    
    public Reservation update(Reservation reservation);
    
    public int delete(Reservation reservation);
    
    public Reservation findById(Long id);
    
    public Reservation findByNumero(String numero);
    
    public List<Reservation> findAll();
}
