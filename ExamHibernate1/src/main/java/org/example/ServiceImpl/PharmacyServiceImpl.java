package org.example.ServiceImpl;

import org.example.entity.Pharmacy;
import org.example.repoImpl.PharmacyRepoImpl;
import org.example.repository.PharmacyRepo;
import org.example.service.PharmacyService;

public class PharmacyServiceImpl implements PharmacyService {
    private PharmacyRepo pharmacyRepo = new PharmacyRepoImpl();
    @Override
    public void save(Pharmacy pharmacy) {
        pharmacyRepo.save(pharmacy);
    }

    @Override
    public Pharmacy finById(Long id) {
        return pharmacyRepo.finById(id);
    }

    @Override
    public String updatePharmacy(Long id, Pharmacy pharmacy) {
        return pharmacyRepo.updatePharmacy(id,pharmacy);
    }

    @Override
    public String deletePharmacy(Long id) {
        return pharmacyRepo.deletePharmacy(id);
    }

    @Override
    public String getAllMedicineByPharmacyId(Long id) {
        return pharmacyRepo.getAllMedicineByPharmacyId(id);
    }

    @Override
    public String getPharmacyByWorkerId(Long id) {
        return pharmacyRepo.getPharmacyByWorkerId(id);
    }

    @Override
    public String searchByPharmacyId(Long id) {
        return pharmacyRepo.searchByPharmacyId(id);
    }
}
