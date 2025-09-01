package com.veterinersistemi.randevu.dto.vaccineDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VaccineLimitedResponseDTO {
    private Long id;
    private String vaccineName;
    private LocalDate vaccineDate;
    private LocalDate nextVaccineDate;
}