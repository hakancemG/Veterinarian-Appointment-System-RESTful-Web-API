package com.veterinersistemi.randevu.dto.customerDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerUpdateDTO {

    private Long id;

    @NotBlank(message = "İsim boş bırakılamaz!")
    @Size(min=3, max=20, message = "İsim, 3-20 karakter arasında olmalıdır!")
    private String firstName;

    @NotBlank(message = "Soy isim boş bırakılamaz!")
    @Size(min=2, max=20, message = "Soyisim, 2-20 karakter arasında olmalıdır!")
    private String lastName;

    @Pattern(regexp = "^[0-9]{10,11}$", message = "Geçerli bir telefon numarası giriniz!")
    private String phone;

    @Email(message = "Geçerli bir email giriniz!")
    @NotBlank(message = "E-mail alanı boş bırakılamaz!")
    private String email;
}
