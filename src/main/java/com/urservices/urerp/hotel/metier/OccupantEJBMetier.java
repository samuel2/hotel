/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.metier;

import com.urservices.urerp.hotel.dao.IOccupantEJBDaoLocal;
import com.urservices.urerp.hotel.entities.Occupant;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Stateless
public class OccupantEJBMetier implements IOccupantEJBMetierLocal, IOccupantEJBMetierRemote, Serializable{

    @EJB
    private IOccupantEJBDaoLocal iOccupantEJBDaoLocal;

    @Override
    public Occupant create(Occupant occupant) {
        return iOccupantEJBDaoLocal.create(occupant);
    }

    @Override
    public Occupant update(Occupant occupant) {
        return iOccupantEJBDaoLocal.update(occupant);
    }

    @Override
    public int delete(Occupant occupant) {
        return iOccupantEJBDaoLocal.delete(occupant);
    }

    @Override
    public Occupant findById(Long id) {
        return iOccupantEJBDaoLocal.findById(id);
    }

    @Override
    public Occupant findByCni(String cni) {
        return iOccupantEJBDaoLocal.findByCni(cni);
    }

    @Override
    public List<Occupant> findByProfession(String profession) {
        return iOccupantEJBDaoLocal.findByProfession(profession);
    }

    @Override
    public List<Occupant> findByNationalite(String nationalite) {
        return iOccupantEJBDaoLocal.findByNationalite(nationalite);
    }

    @Override
    public List<Occupant> findBySexe(String sexe) {
        return iOccupantEJBDaoLocal.findBySexe(sexe);
    }

    @Override
    public List<Occupant> findAll() {
        return iOccupantEJBDaoLocal.findAll();
    }
    
    
}
