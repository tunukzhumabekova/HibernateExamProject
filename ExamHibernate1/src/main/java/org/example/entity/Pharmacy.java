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
@Table(name = "pharmacy")
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    @SequenceGenerator(name = "my_seq", sequenceName = "my_sequence", initialValue = 1)
    private Long id;
    private String name;
    private String address;

    @ManyToMany(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
    private List<Medicines> medicines;
    @ToString.Exclude
    @ManyToMany(cascade= CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Worker>workers;


    public Pharmacy(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
