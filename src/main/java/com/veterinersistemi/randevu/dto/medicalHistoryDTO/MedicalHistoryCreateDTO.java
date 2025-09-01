package com.veterinersistemi.randevu.dto.medicalHistoryDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalHistoryCreateDTO {

    @NotNull(message = "Hasta ID'si boş bırakılamaz!")
    private Long patientId;

    @NotNull(message = "Veteriner ID'si boş bırakılamaz!")
    private Long veterinarianId;

    @NotNull(message = "Tarih boş bırakılamaz!")
    @PastOrPresent(message = "Hasta tedavi tarihi gelecek bir zamanda olamaz!")
    private LocalDateTime medicalDate;

    private String note;

    @NotBlank(message = "Teşhis boş bırakılamaz!")
    @Size(min=2, max=50, message = "Teşhis kısmı 2-50 karakter arasında olmalıdır!")
    private String diagnosis;

    @NotBlank(message = "Tedavi boş bırakılamaz!")
    @Size(min=2, max=100, message = "Tedavi kısmı 2-100 karakter arasında olmalıdır!")
    private String treatment;
}