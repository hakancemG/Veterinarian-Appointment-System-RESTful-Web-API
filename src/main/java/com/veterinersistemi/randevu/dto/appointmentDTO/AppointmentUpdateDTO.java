package com.veterinersistemi.randevu.dto.appointmentDTO;

import com.veterinersistemi.randevu.enums.AppointmentStatus;
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
public class AppointmentUpdateDTO {

    @NotNull(message = "ID boş bırakılamaz!")
    private Long id;

    @NotNull(message = "Randevu tarihi boş bırakılamaz!")
    @FutureOrPresent(message = "Randevu tarihi geçmiş bir zaman olamaz!")
    private LocalDateTime date;

    @NotNull(message = "Randevu durumu boş bırakılamaz!")
    private AppointmentStatus appointmentStatus;

    @NotNull(message = "Veteriner ID'si boş bırakılamaz!")
    private Long veterinarianId;
}