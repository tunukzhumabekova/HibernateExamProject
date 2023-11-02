package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    @SequenceGenerator(name = "my_seq", sequenceName = "my_sequence", initialValue = 1)
    private Long id;
    private String name;
    private String email;
    private int salary;
    private String address;
    private LocalDate dateOfBirth;

    @ManyToMany(mappedBy = "workers")
    private List<Pharmacy>pharmacyList;

    public Worker(String name, String email, int salary, String address, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

}
