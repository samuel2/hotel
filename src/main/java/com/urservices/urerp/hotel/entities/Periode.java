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
    @NamedQuery(name = Periode.FIND_BY_ID, query = "SELECT p FROM Periode p WHERE p.id = :id"),
    @NamedQuery(name = Periode.FIND_ALL, query = "SELECT p FROM Periode p")
})
public class Periode implements Serializable {
    
    public final static String FIND_BY_ID = "Periode.findById";
    public final static String FIND_ALL = "Periode.findAll";
    
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private Fonction fonction;
    private Employe employe;

    public Periode() {
        fonction = new Fonction();
        employe = new Employe();
    }

    public Periode(Long id, Date dateDebut, Date dateFin, Fonction fonction, Employe employe) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.fonction = fonction;
        this.employe = employe;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateDebut() {
        return dateDebut;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateFin() {
        return dateFin;
    }

    @ManyToOne
    public Fonction getFonction() {
        return fonction;
    }

    @ManyToOne
    public Employe getEmploye() {
        return employe;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
