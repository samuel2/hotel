/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.converter;

import com.urservices.urerp.hotel.entities.Fonction;
import com.urservices.urerp.hotel.metier.IFonctionEJBMetierLocal;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@FacesConverter(value = "fonctionConverter")
public class FonctionConverter implements Converter {

    @EJB
    private IFonctionEJBMetierLocal iFonctionEJBMetierLocal;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Fonction fonction = iFonctionEJBMetierLocal.findById(Long.valueOf(value));
        return fonction;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Fonction fonction = (Fonction)value;
        return String.valueOf(fonction.getId());
    }
    
}
