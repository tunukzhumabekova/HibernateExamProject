package org.example;

import org.example.ServiceImpl.MedicineServiceImpl;
import org.example.ServiceImpl.PharmacyServiceImpl;
import org.example.ServiceImpl.WorkerServiceImpl;
import org.example.entity.Medicines;
import org.example.entity.Pharmacy;
import org.example.entity.Worker;
import org.example.service.MedicineService;
import org.example.service.PharmacyService;
import org.example.service.WorkerService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App.getSession();
        PharmacyService pharmacyService = new PharmacyServiceImpl();
        MedicineService medicineService = new MedicineServiceImpl();
        WorkerService workerService = new WorkerServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Write command: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1 ->{
                    Medicines medicines = new Medicines("nana",20);
                    Worker worker = new Worker("Artur","a@gmail.com",256314,"someAddress", LocalDate.of(2002,2,12));
                    Pharmacy pharmacy = new Pharmacy("lala","SomeAddress");
                    pharmacy.setWorkers(List.of(worker));
                    pharmacy.setMedicines(List.of(medicines));
                    pharmacyService.save(pharmacy);
                }
                case 2 -> {
                    System.out.println(pharmacyService.finById(1L));
                }
                case 3 -> {
                    System.out.println(pharmacyService.updatePharmacy(1L, new Pharmacy("Neman", "Chui 123")));
                }
                case 4 -> {
                    System.out.println(pharmacyService.getPharmacyByWorkerId(1L));
                }
                case 5 -> {
                    System.out.println(pharmacyService.getAllMedicineByPharmacyId(1L));
                }
                case 6 -> {
                    System.out.println(pharmacyService.searchByPharmacyId(1L));
                }
                case 7 -> {
                    System.out.println(pharmacyService.deletePharmacy(1L));
                }
                case 8 -> {
                    workerService.save(new Worker("Aigerima","a@gmail.com",51651,"address",LocalDate.of(2000,5,15)));
                }
                case 9 -> {
                    System.out.println(workerService.finById(2L));
                }
                case 10 -> {
                    System.out.println(workerService.update(1L, new Worker("Alina", "a@gmail.com", 51651, "address", LocalDate.of(2000, 5, 15))));
                }
                case 11 -> {
                    System.out.println(workerService.getAllSalaryBySort("asc"));
                }
                case 12 -> {
                    System.out.println(workerService.getAllWorkerByPharmacyId(1L));
                }
                case 13 -> {
                    System.out.println(workerService.deleteWorker(2L));
                }
                case 14 -> {
                    System.out.println(medicineService.finById(2L));
                }
                case 15 -> {
                    System.out.println(medicineService.update(1L, new Medicines("NoGripp", 485)));
                }
                case 16 -> {
                    System.out.println(medicineService.getAllPriceBySort("des"));
                }
                case 17 -> {
                    System.out.println(medicineService.deleteMedicine(2L));
                }
                case 18 -> {
                    medicineService.save(new Medicines("cdfgb",65));
                }
            }
        }
    }
}
