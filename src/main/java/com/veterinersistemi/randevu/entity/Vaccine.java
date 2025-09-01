package com.veterinersistemi.randevu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "vaccine")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @NotBlank(message = "Aşı ismi boş bırakılamaz!")
    @Size(min=2, max=40, message = "Aşı ismi 2-40 arasında olmalıdır!")
    private String vaccineName;

    private LocalDate vaccineDate;

    @FutureOrPresent(message = "Sıradaki aşı tarihi geçmiş bir tarihte olamaz!")
    private LocalDate nextVaccineDate;

}
