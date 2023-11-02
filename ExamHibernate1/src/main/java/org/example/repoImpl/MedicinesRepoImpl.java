package org.example.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.App;
import org.example.entity.Medicines;
import org.example.repository.MedicinesRepo;

import java.util.List;

public class MedicinesRepoImpl implements MedicinesRepo {
    private final EntityManagerFactory entityManagerFactory = App.getSession();

    @Override
    public void save(Medicines medicines) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(medicines);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Medicines finById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Medicines medicines = entityManager.find(Medicines.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return medicines;
    }

    @Override
    public String update(Long id, Medicines medicines) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Medicines medicines1 = entityManager.find(Medicines.class,id);
        medicines1.setName(medicines.getName());
        medicines1.setPrice(medicines.getPrice());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Pharmacy updated "+ medicines1;
    }

    @Override
    public String deleteMedicine(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Medicines medicines = entityManager.find(Medicines.class, id);
        entityManager.remove(medicines);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "medicine was deleted";
    }

    public List<Medicines> getAllPriceBySort(String ascOrDesc) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String sort = ascOrDesc.equalsIgnoreCase("ASC") ? "ASC" : "DESC";
        List<Medicines> mediciness = entityManager.createQuery("select m from Medicines m order by name " + sort, Medicines.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return mediciness;
    }
}
