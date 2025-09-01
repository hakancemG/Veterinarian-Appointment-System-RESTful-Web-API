package com.veterinersistemi.randevu.service.availability;

import com.veterinersistemi.randevu.dto.availabilityDTO.AvailabilityCreateDTO;
import com.veterinersistemi.randevu.dto.availabilityDTO.AvailabilityFullResponseDTO;
import com.veterinersistemi.randevu.dto.availabilityDTO.AvailabilityUpdateDTO;
import com.veterinersistemi.randevu.entity.Availability;
import com.veterinersistemi.randevu.entity.Veterinarian;
import com.veterinersistemi.randevu.NotFoundException;
import com.veterinersistemi.randevu.mapper.AvailabilityMapper;
import com.veterinersistemi.randevu.repository.AvailabilityRepository;
import com.veterinersistemi.randevu.repository.VeterinarianRepository;
import com.veterinersistemi.randevu.service.availability.AvailabilityService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    private final AvailabilityRepository availabilityRepository;
    private final VeterinarianRepository veterinarianRepository;

    public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository, VeterinarianRepository veterinarianRepository) {
        this.availabilityRepository = availabilityRepository;
        this.veterinarianRepository = veterinarianRepository;
    }

    @Override
    public AvailabilityFullResponseDTO createAvailability(AvailabilityCreateDTO createDTO) {
        Veterinarian veterinarian = veterinarianRepository.findById(createDTO.getVeterinarianId())
                .orElseThrow(() -> new NotFoundException("Veteriner bulunamadı."));

        Availability availability = AvailabilityMapper.toEntity(createDTO, veterinarian);
        availabilityRepository.save(availability);
        return AvailabilityMapper.toFullResponseDTO(availability);
    }

    @Override
    public AvailabilityFullResponseDTO updateAvailability(AvailabilityUpdateDTO updateDTO) {
        Availability existingAvailability = availabilityRepository.findById(updateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Müsaitlik kaydı bulunamadı."));

        Availability updatedAvailability = AvailabilityMapper.toEntity(updateDTO);
        updatedAvailability.setVeterinarian(existingAvailability.getVeterinarian());
        availabilityRepository.save(updatedAvailability);
        return AvailabilityMapper.toFullResponseDTO(updatedAvailability);
    }

    @Override
    public void deleteAvailability(Long id) {
        availabilityRepository.deleteById(id);
    }

    @Override
    public AvailabilityFullResponseDTO getAvailabilityById(Long id) {
        Availability availability = availabilityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Müsaitlik kaydı bulunamadı."));
        return AvailabilityMapper.toFullResponseDTO(availability);
    }

    @Override
    public List<AvailabilityFullResponseDTO> getAvailabilitiesByVeterinarianIdAndDay(Long veterinarianId, LocalDate day) {
        List<Availability> availabilities = availabilityRepository.findByVeterinarianIdAndAppointmentDate(veterinarianId, day);
        return availabilities.stream()
                .map(AvailabilityMapper::toFullResponseDTO)
                .collect(Collectors.toList());
    }
}