package com.veterinersistemi.randevu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "availabilities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @FutureOrPresent(message = "Müsaitlik günü, geçmiş bir tarihte olamaz!")
    private LocalDate appointmentDate;

    private LocalTime startTime;

    private LocalTime endTime;

    @AssertTrue(message = "Başlangıç saati bitiş saatinden önce olmalıdır!")
    private boolean isTimesValid() {
        if (startTime == null || endTime == null) {
            return true; // Null değerler için geçerli kabul et
        }
        return startTime.isBefore(endTime);
    }

    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private Veterinarian veterinarian;
}
