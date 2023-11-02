package org.example.service;

import org.example.entity.Medicines;

import java.util.List;

public interface MedicineService {
    void save (Medicines medicines);
    Medicines finById(Long id);
    String update(Long id, Medicines medicines);
    String deleteMedicine(Long id);
    List<Medicines> getAllPriceBySort(String ascOrDesc);
}
