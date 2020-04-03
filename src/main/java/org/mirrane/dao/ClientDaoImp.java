package org.mirrane.dao;

import org.mirrane.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ClientDaoImp implements ClientDao {

    EntityManager entityManager;

    public ClientDaoImp() {
        this.entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
    }

    public void version() {

        entityManager.getTransaction().begin();
        String sql = "select version()";
        String result = (String) entityManager.createNativeQuery(sql).getSingleResult();
        System.out.println(result);
        entityManager.getTransaction().commit();
    }

    @Override
    public void addClient(Client client) {
        client.setId(null);
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Client> getClients() {
        entityManager.getTransaction().begin();
        List<Client> clients = entityManager.createQuery("FROM Client", Client.class).getResultList();
        entityManager.getTransaction().commit();
        return clients;
    }

    @Override
    public Client getClientById(int id) {

        entityManager.getTransaction().begin();
        Client client = entityManager.find(Client.class, id);
        entityManager.getTransaction().commit();

        return client;
    }

    @Override
    public void updateClient(Client client) {
        entityManager.getTransaction().begin();
        entityManager.merge(client);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteClient(Client client) {
        entityManager.getTransaction().begin();
        entityManager.remove(client);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean isPresent(int id) {
        Client client = entityManager.find(Client.class, id);
        if (client == null) return false;
        else return true;
    }

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }
}
