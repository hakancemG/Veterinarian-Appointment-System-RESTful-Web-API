package com.veterinersistemi.randevu.dto.availabilityDTO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvailabilityCreateDTO {
    @NotNull(message = "Müsaitlik günü boş bırakılamaz!")
    @FutureOrPresent(message = "Müsaitlik günü, geçmiş bir tarihte olamaz!")
    private LocalDate appointmentDate;

    @NotNull(message = "Başlangıç saati boş bırakılamaz!")
    private LocalTime startTime;

    @NotNull(message = "Bitiş saati boş bırakılamaz!")
    private LocalTime endTime;

    @NotNull(message = "Veteriner ID'si boş bırakılamaz!")
    private Long veterinarianId;
}