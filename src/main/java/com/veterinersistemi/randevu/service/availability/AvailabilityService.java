package com.veterinersistemi.randevu.service.availability;


import com.veterinersistemi.randevu.dto.availabilityDTO.AvailabilityCreateDTO;
import com.veterinersistemi.randevu.dto.availabilityDTO.AvailabilityFullResponseDTO;
import com.veterinersistemi.randevu.dto.availabilityDTO.AvailabilityUpdateDTO;

import java.util.List;

public interface AvailabilityService {
    AvailabilityFullResponseDTO createAvailability(AvailabilityCreateDTO createDTO);
    AvailabilityFullResponseDTO updateAvailability(AvailabilityUpdateDTO updateDTO);
    void deleteAvailability(Long id);
    AvailabilityFullResponseDTO getAvailabilityById(Long id);
    List<AvailabilityFullResponseDTO> getAvailabilitiesByVeterinarianIdAndDay(Long veterinarianId, java.time.LocalDate day);
}