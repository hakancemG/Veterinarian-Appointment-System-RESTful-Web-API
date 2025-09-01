package com.veterinersistemi.randevu.service.appointment;

import com.veterinersistemi.randevu.dto.appointmentDTO.AppointmentCreateDTO;
import com.veterinersistemi.randevu.dto.appointmentDTO.AppointmentFullResponseDTO;
import com.veterinersistemi.randevu.dto.appointmentDTO.AppointmentUpdateDTO;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    AppointmentFullResponseDTO createAppointment(AppointmentCreateDTO createDTO);
    AppointmentFullResponseDTO updateAppointment(AppointmentUpdateDTO updateDTO);
    void deleteAppointment(Long id);
    AppointmentFullResponseDTO getAppointmentById(Long id);
    List<AppointmentFullResponseDTO> getAppointmentsByDateAndVeterinarianId(LocalDate date, Long veterinarianId);
}