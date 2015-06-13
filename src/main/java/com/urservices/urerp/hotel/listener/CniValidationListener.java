/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.listener;

import com.urservices.urerp.hotel.entities.Occupant;
import com.urservices.urerp.hotel.metier.IOccupantEJBMetierLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public class CniValidationListener implements ActionListener {

    private IOccupantEJBMetierLocal iOccupantEJBMetierLocal;
    
    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        
        
        String cni = (String)application.evaluateExpressionGet(context, "#{occupantBean.occupant.cni}", String.class);
        String idOccupant = (String)application.evaluateExpressionGet(context, "#{occupantBean.occupant.id}", String.class);
        
        try {
            Context ctx = new InitialContext();
            iOccupantEJBMetierLocal = (IOccupantEJBMetierLocal)ctx.lookup("java:global/hotel/OccupantEJBMetier!com.urservices.urerp.hotel.metier.IOccupantEJBMetierLocal");
        } catch (NamingException ex) {
            Logger.getLogger(CniValidationListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Occupant occupant = iOccupantEJBMetierLocal.findByCni(cni);
        
        long occupantGetId = occupant.getId();
        long occupantId = Long.valueOf(idOccupant);
        
        if ((occupant != null) && (occupantGetId != occupantId)) {
            context.addMessage("occupant", new FacesMessage(FacesMessage.SEVERITY_ERROR, "#{msg['hotel.view.listener.cni']}", null));
            throw new AbortProcessingException();
        }
    }
    
}
