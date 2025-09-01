package com.veterinersistemi.randevu.controller;

import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianCreateDTO;
import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianFullResponseDTO;
import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianUpdateDTO;
import com.veterinersistemi.randevu.service.veterinerian.VeterinarianService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/veterinarians")
public class VeterinarianController {

    private final VeterinarianService veterinarianService;

    public VeterinarianController(VeterinarianService veterinarianService) {
        this.veterinarianService = veterinarianService;
    }

    @PostMapping
    public ResponseEntity<VeterinarianFullResponseDTO> createVeterinarian(@Valid @RequestBody VeterinarianCreateDTO veterinarianCreateDTO) {
        VeterinarianFullResponseDTO createdVeterinarian = veterinarianService.createVeterinarian(veterinarianCreateDTO);
        return new ResponseEntity<>(createdVeterinarian, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<VeterinarianFullResponseDTO> updateVeterinarian(@Valid @RequestBody VeterinarianUpdateDTO veterinarianUpdateDTO) {
        VeterinarianFullResponseDTO updatedVeterinarian = veterinarianService.updateVeterinarian(veterinarianUpdateDTO);
        return new ResponseEntity<>(updatedVeterinarian, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeterinarianFullResponseDTO> getVeterinarianById(@PathVariable Long id) {
        VeterinarianFullResponseDTO veterinarian = veterinarianService.getVeterinarianById(id);
        return new ResponseEntity<>(veterinarian, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VeterinarianLimitedResponseDTO>> getAllVeterinarians() {
        List<VeterinarianLimitedResponseDTO> veterinarians = veterinarianService.getAllVeterinarians();
        return new ResponseEntity<>(veterinarians, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeterinarian(@PathVariable Long id) {
        veterinarianService.deleteVeterinarian(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}