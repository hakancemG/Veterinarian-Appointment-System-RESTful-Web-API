package com.veterinersistemi.randevu.dto.medicalHistoryDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalHistoryLimitedResponseDTO {
    private Long id;
    private LocalDateTime medicalDate;
    private String diagnosis;
    private String treatment;
}