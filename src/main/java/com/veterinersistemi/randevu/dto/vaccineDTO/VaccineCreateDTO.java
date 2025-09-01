package com.veterinersistemi.randevu.dto.vaccineDTO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VaccineCreateDTO {

    @NotNull(message = "Hasta ID'si boş bırakılamaz!")
    private Long patientId;

    @NotBlank(message = "Aşı ismi boş bırakılamaz!")
    @Size(min=2, max=40, message = "Aşı ismi 2-40 arasında olmalıdır!")
    private String vaccineName;

    @NotNull(message = "Aşı tarihi boş bırakılamaz!")
    private LocalDate vaccineDate;

    @NotNull(message = "Sıradaki aşı tarihi boş bırakılamaz!")
    @FutureOrPresent(message = "Sıradaki aşı tarihi geçmiş bir tarihte olamaz!")
    private LocalDate nextVaccineDate;
}