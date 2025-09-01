package com.veterinersistemi.randevu.controller;

import com.veterinersistemi.randevu.dto.medicalHistoryDTO.MedicalHistoryCreateDTO;
import com.veterinersistemi.randevu.dto.medicalHistoryDTO.MedicalHistoryFullResponseDTO;
import com.veterinersistemi.randevu.dto.medicalHistoryDTO.MedicalHistoryUpdateDTO;
import com.veterinersistemi.randevu.service.medicalHistory.MedicalHistoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medical-histories")
public class MedicalHistoryController {

    private final MedicalHistoryService medicalHistoryService;

    public MedicalHistoryController(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }

    @PostMapping
    public ResponseEntity<MedicalHistoryFullResponseDTO> createMedicalHistory(@Valid @RequestBody MedicalHistoryCreateDTO createDTO) {
        MedicalHistoryFullResponseDTO createdMedicalHistory = medicalHistoryService.createMedicalHistory(createDTO);
        return new ResponseEntity<>(createdMedicalHistory, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MedicalHistoryFullResponseDTO> updateMedicalHistory(@Valid @RequestBody MedicalHistoryUpdateDTO updateDTO) {
        MedicalHistoryFullResponseDTO updatedMedicalHistory = medicalHistoryService.updateMedicalHistory(updateDTO);
        return new ResponseEntity<>(updatedMedicalHistory, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalHistoryFullResponseDTO> getMedicalHistoryById(@PathVariable Long id) {
        MedicalHistoryFullResponseDTO medicalHistory = medicalHistoryService.getMedicalHistoryById(id);
        return new ResponseEntity<>(medicalHistory, HttpStatus.OK);
    }

    @GetMapping("/by-patient/{patientId}")
    public ResponseEntity<List<MedicalHistoryFullResponseDTO>> getMedicalHistoriesByPatientId(@PathVariable Long patientId) {
        List<MedicalHistoryFullResponseDTO> medicalHistories = medicalHistoryService.getMedicalHistoriesByPatientId(patientId);
        return new ResponseEntity<>(medicalHistories, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalHistory(@PathVariable Long id) {
        medicalHistoryService.deleteMedicalHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}