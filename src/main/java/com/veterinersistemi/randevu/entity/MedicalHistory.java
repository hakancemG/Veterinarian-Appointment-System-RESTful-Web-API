package com.veterinersistemi.randevu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "medical_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PastOrPresent(message = "Hasta tedavi tarihi gelecek bir zamanda olamaz!")
    private LocalDateTime medicalDate;

    @Size(min=3, max=250, message = "Not 3-250 arasında olmalıdır!")
    @NotBlank(message = "Hasta tedavi notu boş bırakılamaz!")
    private String note;

    @NotBlank(message = "Teşhis boş bırakılamaz!")
    @Size(min=2, max=50, message = "Teşhis kısmı 2-50 karakter arasında olmalıdır!")
    private String diagnosis;

    @NotBlank(message = "Tedavi boş bırakılamaz!")
    @Size(min=2, max=100, message = "Tedavi kısmı 2-100 karakter arasında olmalıdır!")
    private String treatment;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private Veterinarian veterinarian;
}
