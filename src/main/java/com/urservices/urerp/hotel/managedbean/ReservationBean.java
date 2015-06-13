/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.managedbean;

import com.urservices.urerp.hotel.entities.Chambre;
import com.urservices.urerp.hotel.entities.Client;
import com.urservices.urerp.hotel.entities.Employe;
import com.urservices.urerp.hotel.entities.Occupant;
import com.urservices.urerp.hotel.entities.Reglement;
import com.urservices.urerp.hotel.entities.Reservation;
import com.urservices.urerp.hotel.metier.IChambreEJBMetierLocal;
import com.urservices.urerp.hotel.metier.IClientEJBMetierLocal;
import com.urservices.urerp.hotel.metier.IEmployeEJBMetierLocal;
import com.urservices.urerp.hotel.metier.IOccupantEJBMetierLocal;
import com.urservices.urerp.hotel.metier.IReglementEJBMetierLocal;
import com.urservices.urerp.hotel.metier.IReservationEJBMetierLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Named(value = "reservationBean")
@ViewScoped
public class ReservationBean implements Serializable {
    
    private Long reservationId;
    private Reservation reservation;
    private Chambre chambre;
    private Client client;
    private Reglement reglement;
    private Occupant occupant;
    private Employe employe;
    private List<Reservation> reservations;
    private List<Chambre> chambres;
    private List<Occupant> occupants;
    private List<Reglement> reglements;
    
    private FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private IReservationEJBMetierLocal iReservationEJBMetierLocal;
    
    @EJB
    private IChambreEJBMetierLocal iChambreEJBMetierLocal;
    
    @EJB
    private IClientEJBMetierLocal iClientEJBMetierLocal;
    
    @EJB
    private IReglementEJBMetierLocal iReglementEJBMetierLocal;
    
    @EJB
    private IOccupantEJBMetierLocal iOccupantEJBMetierLocal;
    
    @EJB
    private IEmployeEJBMetierLocal iEmployeEJBMetierLocal;

    public ReservationBean() {
        reservation = new Reservation();
        reservations = new ArrayList<Reservation>();
        client = new Client();
        chambre = new Chambre();
        chambres = new ArrayList<Chambre>();
        reglement = new Reglement();
        occupant = new Occupant();
        occupants = new ArrayList<Occupant>();
        employe = new Employe();
    }

    public Long getReservationId() {
        return reservationId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public Client getClient() {
        return client;
    }

    public Employe getEmploye() {
        return employe;
    }

    public Occupant getOccupant() {
        return occupant;
    }

    public Reglement getReglement() {
        return reglement;
    }

    public List<Reservation> getReservations() {
        reservations = iReservationEJBMetierLocal.findAll();
        return reservations;
    }

    public List<Chambre> getChambres() {
        chambres = iChambreEJBMetierLocal.findAll();
        return chambres;
    }

    public List<Occupant> getOccupants() {
        occupants = iOccupantEJBMetierLocal.findAll();
        return occupants;
    }

    public List<Reglement> getReglements() {
        return reglements;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
        this.reservation = iReservationEJBMetierLocal.findById(reservationId);
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public void setOccupant(Occupant occupant) {
        this.occupant = occupant;
    }

    public void setReglement(Reglement reglement) {
        this.reglement = reglement;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }

    public void setOccupants(List<Occupant> occupants) {
        this.occupants = occupants;
    }

    public void setReglements(List<Reglement> reglements) {
        this.reglements = reglements;
    }
    
    /**
     * Methode de recherche du client via son code lors de la creation d'une reservation
     * @param actionEvent 
     */
    public void searchClient(ActionEvent actionEvent) {
        this.client = iClientEJBMetierLocal.findByCode(this.client.getCode());
    }
    
    public void addOccupant(ActionEvent actionEvent) {
        occupant = new Occupant();
        occupants.add(occupant);
    }
    
    public String doCreate() throws IOException {
        context.getExternalContext().redirect("show.xhtml?q=" + reservation.getId());
        return "show";
    }
}
