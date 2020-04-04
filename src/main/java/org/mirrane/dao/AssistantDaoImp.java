package org.mirrane.dao;

import org.mirrane.entity.Assistant;
import org.mirrane.entity.Client;
import org.mirrane.entity.Doctor;

import javax.persistence.EntityManager;
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
    public void addAssistant(Assistant assistant) {
        assistant.setId(null);
        entityManager.getTransaction().begin();
        entityManager.persist(assistant);
        entityManager.getTransaction().commit();
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
