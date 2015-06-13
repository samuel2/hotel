/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.managedbean;

import com.urservices.urerp.hotel.entities.Client;
import com.urservices.urerp.hotel.metier.IClientEJBMetierLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Named(value = "clientBean")
@RequestScoped
public class ClientBean implements Serializable {
    
    private Long clientId;
    private Client client;
    private List<Client> clients;
    
    private FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private IClientEJBMetierLocal iClientEJBMetierLocal;

    public ClientBean() {
        client = new Client();
        clients = new ArrayList<Client>();
    }

    public Long getClientId() {
        return clientId;
    }

    public Client getClient() {
        return client;
    }

    public List<Client> getClients() {
        clients = iClientEJBMetierLocal.findAll();
        return clients;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
        this.client = iClientEJBMetierLocal.findById(clientId);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    
    public String doCreate() throws IOException {
        iClientEJBMetierLocal.create(client);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + client.getId());
        return "show";
    }
    
    public String doDelete() throws IOException {
        iClientEJBMetierLocal.delete(client);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression éffectuée avec succès", "Suppression éffectuée avec succès"));
        context.getExternalContext().redirect("list.xhtml");
        return "list";
    }
    
    public String doNew() {
        return "/views/client/new?faces-redirect=true";
    }
    
    public String doList() {
        return "/views/client/list?faces-redirect+true";
    }
    
    public String doUpdate() throws IOException {
        iClientEJBMetierLocal.update(client);
        context.getExternalContext().redirect("show.xhtml?q=" + client.getId());
        return "show";
    }
    
    public String doEdit() {
        return "edit";
    }
    
    public String doShow() {
        return "show";
    }
    
    public void doFind() {
        client = iClientEJBMetierLocal.findById(clientId);
    }
}
