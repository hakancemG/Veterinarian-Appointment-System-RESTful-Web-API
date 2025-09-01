package com.veterinersistemi.randevu.dto.veterinarianDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterinarianFullResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
}