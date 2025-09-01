package com.veterinersistemi.randevu.controller;

import com.veterinersistemi.randevu.dto.availabilityDTO.AvailabilityCreateDTO;
import com.veterinersistemi.randevu.dto.availabilityDTO.AvailabilityFullResponseDTO;
import com.veterinersistemi.randevu.dto.availabilityDTO.AvailabilityUpdateDTO;
import com.veterinersistemi.randevu.service.availability.AvailabilityService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/availabilities")
public class AvailabilityController {

    private final AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @PostMapping
    public ResponseEntity<AvailabilityFullResponseDTO> createAvailability(@Valid @RequestBody AvailabilityCreateDTO createDTO) {
        AvailabilityFullResponseDTO createdAvailability = availabilityService.createAvailability(createDTO);
        return new ResponseEntity<>(createdAvailability, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AvailabilityFullResponseDTO> updateAvailability(@Valid @RequestBody AvailabilityUpdateDTO updateDTO) {
        AvailabilityFullResponseDTO updatedAvailability = availabilityService.updateAvailability(updateDTO);
        return new ResponseEntity<>(updatedAvailability, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvailabilityFullResponseDTO> getAvailabilityById(@PathVariable Long id) {
        AvailabilityFullResponseDTO availability = availabilityService.getAvailabilityById(id);
        return new ResponseEntity<>(availability, HttpStatus.OK);
    }

    @GetMapping("/veterinarian/{veterinarianId}/date/{date}")
    public ResponseEntity<List<AvailabilityFullResponseDTO>> getAvailabilitiesByVeterinarianIdAndDate(
            @PathVariable Long veterinarianId,
            @PathVariable LocalDate date) {
        List<AvailabilityFullResponseDTO> availabilities = availabilityService.getAvailabilitiesByVeterinarianIdAndDay(veterinarianId, date);
        return new ResponseEntity<>(availabilities, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable Long id) {
        availabilityService.deleteAvailability(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}