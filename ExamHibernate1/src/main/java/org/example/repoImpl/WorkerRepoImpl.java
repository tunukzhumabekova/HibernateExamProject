package org.example.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.App;
import org.example.entity.Medicines;
import org.example.entity.Pharmacy;
import org.example.entity.Worker;
import org.example.repository.WorkerRepo;

import java.util.List;

public class WorkerRepoImpl implements WorkerRepo {
    private final EntityManagerFactory entityManagerFactory = App.getSession();
    @Override
    public void save(Worker worker) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(worker);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Worker finById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Worker worker = entityManager.find(Worker.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return worker;
    }

    @Override
    public String update(Long id, Worker worker) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Worker worker1 = entityManager.find(Worker.class,id);
        worker1.setName(worker.getName());
        worker1.setAddress(worker.getAddress());
        worker1.setEmail(worker.getEmail());
        worker1.setSalary(worker.getSalary());
        worker1.setDateOfBirth(worker.getDateOfBirth());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Worker updated "+ worker1;
    }

    @Override
    public String deleteWorker(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Worker worker = entityManager.find(Worker.class, id);
        entityManager.remove(worker);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "worker was deleted";
    }

    @Override
    public List<Worker> getAllWorkerByPharmacyId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Pharmacy pharmacy = entityManager.find(Pharmacy.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return pharmacy.getWorkers();
    }

    @Override
    public String getAllSalaryBySort(String ascOrDesc) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String sort = ascOrDesc.equalsIgnoreCase("ASC") ? "ASC" : "DESC";
        List<Worker> workers = entityManager.createQuery("select salary from Worker  order by salary " + sort, Worker.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return " "+workers;
    }
}
