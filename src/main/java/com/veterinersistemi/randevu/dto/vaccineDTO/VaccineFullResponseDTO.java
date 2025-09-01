package com.veterinersistemi.randevu.dto.vaccineDTO;

import com.veterinersistemi.randevu.dto.patientDTO.PatientLimitedResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VaccineFullResponseDTO {
    private Long id;
    private PatientLimitedResponseDTO patient;
    private String vaccineName;
    private LocalDate vaccineDate;
    private LocalDate nextVaccineDate;
}