package com.veterinersistemi.randevu.controller;

import com.veterinersistemi.randevu.dto.vaccineDTO.VaccineCreateDTO;
import com.veterinersistemi.randevu.dto.vaccineDTO.VaccineFullResponseDTO;
import com.veterinersistemi.randevu.dto.vaccineDTO.VaccineUpdateDTO;
import com.veterinersistemi.randevu.service.vaccine.VaccineService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vaccines")
public class VaccineController {

    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @PostMapping
    public ResponseEntity<VaccineFullResponseDTO> createVaccine(@Valid @RequestBody VaccineCreateDTO createDTO) {
        VaccineFullResponseDTO createdVaccine = vaccineService.createVaccine(createDTO);
        return new ResponseEntity<>(createdVaccine, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<VaccineFullResponseDTO> updateVaccine(@Valid @RequestBody VaccineUpdateDTO updateDTO) {
        VaccineFullResponseDTO updatedVaccine = vaccineService.updateVaccine(updateDTO);
        return new ResponseEntity<>(updatedVaccine, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VaccineFullResponseDTO> getVaccineById(@PathVariable Long id) {
        VaccineFullResponseDTO vaccine = vaccineService.getVaccineById(id);
        return new ResponseEntity<>(vaccine, HttpStatus.OK);
    }

    @GetMapping("/by-patient/{patientId}")
    public ResponseEntity<List<VaccineFullResponseDTO>> getVaccinesByPatientId(@PathVariable Long patientId) {
        List<VaccineFullResponseDTO> vaccines = vaccineService.getVaccinesByPatientId(patientId);
        return new ResponseEntity<>(vaccines, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccine(@PathVariable Long id) {
        vaccineService.deleteVaccine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}