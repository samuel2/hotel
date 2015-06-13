/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.hotel.managedbean;

import com.urservices.urerp.hotel.entities.Client;
import com.urservices.urerp.hotel.metier.IClientEJBMetierLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@ManagedBean(name = "clientListBean")
@ViewScoped
public class ClientListBean implements Serializable {
    
    private Client client;
    private List<Client> clients;
    private boolean buttonDisabled = true;
    
    @EJB
    private IClientEJBMetierLocal iClientEJBMetierLocal;

    public ClientListBean() {
        client = new Client();
        buttonDisabled = true;
    }

    public Client getClient() {
        return client;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClient(Client client) {
        this.client = client;
        buttonDisabled = false;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public List<Client> getAllClients() {
        return iClientEJBMetierLocal.findAll();
    }
    
    public String getEditUrl() {
        return "/views/client/edit";
    }
    
    public String getShowUrl() {
        return "/views/client/show";
    }
    
    public String getDeleteUrl() {
        return "/views/client/delete";
    }
}
