/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.validator;

import com.urservices.urerp.hotel.entities.Fonction;
import com.urservices.urerp.hotel.metier.IFonctionEJBMetierLocal;
import java.text.MessageFormat;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@FacesValidator(value = "fonctionValidator")
public class FonctionValidator implements Validator {

    @EJB
    private IFonctionEJBMetierLocal iFonctionEJBMetierLocal;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Fonction fonction = iFonctionEJBMetierLocal.findByLibelle(value.toString());
        
        if (fonction != null) {
            String message = MessageFormat.format("{0} existe déjà", value.toString());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(facesMessage);
        }
    }
    
}
