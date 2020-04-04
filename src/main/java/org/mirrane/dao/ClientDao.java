package org.mirrane.dao;

import org.mirrane.entity.Client;

import java.util.List;

public interface ClientDao {
    void addClient(Client client);
    List<Client> getClients();
    Client getClientById(Integer id);
    void updateClient(Client client);
    void deleteClient(Client client);
    boolean isPresent(Integer id);
}
