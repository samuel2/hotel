/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.entities;

import java.io.Serializable;
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

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Entity
@Access(AccessType.PROPERTY)
@NamedQueries({
    @NamedQuery(name = Chambre.FIND_BY_ID, query = "SELECT c FROM Chambre c WHERE c.id = :id"),
    @NamedQuery(name = Chambre.FIND_BY_NUMERO, query = "SELECT c FROM Chambre c WHERE c.numero = :numero"),
    @NamedQuery(name = Chambre.FIND_BY_TYPE, query = "SELECT c FROM Chambre c WHERE c.type = :type"),
    @NamedQuery(name = Chambre.FIND_BY_POSITION, query = "SELECT c FROM Chambre c WHERE c.position = :position"),
    @NamedQuery(name = Chambre.FIND_ALL, query = "SELECT c FROM Chambre c")
})
public class Chambre implements Serializable {
    
    public final static String FIND_BY_ID = "Chambre.findById";
    public final static String FIND_BY_NUMERO = "Chambre.findByNumero";
    public final static String FIND_BY_TYPE = "Chambre.findByType";
    public final static String FIND_BY_POSITION = "Chambre.findByPosition";
    public final static String FIND_ALL = "Chambre.findAll";
    
    private Long id;
    private String numero;
    private String type;
    private Float prix;
    private String position;
    private List<Reservation> reservations;

    public Chambre() {
    }

    public Chambre(Long id, String numero, String type, Float prix, String position, List<Reservation> reservations) {
        this.id = id;
        this.numero = numero;
        this.type = type;
        this.prix = prix;
        this.position = position;
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

    public String getType() {
        return type;
    }

    public Float getPrix() {
        return prix;
    }

    public String getPosition() {
        return position;
    }

    @OneToMany(mappedBy = "chambre")
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    public void addResrvations(Reservation reservation) {
        this.reservations.add(reservation);
    }
}
