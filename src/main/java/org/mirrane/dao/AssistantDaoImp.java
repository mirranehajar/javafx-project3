package org.mirrane.dao;

import org.mirrane.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class AssistantDaoImp implements AssistantDao {

    EntityManager entityManager;

    public AssistantDaoImp() {
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
    public int addAssistant(Assistant assistant) {
        assistant.setId(null);
        entityManager.getTransaction().begin();
        entityManager.persist(assistant);
        entityManager.getTransaction().commit();
        return 0;
    }

    @Override
    public List<Assistant> getAssistants() {
        entityManager.getTransaction().begin();
        List<Assistant> assistants = entityManager.createQuery("FROM Assistant", Assistant.class).getResultList();
        entityManager.getTransaction().commit();
        return assistants;
    }

    @Override
    public Assistant getAssistant(Integer id) {
        entityManager.getTransaction().begin();
        Assistant assistant = entityManager.find(Assistant.class, id);
        entityManager.getTransaction().commit();

        return assistant ;
    }

    @Override
    public Assistant getAssistantByCin(String cin) {
        try {
            TypedQuery<Assistant> query = entityManager.createQuery("SELECT a FROM Assistant a WHERE p.cin = '" + cin + "'", Assistant.class);
            return query.getSingleResult();
        }catch (NoResultException e){
            return  null;
        }
    }

    @Override
    public Assistant getAssistantByMail(String mail) {
        try {
            TypedQuery<Assistant> query = entityManager.createQuery("SELECT a FROM Assistant a WHERE p.mail = '" + mail + "'", Assistant.class);
            return query.getSingleResult();
        }catch (NoResultException e){
            return  null;
        }
    }

    @Override
    public void updateAssistant(Assistant assistant) {

        entityManager.getTransaction().begin();
        entityManager.merge(assistant);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteAssistant(Assistant assistant) {

        entityManager.getTransaction().begin();
        entityManager.remove(assistant);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean isPresent(int id) {
        Assistant assistant = entityManager.find(Assistant.class, id);
        if (assistant == null) return false;
        else return true;
    }

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }
}
