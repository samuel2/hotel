/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.listener;

import com.urservices.urerp.hotel.entities.Employe;
import com.urservices.urerp.hotel.metier.IEmployeEJBMetierLocal;
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
public class CniEmployeValidationListener implements ActionListener {

    private IEmployeEJBMetierLocal iEmployeEJBMetierLocal;
    
    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        
        String cni = (String)application.evaluateExpressionGet(context, "#{employeBean.employe.cni}", String.class);
        String idEmploye = (String)application.evaluateExpressionGet(context, "#{employeBean.employe.id}", String.class);
        
        try {
            Context ctx = new InitialContext();
            iEmployeEJBMetierLocal = (IEmployeEJBMetierLocal)ctx.lookup("java:global/hotel/EmployeEJBMetier!com.urservices.urerp.hotel.metier.IEmployeEJBMetierLocal");
        } catch (NamingException ex) {
            Logger.getLogger(CniEmployeValidationListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Employe employe = iEmployeEJBMetierLocal.findByCni(cni);
        
        long employeGetId = employe.getId();
        long employeId = Long.valueOf(idEmploye);
        
        if ((employe != null) && (employeGetId != employeId)) {
            context.addMessage("employe", new FacesMessage(FacesMessage.SEVERITY_ERROR, "#{msg['hotel.view.listener.cni']}", null));
            throw new AbortProcessingException();
        }
    }
    
}
