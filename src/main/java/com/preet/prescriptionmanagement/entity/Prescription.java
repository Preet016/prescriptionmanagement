package com.preet.prescriptionmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String disease;

    private String medicine;

    private LocalDate date;

    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    @ToString.Exclude
    @JsonBackReference
    private Patient patient;

}
