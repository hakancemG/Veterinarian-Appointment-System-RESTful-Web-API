package com.veterinersistemi.randevu.dto.patientDTO;

import com.veterinersistemi.randevu.dto.customerDTO.CustomerLimitedResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientFullResponseDTO {
    private Long id;
    private String patientName;
    private String species;
    private String breed;
    private LocalDate dateOfBirth;
    private CustomerLimitedResponseDTO owner;
}