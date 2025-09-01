package com.veterinersistemi.randevu.service.medicalHistory;

import com.veterinersistemi.randevu.dto.medicalHistoryDTO.MedicalHistoryCreateDTO;
import com.veterinersistemi.randevu.dto.medicalHistoryDTO.MedicalHistoryFullResponseDTO;
import com.veterinersistemi.randevu.dto.medicalHistoryDTO.MedicalHistoryUpdateDTO;

import java.util.List;

public interface MedicalHistoryService {
    MedicalHistoryFullResponseDTO createMedicalHistory(MedicalHistoryCreateDTO createDTO);

    MedicalHistoryFullResponseDTO updateMedicalHistory(MedicalHistoryUpdateDTO updateDTO);

    void deleteMedicalHistory(Long id);

    MedicalHistoryFullResponseDTO getMedicalHistoryById(Long id);

    List<MedicalHistoryFullResponseDTO> getMedicalHistoriesByPatientId(Long patientId);
}