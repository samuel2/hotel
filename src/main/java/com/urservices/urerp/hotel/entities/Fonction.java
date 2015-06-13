/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.entities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Entity
@Access(AccessType.PROPERTY)
@NamedQueries({
    @NamedQuery(name = Fonction.FIND_ALL, query = "SELECT f FROM Fonction f"),
    @NamedQuery(name = Fonction.FIND_BY_ID, query = "SELECT f FROM Fonction f WHERE f.id = :id"),
    @NamedQuery(name = Fonction.FIND_BY_LIBELLE, query = "SELECT f FROM Fonction f WHERE f.libelle = :libelle")
})
public class Fonction implements Serializable{
    
    public final static String FIND_ALL = "Fonction.findAll";
    public final static String FIND_BY_ID = "Fonction.findById";
    public final static String FIND_BY_LIBELLE = "Fonction.findByLibelle";
    
    private Long id;
    private String libelle;

    public Fonction() {
    }

    public Fonction(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    
    @NotNull
    public String getLibelle() {
        return libelle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return this.libelle;
    }
}
