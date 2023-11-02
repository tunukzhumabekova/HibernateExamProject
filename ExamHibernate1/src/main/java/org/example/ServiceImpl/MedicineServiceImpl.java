package org.example.ServiceImpl;

import org.example.entity.Medicines;
import org.example.repoImpl.MedicinesRepoImpl;
import org.example.repository.MedicinesRepo;
import org.example.service.MedicineService;

import java.util.List;

public class MedicineServiceImpl implements MedicineService {
    private MedicinesRepo medicinesRepo = new MedicinesRepoImpl();
    @Override
    public void save(Medicines medicines) {
        medicinesRepo.save(medicines);
    }

    @Override
    public Medicines finById(Long id) {
        return medicinesRepo.finById(id);
    }

    @Override
    public String update(Long id, Medicines medicines) {
        return medicinesRepo.update(id,medicines);
    }

    @Override
    public String deleteMedicine(Long id) {
        return medicinesRepo.deleteMedicine(id);
    }

    @Override
    public List<Medicines> getAllPriceBySort(String ascOrDesc) {
        return medicinesRepo.getAllPriceBySort(ascOrDesc);
    }
}
