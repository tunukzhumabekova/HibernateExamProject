package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "medicines")
public class Medicines {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    @SequenceGenerator(name = "my_seq", sequenceName = "my_sequence", initialValue = 1)
    private Long id;
    private String name;
    @Column(length = +10000)
    private int price;
    @ToString.Exclude
    @ManyToMany(mappedBy = "medicines")
    private List<Pharmacy> pharmacyList;

    public Medicines(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
