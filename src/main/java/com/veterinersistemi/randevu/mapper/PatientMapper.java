package com.veterinersistemi.randevu.mapper;

import com.veterinersistemi.randevu.dto.patientDTO.PatientCreateDTO;
import com.veterinersistemi.randevu.dto.patientDTO.PatientFullResponseDTO;
import com.veterinersistemi.randevu.dto.patientDTO.PatientLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.patientDTO.PatientUpdateDTO;
import com.veterinersistemi.randevu.entity.Patient;
import com.veterinersistemi.randevu.entity.Customer; // Customer entity'sini import etmeyi unutma

public class PatientMapper {

    // DTO'dan Entity'ye Dönüşüm Metotları
    public static Patient toEntity(PatientCreateDTO patientCreateDTO, Customer owner) {
        if (patientCreateDTO == null) {
            return null;
        }
        return Patient.builder()
                .patientName(patientCreateDTO.getPatientName())
                .species(patientCreateDTO.getSpecies())
                .breed(patientCreateDTO.getBreed())
                .dateOfBirth(patientCreateDTO.getDateOfBirth())
                .owner(owner) // Owner nesnesini direkt olarak entity'ye set ediyoruz
                .build();
    }

    public static Patient toEntity(PatientUpdateDTO patientUpdateDTO, Patient patient) {
        if (patientUpdateDTO == null || patient == null) {
            return null;
        }
        patient.setPatientName(patientUpdateDTO.getPatientName());
        patient.setSpecies(patientUpdateDTO.getSpecies());
        patient.setBreed(patientUpdateDTO.getBreed());
        patient.setDateOfBirth(patientUpdateDTO.getDateOfBirth());
        return patient;
    }

    // Entity'den DTO'ya Dönüşüm Metotları
    public static PatientFullResponseDTO toFullResponseDTO(Patient patient) {
        if (patient == null) {
            return null;
        }
        return PatientFullResponseDTO.builder()
                .id(patient.getId())
                .patientName(patient.getPatientName())
                .species(patient.getSpecies())
                .breed(patient.getBreed())
                .dateOfBirth(patient.getDateOfBirth())
                .owner(CustomerMapper.toLimitedResponseDTO(patient.getOwner())) // İlişkili Customer'ı DTO'ya dönüştürüyoruz
                .build();
    }

    public static PatientLimitedResponseDTO toLimitedResponseDTO(Patient patient) {
        if (patient == null) {
            return null;
        }
        return PatientLimitedResponseDTO.builder()
                .id(patient.getId())
                .patientName(patient.getPatientName())
                .species(patient.getSpecies())
                .build();
    }
}