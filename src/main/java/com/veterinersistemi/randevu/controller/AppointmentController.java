package com.veterinersistemi.randevu.controller;

import com.veterinersistemi.randevu.dto.appointmentDTO.AppointmentCreateDTO;
import com.veterinersistemi.randevu.dto.appointmentDTO.AppointmentFullResponseDTO;
import com.veterinersistemi.randevu.dto.appointmentDTO.AppointmentUpdateDTO;
import com.veterinersistemi.randevu.service.appointment.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentFullResponseDTO> createAppointment(@Valid @RequestBody AppointmentCreateDTO createDTO) {
        AppointmentFullResponseDTO createdAppointment = appointmentService.createAppointment(createDTO);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AppointmentFullResponseDTO> updateAppointment(@Valid @RequestBody AppointmentUpdateDTO updateDTO) {
        AppointmentFullResponseDTO updatedAppointment = appointmentService.updateAppointment(updateDTO);
        return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentFullResponseDTO> getAppointmentById(@PathVariable Long id) {
        AppointmentFullResponseDTO appointment = appointmentService.getAppointmentById(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @GetMapping("/by-date-and-veterinarian")
    public ResponseEntity<List<AppointmentFullResponseDTO>> getAppointmentsByDateAndVeterinarianId(
            @RequestParam("date") LocalDate date,
            @RequestParam("veterinarianId") Long veterinarianId) {
        List<AppointmentFullResponseDTO> appointments = appointmentService.getAppointmentsByDateAndVeterinarianId(date, veterinarianId);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}