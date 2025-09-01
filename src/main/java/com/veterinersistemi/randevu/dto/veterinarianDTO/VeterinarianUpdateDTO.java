package com.veterinersistemi.randevu.dto.veterinarianDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterinarianUpdateDTO {

    @NotNull(message = "ID boş bırakılamaz!")
    private Long id;

    @NotBlank(message = "İsim boş bırakılamaz!")
    @Size(min=3, max=20, message = "İsim, 3-20 karakter arasında olmalıdır!")
    private String firstName;

    @NotBlank(message = "Soy isim boş bırakılamaz!")
    @Size(min=2, max=20, message = "Soyisim, 2-20 karakter arasında olmalıdır!")
    private String lastName;
}