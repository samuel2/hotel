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
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Entity
@Access(AccessType.PROPERTY)
@DiscriminatorColumn(name = "disc", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Partenaire")
public abstract class Partenaire implements Serializable {
    
    protected Long id;
    protected String cni;
    protected String nom;
    protected String prenom;
    protected String sexe;
    protected Date dateNaissance;
    protected String lieuNaissance;
    protected String nationalite;
    protected Adresse adresse;
    protected List<Reservation> reservations;

    public Partenaire() {
        this.adresse = new Adresse();
    }

    public Partenaire(Long id, String cni, String nom, String prenom, String sexe, Date dateNaissance, String lieuNaissance, String nationalite, Adresse adresse, List<Reservation> reservations) {
        this.id = id;
        this.cni = cni;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.nationalite = nationalite;
        this.adresse = adresse;
        this.reservations = reservations;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @NotNull(message = "La Cni est obligatoire")
    public String getCni() {
        return cni;
    }

    @NotNull(message = "Le nom est obligatoire")
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @NotNull(message = "Le sexe est obligatoire")
    public String getSexe() {
        return sexe;
    }

    @Temporal(TemporalType.DATE)
    @NotNull(message = "La date de naissance est obligatoire")
    public Date getDateNaissance() {
        return dateNaissance;
    }

    @NotNull(message = "Le lieu de naissance est obligatoire")
    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    @Embedded
    public Adresse getAdresse() {
        return adresse;
    }

    @OneToMany(mappedBy = "partenaire")
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
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
    
    @Override
    public String toString() {
        return "ID : " + id;
    }
}
