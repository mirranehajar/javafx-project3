package org.mirrane.service;

import org.mirrane.dao.ClientDao;
import org.mirrane.dao.ClientDaoImp;
import org.mirrane.entity.Client;

import java.util.List;

public class ClientService {

    ClientDao clientDao;

    public ClientService() {
        this.clientDao = new ClientDaoImp();
    }

    public void addClient(Client client) {
        clientDao.addClient(client);
    }


    public List<Client> getClients() {
        return clientDao.getClients();
    }

    public Client getClientById(int id) {

        Client client;

        if (clientDao.isPresent(id)) {
            client = clientDao.getClientById(id);
        } else {
            client = new Client(0, "not Found");
        }

        return client;
    }

    public void updateClient(Client client) {
        if (clientDao.isPresent(client.getId())) {
            clientDao.updateClient(client);
        } else {
            clientDao.addClient(client);
        }

    }

    public void deleteClient(int id) {
        Client client = getClientById(id);
        if (!client.getId().equals(0)){
            clientDao.deleteClient(client);
        }

    }
}
