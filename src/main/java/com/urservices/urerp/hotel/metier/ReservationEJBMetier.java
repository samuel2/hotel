/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.metier;

import com.urservices.urerp.hotel.dao.IChambreEJBDaoLocal;
import com.urservices.urerp.hotel.dao.IClientEJBDaoLocal;
import com.urservices.urerp.hotel.dao.IOccupantEJBDaoLocal;
import com.urservices.urerp.hotel.dao.IReglementEJBDaoLocal;
import com.urservices.urerp.hotel.dao.IReservationEJBDaoLocal;
import com.urservices.urerp.hotel.entities.Chambre;
import com.urservices.urerp.hotel.entities.Client;
import com.urservices.urerp.hotel.entities.Occupant;
import com.urservices.urerp.hotel.entities.Reglement;
import com.urservices.urerp.hotel.entities.Reservation;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Stateless
public class ReservationEJBMetier implements IReservationEJBMetierLocal, IReservationEJBMetierRemote, Serializable{

    @EJB
    private IReservationEJBDaoLocal iReservationEJBDaoLocal;
    
    @EJB
    private IClientEJBDaoLocal iClientEJBDaoLocal;
    
    @EJB
    private IReglementEJBDaoLocal iReglementEJBDaoLocal;
    
    @EJB
    private IChambreEJBDaoLocal iChambreEJBDaoLocal;
    
    @EJB
    private IOccupantEJBDaoLocal iOccupantEJBDaoLocal;
    
    @Override
    public Reservation create(Reservation reservation) {
        return iReservationEJBDaoLocal.create(reservation);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return iReservationEJBDaoLocal.update(reservation);
    }

    @Override
    public int delete(Reservation reservation) {
        return iReservationEJBDaoLocal.delete(reservation);
    }

    @Override
    public Reservation findById(Long id) {
        return iReservationEJBDaoLocal.findById(id);
    }

    @Override
    public Reservation findByNumero(String numero) {
        return iReservationEJBDaoLocal.findByNumero(numero);
    }

    @Override
    public List<Reservation> findAll() {
        return iReservationEJBDaoLocal.findAll();
    }

    @Override
    public Reservation create(Reservation reservation, Client client, List<Chambre> chambres, Reglement reglement, List<Occupant> occupants) {
        
        Client clientTmp = iClientEJBDaoLocal.findByCode(client.getCode());
        
        Reglement reglementTmp = iReglementEJBDaoLocal.findByNumero(reglement.getNumero());
        
        if (clientTmp == null) {
            clientTmp = iClientEJBDaoLocal.create(client);
        }
        
        if (reglementTmp == null) {
            reglementTmp = iReglementEJBDaoLocal.create(reglement);
        }
        
        reservation.setClient(clientTmp);
        reservation.setReglement(reglementTmp);
        
        for (Chambre chambre : chambres) {
            chambre.setId(null);
            iChambreEJBDaoLocal.create(chambre);
        }
        
        return reservation;
    }

    @Override
    public Reservation create(Reservation reservation, Occupant occupant, List<Chambre> chambres, Reglement reglement) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
