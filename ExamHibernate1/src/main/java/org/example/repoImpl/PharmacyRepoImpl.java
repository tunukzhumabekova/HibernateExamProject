package org.example.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.App;
import org.example.entity.Pharmacy;
import org.example.entity.Worker;
import org.example.repository.PharmacyRepo;



public class PharmacyRepoImpl implements PharmacyRepo {
    private final EntityManagerFactory entityManagerFactory = App.getSession();
    @Override
    public void save(Pharmacy pharmacy) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(pharmacy);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Pharmacy finById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Pharmacy pharmacy = entityManager.find(Pharmacy.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return pharmacy;

    }

    @Override
    public String updatePharmacy(Long id, Pharmacy pharmacy) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Pharmacy pharmacy1 = entityManager.find(Pharmacy.class,id);
        pharmacy1.setName(pharmacy.getName());
        pharmacy1.setAddress(pharmacy.getAddress());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Pharmacy updated "+ pharmacy1;
    }

    @Override
    public String deletePharmacy(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Pharmacy pharmacy = entityManager.find(Pharmacy.class, id);
        entityManager.remove(pharmacy);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "pharmacy was deleted";
    }

    @Override
    public String getAllMedicineByPharmacyId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Pharmacy pharmacy = entityManager.find(Pharmacy.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Medicines "+pharmacy.getMedicines();
    }

    @Override
    public String getPharmacyByWorkerId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Worker worker = entityManager.find(Worker.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Pharmacies "+worker.getPharmacyList();
    }

    @Override
    public String searchByPharmacyId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Pharmacy pharmacy = entityManager.find(Pharmacy.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Pharmacy: "+pharmacy;
    }
}
