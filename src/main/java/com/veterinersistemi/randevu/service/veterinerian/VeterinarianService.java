package com.veterinersistemi.randevu.service.veterinerian;

import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianCreateDTO;
import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianFullResponseDTO;
import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianUpdateDTO;

import java.util.List;

public interface VeterinarianService {
    VeterinarianFullResponseDTO createVeterinarian(VeterinarianCreateDTO createDTO);
    VeterinarianFullResponseDTO updateVeterinarian(VeterinarianUpdateDTO updateDTO);
    void deleteVeterinarian(Long id);
    VeterinarianFullResponseDTO getVeterinarianById(Long id);
    List<VeterinarianLimitedResponseDTO> getAllVeterinarians();
}
