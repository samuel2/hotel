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
import javax.persistence.Embedded;
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
    @NamedQuery(name = Client.FIND_BY_ID, query = "SELECT c FROM Client c WHERE c.id = :id"),
    @NamedQuery(name = Client.FIND_BY_CODE, query = "SELECT c FROM Client c WHERE c.code = :code"),
    @NamedQuery(name = Client.FIND_BY_NOM, query = "SELECT c FROM Client c WHERE c.nom = :nom"),
    @NamedQuery(name = Client.FIND_ALL, query = "SELECT c FROM Client c")
})
public class Client implements Serializable {
    
    public final static String FIND_BY_ID = "Client.findById";
    public final static String FIND_BY_CODE = "Client.findByCode";
    public final static String FIND_BY_NOM = "Client.findByNom";
    public final static String FIND_ALL = "Client.findAll";
    
    private Long id;
    private String code;
    private String nom;
    private Adresse adresse;
    private List<Reservation> reservations;

    public Client() {
        adresse = new Adresse();
    }

    public Client(Long id, String code, String nom, Adresse adresse, List<Reservation> reservations) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.adresse = adresse;
        this.reservations = reservations;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    @Embedded
    public Adresse getAdresse() {
        return adresse;
    }

    @OneToMany(mappedBy = "client")
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    public void addReservations(Reservation reservation) {
        this.reservations.add(reservation);
    }
}
