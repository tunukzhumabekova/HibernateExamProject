package org.example.ServiceImpl;

import org.example.entity.Worker;
import org.example.repoImpl.WorkerRepoImpl;
import org.example.repository.WorkerRepo;
import org.example.service.WorkerService;

import java.util.List;

public class WorkerServiceImpl implements WorkerService {
    private WorkerRepo workerRepo = new WorkerRepoImpl();
    @Override
    public void save(Worker worker) {
        workerRepo.save(worker);
    }

    @Override
    public Worker finById(Long id) {
        return workerRepo.finById(id);
    }

    @Override
    public String update(Long id, Worker worker) {
        return workerRepo.update(id,worker);
    }

    @Override
    public String deleteWorker(Long id) {
        return workerRepo.deleteWorker(id);
    }

    @Override
    public List<Worker> getAllWorkerByPharmacyId(Long id) {
        return workerRepo.getAllWorkerByPharmacyId(id);
    }

    @Override
    public String getAllSalaryBySort(String ascOrDesc) {
        return workerRepo.getAllSalaryBySort(ascOrDesc);
    }
}
