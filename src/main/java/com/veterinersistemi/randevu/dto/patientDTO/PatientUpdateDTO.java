package com.veterinersistemi.randevu.dto.patientDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientUpdateDTO {

    @NotNull(message = "ID boş bırakılamaz!")
    private Long id;

    @NotBlank(message = "Hasta hayvanın ismi alanı boş bırakılamaz!")
    private String patientName;

    @NotBlank(message = "Hasta hayvanın türü alanı boş bırakılamaz!")
    private String species;

    @NotBlank(message = "Hasta hayvanın cinsi alanı boş bırakılamaz!")
    private String breed;

    @NotNull(message = "Doğum tarihi boş bırakılamaz!")
    @PastOrPresent(message = "Doğum tarihi bugünden sonra olamaz!")
    private LocalDate dateOfBirth;
}
