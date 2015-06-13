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
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Entity
@Access(AccessType.PROPERTY)
@DiscriminatorValue("Occupant")
@NamedQueries({
    @NamedQuery(name = Occupant.FIND_ALL, query = "SELECT o FROM Occupant o"),
    @NamedQuery(name = Occupant.FIND_BY_CNI, query = "SELECT o FROM Occupant o WHERE o.cni = :cni"),
    @NamedQuery(name = Occupant.FIND_BY_ID, query = "SELECT o FROM Occupant o WHERE o.id = :id"),
    @NamedQuery(name = Occupant.FIND_BY_NATIONALITE, query = "SELECT o FROM Occupant o WHERE o.nationalite = :nationalite"),
    @NamedQuery(name = Occupant.FIND_BY_PROFESSION, query = "SELECT o FROM Occupant o WHERE o.profession = :profession"),
    @NamedQuery(name = Occupant.FIND_BY_SEXE, query = "SELECT o FROM Occupant o WHERE o.sexe = :sexe")
})
public class Occupant extends Partenaire implements Serializable{
    
    public final static String FIND_BY_ID = "Occupant.findById";
    public final static String FIND_BY_CNI = "Occupant.findByCni";
    public final static String FIND_BY_PROFESSION = "Occupant.findByProfsession";
    public final static String FIND_BY_SEXE = "Occupant.findBySexe";
    public final static String FIND_BY_NATIONALITE = "Occupant.findByNationalite";
    public final static String FIND_ALL = "Occupant.findAll";
    
    private String profession;

    public Occupant() {
    }

    public Occupant(String profession, Long id, String cni, String nom, String prenom, String sexe, Date dateNaissance, String lieuNaissance, String nationalite, Adresse adresse, List<Reservation> reservations) {
        super(id, cni, nom, prenom, sexe, dateNaissance, lieuNaissance, nationalite, adresse, reservations);
        this.profession = profession;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getCni() {
        return super.getCni();
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public String getPrenom() {
        return super.getPrenom();
    }

    @Override
    public String getSexe() {
        return super.getSexe();
    }

    @Override
    public Date getDateNaissance() {
        return super.getDateNaissance();
    }

    @Override
    public String getNationalite() {
        return super.getNationalite();
    }

    @Override
    public Adresse getAdresse() {
        return super.getAdresse();
    }

    @Override
    public String getLieuNaissance() {
        return super.getLieuNaissance();
    }

    @Override
    public List<Reservation> getReservations() {
        return super.getReservations();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public void setCni(String cni) {
        super.setCni(cni);
    }

    @Override
    public void setNom(String nom) {
        super.setNom(nom);
    }

    @Override
    public void setPrenom(String prenom) {
        super.setPrenom(prenom);
    }

    @Override
    public void setSexe(String sexe) {
        super.setSexe(sexe);
    }

    @Override
    public void setDateNaissance(Date dateNaissance) {
        super.setDateNaissance(dateNaissance);
    }

    @Override
    public void setLieuNaissance(String lieuNaissance) {
        super.setLieuNaissance(lieuNaissance);
    }

    @Override
    public void setNationalite(String nationalite) {
        super.setNationalite(nationalite);
    }

    @Override
    public void setAdresse(Adresse adresse) {
        super.setAdresse(adresse);
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public void setReservations(List<Reservation> reservations) {
        super.setReservations(reservations);
    }
}
