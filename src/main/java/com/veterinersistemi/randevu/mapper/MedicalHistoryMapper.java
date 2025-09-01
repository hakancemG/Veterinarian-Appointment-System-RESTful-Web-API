package com.veterinersistemi.randevu.mapper;

import com.veterinersistemi.randevu.dto.medicalHistoryDTO.MedicalHistoryCreateDTO;
import com.veterinersistemi.randevu.dto.medicalHistoryDTO.MedicalHistoryFullResponseDTO;
import com.veterinersistemi.randevu.dto.medicalHistoryDTO.MedicalHistoryLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.medicalHistoryDTO.MedicalHistoryUpdateDTO;
import com.veterinersistemi.randevu.entity.MedicalHistory;
import com.veterinersistemi.randevu.entity.Patient;
import com.veterinersistemi.randevu.entity.Veterinarian;
import java.util.List;
import java.util.stream.Collectors;

public class MedicalHistoryMapper {

    // DTO'dan Entity'ye Dönüşüm Metotları
    public static MedicalHistory toEntity(MedicalHistoryCreateDTO createDTO, Patient patient, Veterinarian veterinarian) {
        if (createDTO == null) {
            return null;
        }
        return MedicalHistory.builder()
                .medicalDate(createDTO.getMedicalDate())
                .note(createDTO.getNote())
                .diagnosis(createDTO.getDiagnosis())
                .treatment(createDTO.getTreatment())
                .patient(patient)
                .veterinarian(veterinarian)
                .build();
    }

    public static MedicalHistory toEntity(MedicalHistoryUpdateDTO updateDTO, Patient patient, Veterinarian veterinarian) {
        if (updateDTO == null) {
            return null;
        }
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setId(updateDTO.getId());
        medicalHistory.setMedicalDate(updateDTO.getMedicalDate());
        medicalHistory.setNote(updateDTO.getNote());
        medicalHistory.setDiagnosis(updateDTO.getDiagnosis());
        medicalHistory.setTreatment(updateDTO.getTreatment());
        medicalHistory.setPatient(patient);
        medicalHistory.setVeterinarian(veterinarian);
        return medicalHistory;
    }

    // Entity'den DTO'ya Dönüşüm Metotları
    public static MedicalHistoryFullResponseDTO toFullResponseDTO(MedicalHistory medicalHistory) {
        if (medicalHistory == null) {
            return null;
        }
        return MedicalHistoryFullResponseDTO.builder()
                .id(medicalHistory.getId())
                .medicalDate(medicalHistory.getMedicalDate())
                .note(medicalHistory.getNote())
                .diagnosis(medicalHistory.getDiagnosis())
                .treatment(medicalHistory.getTreatment())
                .patient(PatientMapper.toLimitedResponseDTO(medicalHistory.getPatient()))
                .veterinarian(VeterinarianMapper.toLimitedResponseDTO(medicalHistory.getVeterinarian()))
                .build();
    }

    public static MedicalHistoryLimitedResponseDTO toLimitedResponseDTO(MedicalHistory medicalHistory) {
        if (medicalHistory == null) {
            return null;
        }
        return MedicalHistoryLimitedResponseDTO.builder()
                .id(medicalHistory.getId())
                .medicalDate(medicalHistory.getMedicalDate())
                .diagnosis(medicalHistory.getDiagnosis())
                .treatment(medicalHistory.getTreatment())
                .build();
    }

    public static List<MedicalHistoryFullResponseDTO> toFullResponseDTOList(List<MedicalHistory> medicalHistories) {
        return medicalHistories.stream()
                .map(MedicalHistoryMapper::toFullResponseDTO)
                .collect(Collectors.toList());
    }
}