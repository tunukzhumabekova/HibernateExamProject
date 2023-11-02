package org.example.repository;

import org.example.entity.Medicines;
import org.example.entity.Pharmacy;

import java.util.List;

public interface MedicinesRepo {
    void save (Medicines medicines);
    Medicines finById(Long id);
    String update(Long id, Medicines medicines);
    String deleteMedicine(Long id);
    List<Medicines> getAllPriceBySort(String ascOrDesc);
}
