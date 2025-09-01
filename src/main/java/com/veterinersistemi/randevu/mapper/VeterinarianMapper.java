package com.veterinersistemi.randevu.mapper;

import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianCreateDTO;
import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianFullResponseDTO;
import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.veterinarianDTO.VeterinarianUpdateDTO;
import com.veterinersistemi.randevu.entity.Veterinarian;
import java.util.List;
import java.util.stream.Collectors;

public class VeterinarianMapper {

    // DTO'dan Entity'ye Dönüşüm Metotları
    public static Veterinarian toEntity(VeterinarianCreateDTO veterinarianCreateDTO) {
        if (veterinarianCreateDTO == null) {
            return null;
        }
        return Veterinarian.builder()
                .firstName(veterinarianCreateDTO.getFirstName())
                .lastName(veterinarianCreateDTO.getLastName())
                .build();
    }

    public static Veterinarian toEntity(VeterinarianUpdateDTO veterinarianUpdateDTO) {
        if (veterinarianUpdateDTO == null) {
            return null;
        }
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.setId(veterinarianUpdateDTO.getId());
        veterinarian.setFirstName(veterinarianUpdateDTO.getFirstName());
        veterinarian.setLastName(veterinarianUpdateDTO.getLastName());
        return veterinarian;
    }

    // Entity'den DTO'ya Dönüşüm Metotları
    public static VeterinarianFullResponseDTO toFullResponseDTO(Veterinarian veterinarian) {
        if (veterinarian == null) {
            return null;
        }
        return VeterinarianFullResponseDTO.builder()
                .id(veterinarian.getId())
                .firstName(veterinarian.getFirstName())
                .lastName(veterinarian.getLastName())
                .build();
    }

    public static VeterinarianLimitedResponseDTO toLimitedResponseDTO(Veterinarian veterinarian) {
        if (veterinarian == null) {
            return null;
        }
        return VeterinarianLimitedResponseDTO.builder()
                .id(veterinarian.getId())
                .firstName(veterinarian.getFirstName())
                .lastName(veterinarian.getLastName())
                .build();
    }

    // Entity Listesinden DTO Listesine Dönüşüm Metotları
    public static List<VeterinarianLimitedResponseDTO> toLimitedResponseDTOList(List<Veterinarian> veterinarians) {
        return veterinarians.stream()
                .map(VeterinarianMapper::toLimitedResponseDTO)
                .collect(Collectors.toList());
    }
}