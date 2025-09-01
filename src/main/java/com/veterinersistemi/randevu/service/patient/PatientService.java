package com.veterinersistemi.randevu.service.patient;


import com.veterinersistemi.randevu.dto.patientDTO.PatientCreateDTO;
import com.veterinersistemi.randevu.dto.patientDTO.PatientFullResponseDTO;
import com.veterinersistemi.randevu.dto.patientDTO.PatientLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.patientDTO.PatientUpdateDTO;

import java.util.List;

public interface PatientService {
    PatientFullResponseDTO createPatient(PatientCreateDTO patientCreateDTO);

    PatientFullResponseDTO updatePatient(PatientUpdateDTO patientUpdateDTO);

    PatientFullResponseDTO getPatientById(Long id);

    List<PatientLimitedResponseDTO> getAllPatientsLimited();

    List<PatientFullResponseDTO> getAllPatientsFull();

    void deletePatient(Long id);
}
