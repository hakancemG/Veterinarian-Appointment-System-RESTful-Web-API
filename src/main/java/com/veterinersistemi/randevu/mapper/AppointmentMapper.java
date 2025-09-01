package com.veterinersistemi.randevu.mapper;

import com.veterinersistemi.randevu.dto.appointmentDTO.AppointmentCreateDTO;
import com.veterinersistemi.randevu.dto.appointmentDTO.AppointmentFullResponseDTO;
import com.veterinersistemi.randevu.dto.appointmentDTO.AppointmentLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.appointmentDTO.AppointmentUpdateDTO;
import com.veterinersistemi.randevu.entity.Appointment;
import com.veterinersistemi.randevu.entity.Customer;
import com.veterinersistemi.randevu.entity.Patient;
import com.veterinersistemi.randevu.entity.Veterinarian;

import java.util.List;
import java.util.stream.Collectors;

public class AppointmentMapper {

    // DTO'dan Entity'ye Dönüşüm Metotları
    public static Appointment toEntity(AppointmentCreateDTO createDTO, Customer customer, Patient patient, Veterinarian veterinarian) {
        if (createDTO == null) {
            return null;
        }
        return Appointment.builder()
                .date(createDTO.getDate())
                .customer(customer)
                .patient(patient)
                .veterinarian(veterinarian)
                .build();
    }

    public static Appointment toEntity(AppointmentUpdateDTO updateDTO, Appointment existingAppointment) {
        if (updateDTO == null || existingAppointment == null) {
            return null;
        }
        existingAppointment.setDate(updateDTO.getDate());
        existingAppointment.setAppointmentStatus(updateDTO.getAppointmentStatus());
        // İlişkili nesneleri (customer, patient, veterinarian) bu aşamada güncellemiyoruz,
        // çünkü bunlar genellikle değişmez.
        return existingAppointment;
    }

    public static Appointment toEntityForUpdate(AppointmentUpdateDTO updateDTO, Appointment existingAppointment) {
        if (updateDTO == null || existingAppointment == null) {
            return null;
        }
        // Mevcut entity'nin alanlarını DTO'dan gelen verilerle güncelliyoruz.
        existingAppointment.setDate(updateDTO.getDate());
        existingAppointment.setAppointmentStatus(updateDTO.getAppointmentStatus());
        // İlişkili nesneler ve ID'nin manuel olarak set edilmesine gerek yoktur.
        // JPA, nesnelerin zaten bağlı olduğunu bilir.
        return existingAppointment;
    }

    // Entity'den DTO'ya Dönüşüm Metotları
    public static AppointmentFullResponseDTO toFullResponseDTO(Appointment appointment) {
        if (appointment == null) {
            return null;
        }
        return AppointmentFullResponseDTO.builder()
                .id(appointment.getId())
                .date(appointment.getDate())
                .appointmentStatus(appointment.getAppointmentStatus())
                .customer(CustomerMapper.toLimitedResponseDTO(appointment.getCustomer()))
                .patient(PatientMapper.toLimitedResponseDTO(appointment.getPatient()))
                .veterinarian(VeterinarianMapper.toLimitedResponseDTO(appointment.getVeterinarian()))
                .createdAt(appointment.getCreatedAt())
                .updatedAt(appointment.getUpdatedAt())
                .build();
    }

    public static AppointmentLimitedResponseDTO toLimitedResponseDTO(Appointment appointment) {
        if (appointment == null) {
            return null;
        }
        return AppointmentLimitedResponseDTO.builder()
                .id(appointment.getId())
                .date(appointment.getDate())
                .appointmentStatus(appointment.getAppointmentStatus())
                .build();
    }

    public static List<AppointmentFullResponseDTO> toFullResponseDTOList(List<Appointment> appointments) {
        return appointments.stream()
                .map(AppointmentMapper::toFullResponseDTO)
                .collect(Collectors.toList());
    }
}