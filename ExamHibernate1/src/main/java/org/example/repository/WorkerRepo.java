package org.example.repository;

import org.example.entity.Worker;

import java.util.List;

public interface WorkerRepo {
    void save (Worker worker);
    Worker finById(Long id);
    String update(Long id, Worker worker);
    String deleteWorker(Long id);
    List<Worker> getAllWorkerByPharmacyId(Long id);
    String getAllSalaryBySort(String ascOrDesc);
}
