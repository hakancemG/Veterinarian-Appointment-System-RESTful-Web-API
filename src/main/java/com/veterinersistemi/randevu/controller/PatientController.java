package com.veterinersistemi.randevu.controller;

import com.veterinersistemi.randevu.dto.patientDTO.PatientCreateDTO;
import com.veterinersistemi.randevu.dto.patientDTO.PatientFullResponseDTO;
import com.veterinersistemi.randevu.dto.patientDTO.PatientLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.patientDTO.PatientUpdateDTO;
import com.veterinersistemi.randevu.service.patient.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientFullResponseDTO> createPatient(@Valid @RequestBody PatientCreateDTO patientCreateDTO) {
        PatientFullResponseDTO createdPatient = patientService.createPatient(patientCreateDTO);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PatientFullResponseDTO> updatePatient(@Valid @RequestBody PatientUpdateDTO patientUpdateDTO) {
        PatientFullResponseDTO updatedPatient = patientService.updatePatient(patientUpdateDTO);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientFullResponseDTO> getPatientById(@PathVariable Long id) {
        PatientFullResponseDTO patient = patientService.getPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping("/limited")
    public ResponseEntity<List<PatientLimitedResponseDTO>> getAllPatientsLimited() {
        List<PatientLimitedResponseDTO> patients = patientService.getAllPatientsLimited();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/full")
    public ResponseEntity<List<PatientFullResponseDTO>> getAllPatientsFull() {
        List<PatientFullResponseDTO> patients = patientService.getAllPatientsFull();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}