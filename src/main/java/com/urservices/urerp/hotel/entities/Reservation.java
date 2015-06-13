/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Entity
@Access(AccessType.PROPERTY)
@NamedQueries({
    @NamedQuery(name = Reservation.FIND_BY_ID, query = "SELECT r FROM Reservation r WHERE r.id = :id"),
    @NamedQuery(name = Reservation.FIND_BY_NUMERO, query = "SELECT r FROM Reservation r WHERE r.numero = :numero"),
    @NamedQuery(name = Reservation.FIND_ALL, query = "SELECT r FROM Reservation r")
})
public class Reservation implements Serializable {
    
    public final static String FIND_BY_ID = "Reservation.findById";
    public final static String FIND_BY_NUMERO = "Reservation.findByNumero";
    public final static String FIND_ALL = "Reservation.findAll";
    
    private Long id;
    private String numero;
    private Date dateReservation;
    private Date dateConfirmation;
    private Date dateOccupation;
    private Date dateDepart;
    private int nombreDePersonne;
    private ModePaiement modePaiement;
    private Partenaire partenaire;
    private Client client;
    private Reglement reglement;
    private Chambre chambre;

    public Reservation() {
        client = new Client();
        reglement = new Reglement();
        chambre = new Chambre();
    }

    public Reservation(Long id, String numero, Date dateReservation, Date dateConfirmation,
            Date dateOccupation, Date dateDepart, int nombreDePersonne, 
            ModePaiement modePaiement, Partenaire partenaire, Client client, 
            Reglement reglement, Chambre chambre) {
        this.id = id;
        this.numero = numero;
        this.dateReservation = dateReservation;
        this.dateConfirmation = dateConfirmation;
        this.dateOccupation = dateOccupation;
        this.dateDepart = dateDepart;
        this.nombreDePersonne = nombreDePersonne;
        this.modePaiement = modePaiement;
        this.partenaire = partenaire;
        this.client = client;
        this.reglement = reglement;
        this.chambre = chambre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateReservation() {
        return dateReservation;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateConfirmation() {
        return dateConfirmation;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateOccupation() {
        return dateOccupation;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateDepart() {
        return dateDepart;
    }

    public String getNumero() {
        return numero;
    }

    public int getNombreDePersonne() {
        return nombreDePersonne;
    }

    @Enumerated(EnumType.STRING)
    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    @ManyToOne
    public Partenaire getPartenaire() {
        return partenaire;
    }

    @ManyToOne
    public Client getClient() {
        return client;
    }

    @ManyToOne
    public Reglement getReglement() {
        return reglement;
    }

    @ManyToOne
    public Chambre getChambre() {
        return chambre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public void setDateConfirmation(Date dateConfirmation) {
        this.dateConfirmation = dateConfirmation;
    }

    public void setDateOccupation(Date dateOccupation) {
        this.dateOccupation = dateOccupation;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setNombreDePersonne(int nombreDePersonne) {
        this.nombreDePersonne = nombreDePersonne;
    }

    public void setModePaiement(ModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setReglement(Reglement reglement) {
        this.reglement = reglement;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }
}
