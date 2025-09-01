package com.veterinersistemi.randevu.service.veterinerian;

import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianCreateDTO;
import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianFullResponseDTO;
import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianUpdateDTO;
import com.veterinersistemi.randevu.entity.Veterinarian;
import com.veterinersistemi.randevu.NotFoundException;
import com.veterinersistemi.randevu.mapper.VeterinarianMapper;
import com.veterinersistemi.randevu.repository.VeterinarianRepository;
import com.veterinersistemi.randevu.service.veterinerian.VeterinarianService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeterinarianServiceImpl implements VeterinarianService {

    private final VeterinarianRepository veterinarianRepository;

    public VeterinarianServiceImpl(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    @Override
    public VeterinarianFullResponseDTO createVeterinarian(VeterinarianCreateDTO createDTO) {
        Veterinarian veterinarian = VeterinarianMapper.toEntity(createDTO);
        veterinarianRepository.save(veterinarian);
        return VeterinarianMapper.toFullResponseDTO(veterinarian);
    }

    @Override
    public VeterinarianFullResponseDTO updateVeterinarian(VeterinarianUpdateDTO updateDTO) {
        Veterinarian existingVeterinarian = veterinarianRepository.findById(updateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Veteriner bulunamadı."));
        Veterinarian updatedVeterinarian = VeterinarianMapper.toEntity(updateDTO);
        veterinarianRepository.save(updatedVeterinarian);
        return VeterinarianMapper.toFullResponseDTO(updatedVeterinarian);
    }

    @Override
    public void deleteVeterinarian(Long id) {
        veterinarianRepository.deleteById(id);
    }

    @Override
    public VeterinarianFullResponseDTO getVeterinarianById(Long id) {
        Veterinarian veterinarian = veterinarianRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Veteriner bulunamadı."));
        return VeterinarianMapper.toFullResponseDTO(veterinarian);
    }

    @Override
    public List<VeterinarianLimitedResponseDTO> getAllVeterinarians() {
        List<Veterinarian> veterinarians = veterinarianRepository.findAll();
        return veterinarians.stream()
                .map(VeterinarianMapper::toLimitedResponseDTO)
                .collect(Collectors.toList());
    }
}