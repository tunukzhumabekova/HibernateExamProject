package org.example.repository;

import org.example.entity.Pharmacy;

import java.util.List;

public interface PharmacyRepo {
    void save (Pharmacy pharmacy);
    Pharmacy finById(Long id);
    String updatePharmacy(Long id, Pharmacy pharmacy);
    String deletePharmacy(Long id);
    String getAllMedicineByPharmacyId(Long id);
    String getPharmacyByWorkerId(Long id);
    String searchByPharmacyId(Long id);
}
