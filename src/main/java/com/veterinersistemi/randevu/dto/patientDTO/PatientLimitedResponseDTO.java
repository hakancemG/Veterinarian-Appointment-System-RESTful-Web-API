package com.veterinersistemi.randevu.dto.patientDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientLimitedResponseDTO {
    private Long id;
    private String patientName;
    private String species;
}