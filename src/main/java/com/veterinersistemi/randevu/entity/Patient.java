package com.veterinersistemi.randevu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Hasta hayvanın ismi alanı boş bırakılamaz!")
    @Size(min=2, max=30, message = "Hasta ismi, 2-30 karakter arasında olmalıdır!")
    private String patientName;

    @NotBlank(message = "Hasta hayvanın türü alanı boş bırakılamaz!")
    @Size(min=3, max=30, message = "Hasta hayvanın türü, 3-30 karakter arasında olmalıdır!")
    private String species;

    @NotBlank(message = "Hasta hayvanın cinsi alanı boş bırakılamaz!")
    @Size(min=3, max=30, message = "Hasta hayvanın cinsi, 3-30 karakter arasında olmalıdır!")
    private String breed;

    @PastOrPresent(message = "Doğum tarihi bugünden sonra olamaz!")
    @NotNull(message = "Hasta hayvanın yaşı boş bırakılamaz!")
    private LocalDate dateOfBirth;

    @ManyToOne
    private Customer owner;
}
