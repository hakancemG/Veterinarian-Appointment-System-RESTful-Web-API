package com.veterinersistemi.randevu.dto.medicalHistoryDTO;

import com.veterinersistemi.randevu.dto.patientDTO.PatientLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianLimitedResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalHistoryFullResponseDTO {
    private Long id;
    private PatientLimitedResponseDTO patient;
    private VeterinarianLimitedResponseDTO veterinarian;
    private LocalDateTime medicalDate;
    private String note;
    private String diagnosis;
    private String treatment;
}