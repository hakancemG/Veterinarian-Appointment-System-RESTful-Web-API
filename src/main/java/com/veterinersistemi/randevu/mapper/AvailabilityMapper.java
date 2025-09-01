package com.veterinersistemi.randevu.mapper;

import com.veterinersistemi.randevu.dto.availabilityDTO.AvailabilityCreateDTO;
import com.veterinersistemi.randevu.dto.availabilityDTO.AvailabilityFullResponseDTO;
import com.veterinersistemi.randevu.dto.availabilityDTO.AvailabilityLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.availabilityDTO.AvailabilityUpdateDTO;
import com.veterinersistemi.randevu.entity.Availability;
import com.veterinersistemi.randevu.entity.Veterinarian;
import java.util.List;
import java.util.stream.Collectors;

public class AvailabilityMapper {

    // DTO'dan Entity'ye Dönüşüm Metotları
    public static Availability toEntity(AvailabilityCreateDTO createDTO, Veterinarian veterinarian) {
        if (createDTO == null) {
            return null;
        }
        return Availability.builder()
                .appointmentDate(createDTO.getAppointmentDate())
                .startTime(createDTO.getStartTime())
                .endTime(createDTO.getEndTime())
                .veterinarian(veterinarian)
                .build();
    }

    public static Availability toEntity(AvailabilityUpdateDTO updateDTO) {
        if (updateDTO == null) {
            return null;
        }
        Availability availability = new Availability();
        availability.setId(updateDTO.getId());
        availability.setAppointmentDate(updateDTO.getAppointmentDate());
        availability.setStartTime(updateDTO.getStartTime());
        availability.setEndTime(updateDTO.getEndTime());
        return availability;
    }

    // Entity'den DTO'ya Dönüşüm Metotları
    public static AvailabilityFullResponseDTO toFullResponseDTO(Availability availability) {
        if (availability == null) {
            return null;
        }
        return AvailabilityFullResponseDTO.builder()
                .id(availability.getId())
                .appointmentDate(availability.getAppointmentDate())
                .startTime(availability.getStartTime())
                .endTime(availability.getEndTime())
                .veterinarian(VeterinarianMapper.toLimitedResponseDTO(availability.getVeterinarian()))
                .build();
    }

    public static AvailabilityLimitedResponseDTO toLimitedResponseDTO(Availability availability) {
        if (availability == null) {
            return null;
        }
        return AvailabilityLimitedResponseDTO.builder()
                .id(availability.getId())
                .appointmentDate(availability.getAppointmentDate())
                .startTime(availability.getStartTime())
                .endTime(availability.getEndTime())
                .build();
    }

    public static List<AvailabilityFullResponseDTO> toFullResponseDTOList(List<Availability> availabilities) {
        return availabilities.stream()
                .map(AvailabilityMapper::toFullResponseDTO)
                .collect(Collectors.toList());
    }
}