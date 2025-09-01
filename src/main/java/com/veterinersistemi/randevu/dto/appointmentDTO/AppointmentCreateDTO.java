package com.veterinersistemi.randevu.dto.appointmentDTO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentCreateDTO {

    @NotNull(message = "Randevu tarihi boş bırakılamaz!")
    @FutureOrPresent(message = "Randevu tarihi geçmiş bir zaman olamaz!")
    private LocalDateTime date;

    @NotNull(message = "Müşteri ID'si boş bırakılamaz!")
    private Long customerId;

    @NotNull(message = "Hasta ID'si boş bırakılamaz!")
    private Long patientId;

    @NotNull(message = "Veteriner ID'si boş bırakılamaz!")
    private Long veterinarianId;
}