package com.veterinersistemi.randevu.mapper;

import com.veterinersistemi.randevu.dto.vaccineDTO.VaccineCreateDTO;
import com.veterinersistemi.randevu.dto.vaccineDTO.VaccineFullResponseDTO;
import com.veterinersistemi.randevu.dto.vaccineDTO.VaccineLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.vaccineDTO.VaccineUpdateDTO;
import com.veterinersistemi.randevu.entity.Patient;
import com.veterinersistemi.randevu.entity.Vaccine;
import java.util.List;
import java.util.stream.Collectors;

public class VaccineMapper {

    // DTO'dan Entity'ye Dönüşüm Metotları
    public static Vaccine toEntity(VaccineCreateDTO createDTO, Patient patient) {
        if (createDTO == null) {
            return null;
        }
        return Vaccine.builder()
                .vaccineName(createDTO.getVaccineName())
                .vaccineDate(createDTO.getVaccineDate())
                .nextVaccineDate(createDTO.getNextVaccineDate())
                .patient(patient)
                .build();
    }

    public static Vaccine toEntity(VaccineUpdateDTO updateDTO, Patient patient) {
        if (updateDTO == null) {
            return null;
        }
        Vaccine vaccine = new Vaccine();
        vaccine.setId(updateDTO.getId());
        vaccine.setVaccineName(updateDTO.getVaccineName());
        vaccine.setVaccineDate(updateDTO.getVaccineDate());
        vaccine.setNextVaccineDate(updateDTO.getNextVaccineDate());
        vaccine.setPatient(patient);
        return vaccine;
    }

    // Entity'den DTO'ya Dönüşüm Metotları
    public static VaccineFullResponseDTO toFullResponseDTO(Vaccine vaccine) {
        if (vaccine == null) {
            return null;
        }
        return VaccineFullResponseDTO.builder()
                .id(vaccine.getId())
                .vaccineName(vaccine.getVaccineName())
                .vaccineDate(vaccine.getVaccineDate())
                .nextVaccineDate(vaccine.getNextVaccineDate())
                .patient(PatientMapper.toLimitedResponseDTO(vaccine.getPatient()))
                .build();
    }

    public static VaccineLimitedResponseDTO toLimitedResponseDTO(Vaccine vaccine) {
        if (vaccine == null) {
            return null;
        }
        return VaccineLimitedResponseDTO.builder()
                .id(vaccine.getId())
                .vaccineName(vaccine.getVaccineName())
                .vaccineDate(vaccine.getVaccineDate())
                .nextVaccineDate(vaccine.getNextVaccineDate())
                .build();
    }

    public static List<VaccineFullResponseDTO> toFullResponseDTOList(List<Vaccine> vaccines) {
        return vaccines.stream()
                .map(VaccineMapper::toFullResponseDTO)
                .collect(Collectors.toList());
    }
}