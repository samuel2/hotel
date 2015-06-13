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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Entity
@Access(AccessType.PROPERTY)
@DiscriminatorValue("Employe")
@NamedQueries({
    @NamedQuery(name = Employe.FIND_BY_ID, query = "SELECT e FROM Employe e WHERE e.id = :id"),
    @NamedQuery(name = Employe.FIND_BY_CNI, query = "SELECT e FROM Employe e WHERE e.cni = :cni"),
    @NamedQuery(name = Employe.FIND_ALL, query = "SELECT e FROM Employe e")
})
public class Employe extends Partenaire implements Serializable{

    public final static String FIND_BY_ID = "Employe.findById";
    public final static String FIND_ALL = "Employe.findAll";
    public final static String FIND_BY_CNI = "Employe.findByCni";
    
    private List<Periode> periodes;
    
    public Employe() {
    }

    public Employe(Long id, String cni, String nom, String prenom, String sexe, Date dateNaissance, String lieuNaissance, String nationalite, Adresse adresse, List<Reservation> reservations) {
        super(id, cni, nom, prenom, sexe, dateNaissance, lieuNaissance, nationalite, adresse, reservations);
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
    @Temporal(TemporalType.DATE)
    public Date getDateNaissance() {
        return super.getDateNaissance();
    }

    @Override
    public String getLieuNaissance() {
        return super.getLieuNaissance();
    }

    @Override
    public String getNationalite() {
        return super.getNationalite();
    }

    @Override
    public Adresse getAdresse() {
        return super.getAdresse();
    }

    @OneToMany(mappedBy = "employe")
    public List<Periode> getPeriodes() {
        return periodes;
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
    public void setDateNaissance(Date dateNaissance) {
        super.setDateNaissance(dateNaissance);
    }

    @Override
    public void setLieuNaissance(String lieuNaissance) {
        super.setLieuNaissance(lieuNaissance);
    }

    @Override
    public void setSexe(String sexe) {
        super.setSexe(sexe);
    }

    @Override
    public void setNationalite(String nationalite) {
        super.setNationalite(nationalite);
    }

    @Override
    public void setAdresse(Adresse adresse) {
        super.setAdresse(adresse);
    }

    public void setPeriodes(List<Periode> periodes) {
        this.periodes = periodes;
    }
    
    public void addPeriode(Periode periode) {
        this.periodes.add(periode);
    }
}
