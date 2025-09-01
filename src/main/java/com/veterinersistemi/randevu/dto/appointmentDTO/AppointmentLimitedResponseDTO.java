package com.veterinersistemi.randevu.dto.appointmentDTO;

import com.veterinersistemi.randevu.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentLimitedResponseDTO {
    private Long id;
    private LocalDateTime date;
    private AppointmentStatus appointmentStatus;
}