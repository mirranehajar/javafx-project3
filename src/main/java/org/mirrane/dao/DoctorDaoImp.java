package org.mirrane.dao;

import org.mirrane.entity.Assistant;
import org.mirrane.entity.Doctor;
import org.mirrane.entity.Patient;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class DoctorDaoImp implements DoctorDao {

    EntityManager entityManager;

    public DoctorDaoImp() {
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
    public int addDoctor(Doctor doctor) {
        doctor.setId(null);
        entityManager.getTransaction().begin();
        entityManager.persist(doctor);
        entityManager.getTransaction().commit();
        return 0;

    }

    @Override
    public List<Doctor> getDoctors() {
        entityManager.getTransaction().begin();
        List<Doctor> doctors = entityManager.createQuery("FROM Doctor", Doctor.class).getResultList();
        entityManager.getTransaction().commit();
        return doctors;
    }

    @Override
    public Doctor getDoctor(Integer id) {
        entityManager.getTransaction().begin();
        Doctor doctor = entityManager.find(Doctor.class, id);
        entityManager.getTransaction().commit();

        return doctor;
    }

    @Override
    public Doctor getDoctorByCin(String cin) {
        try {
            TypedQuery<Doctor> query = entityManager.createQuery("SELECT d FROM Doctor d WHERE d.cin = '" + cin + "'", Doctor.class);
            return query.getSingleResult();
        }catch (NoResultException e){
            return  null;
        }
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        entityManager.getTransaction().begin();
        entityManager.merge(doctor);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteDoctor(Doctor doctor) {
        entityManager.getTransaction().begin();
        entityManager.remove(doctor);
        entityManager.getTransaction().commit();

    }

    @Override
    public boolean isPresent(int id) {
        Doctor doctor = entityManager.find(Doctor.class, id);
        if (doctor == null) return false;
        else return true;
    }

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }
}
