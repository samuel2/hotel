/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.validator;

import com.urservices.urerp.hotel.entities.Occupant;
import com.urservices.urerp.hotel.metier.IOccupantEJBMetierLocal;
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
@FacesValidator(value = "cniOccupantValidator")
public class CniOccupantValidator implements Validator {

    @EJB
    private IOccupantEJBMetierLocal iOccupantEJBMetierLocal;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Occupant occupant = iOccupantEJBMetierLocal.findByCni(value.toString());
        
        if (occupant != null) {
            String message = MessageFormat.format("{0} existe déjà", value.toString());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(facesMessage);
        }
    }
    
}
