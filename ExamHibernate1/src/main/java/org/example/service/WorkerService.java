package org.example.service;

import org.example.entity.Worker;

import java.util.List;

public interface WorkerService {
    void save (Worker worker);
    Worker finById(Long id);
    String update(Long id, Worker worker);
    String deleteWorker(Long id);
    List<Worker> getAllWorkerByPharmacyId(Long id);
    String getAllSalaryBySort(String ascOrDesc);
}
