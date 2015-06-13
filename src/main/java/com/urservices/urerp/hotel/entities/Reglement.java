/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Entity
@Access(AccessType.PROPERTY)
@NamedQueries({
    @NamedQuery(name = Reglement.FIND_BY_ID, query = "SELECT r FROM Reglement r WHERE r.id = :id"),
    @NamedQuery(name = Reglement.FIND_BY_NUMERO, query = "SELECT r FROM Reglement r WHERE r.numero = :numero"),
    @NamedQuery(name = Reglement.FIND_ALL, query = "SELECT r FROM Reglement r")
})
public class Reglement implements Serializable {
    
    public final static String FIND_ALL = "Reglement.findAll";
    public final static String FIND_BY_ID = "Reglement.findById";
    public final static String FIND_BY_NUMERO = "Reglement.findByNumero";
    
    private Long id;
    private String numero;
    private Float montant;
    private Date dateReglement;
    private List<Reservation> reservations;

    public Reglement() {
    }

    public Reglement(Long id, String numero, Float montant, Date dateReglement, List<Reservation> reservations) {
        this.id = id;
        this.numero = numero;
        this.montant = montant;
        this.dateReglement = dateReglement;
        this.reservations = reservations;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public Float getMontant() {
        return montant;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateReglement() {
        return dateReglement;
    }

    @OneToMany(mappedBy = "reglement")
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public void setDateReglement(Date dateReglement) {
        this.dateReglement = dateReglement;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    public void addReservations(Reservation reservation) {
        this.reservations.add(reservation);
    }
}
