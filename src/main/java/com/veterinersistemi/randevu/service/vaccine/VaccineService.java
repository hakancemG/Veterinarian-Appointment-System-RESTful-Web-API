package com.veterinersistemi.randevu.service.vaccine;

import com.veterinersistemi.randevu.dto.vaccineDTO.VaccineCreateDTO;
import com.veterinersistemi.randevu.dto.vaccineDTO.VaccineFullResponseDTO;
import com.veterinersistemi.randevu.dto.vaccineDTO.VaccineUpdateDTO;

import java.util.List;

public interface VaccineService {
    VaccineFullResponseDTO createVaccine(VaccineCreateDTO createDTO);

    VaccineFullResponseDTO updateVaccine(VaccineUpdateDTO updateDTO);

    void deleteVaccine(Long id);

    VaccineFullResponseDTO getVaccineById(Long id);

    List<VaccineFullResponseDTO> getVaccinesByPatientId(Long patientId);
}
