package com.veterinersistemi.randevu.dto.customerDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerLimitedResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
}