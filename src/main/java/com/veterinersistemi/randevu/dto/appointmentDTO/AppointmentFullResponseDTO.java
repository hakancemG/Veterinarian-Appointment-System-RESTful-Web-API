package com.veterinersistemi.randevu.dto.appointmentDTO;

import com.veterinersistemi.randevu.dto.customerDTO.CustomerLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.patientDTO.PatientLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianLimitedResponseDTO;
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
public class AppointmentFullResponseDTO {
    private Long id;
    private LocalDateTime date;
    private AppointmentStatus appointmentStatus;
    private CustomerLimitedResponseDTO customer;
    private PatientLimitedResponseDTO patient;
    private VeterinarianLimitedResponseDTO veterinarian;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}