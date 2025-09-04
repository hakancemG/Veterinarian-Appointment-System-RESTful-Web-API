Proje Adı: Otel Yönetim ve Rezervasyon Sistemi
___________________________________________________________________________________
Proje Sahibi: Hakan Cem GERÇEK.
___________________________________________________________________________________
Proje Başlama Tarihi: 30.08.2025
___________________________________________________________________________________
Proje Bitirme Tarihi: 21.08.2025
___________________________________________________________________________________
Yapı: RESTFul Web API.
___________________________________________________________________________________
Dil: Java 24
___________________________________________________________________________________
Teknolojiler: 
  + Spring Framework 6 / Spring Boot 3.5.5, 
  + Maven
___________________________________________________________________________________
Amaç: Hasta hayvanı olan birinin, bir veteriner kliniğinden tedavi/muayene için randevu alabileceği bir API tasarımı.
___________________________________________________________________________________
Dependency'ler: 
  + Spring Web
  + Spring Data JPA
  + Lombok
  + Validations
  + Spring DevTools
  + MySQL
  + H2
___________________________________________________________________________________
Proje Paket Şeması:
+ src
+ main
  + java
    + com.otelyonetim.rezervasyon
      + controller
        - AppointmentController
        - AvailabilityController
        - CustomerController
        - PatientController
        - VaccineController
        - VeterinarianController
      + dto
        + AppointmentDTO
          - AppointmentCreateDTO
          - AppointmentFullResponseDTO
          - AppointmentLimitedResponseDTO
          - AppointmentUpdateDTO
        + AvailabilityDTO
          - AvailabilityCreateDTO
          - AvailabilityFullResponseDTO
          - AvailabilityLimitedResponseDTO
          - AvailabilityUpdateDTO
        + CustomerDTO
          - CustomerCreateDTO
          - CustomerFullResponseDTO
          - CustomerLimitedResponseDTO
          - CustomerUpdateDTO
        + VaccineDTO
          - VaccineCreateDTO
          - VaccineFullResponseDTO
          - VaccineLimitedResponseDTO
          - VaccineUpdateDTO
        + VeterinarianDTO
          - VeterinarianCreateDTO
          - VeterinarianFullResponseDTO
          - VeterinarianLimitedResponseDTO
          - VeterinarianUpdateDTO
      + entity
          - Appointment
          - Availability
          - Customer
          - Patient
          - Vaccine
          - Veterinarian
      + enums
        - AppointmentStatus
      + handler
        - GlobalExceptionHandler
      + Mapper
        - AppointmentMapper
        - AvailabilityMapper
        - CustomerMapper
        - PatientMapper
        - VaccineMapper
        - VeterinarianMapper
      + repository
        - AppointmentRepository
        - AvailabilityRepository
        - CustomerRepository
        - PatientRepository
        - VaccineRepository
        - VeterinarianRepository
      + service
        + appointment
          - AppointmentService
          - AppointmentServiceImpl
        + availability
          - AvailabilityService
          - AvailabilityServiceImpl
        + customer
          - CustomerService
          - CustomerServiceImpl
        + patient
          - PatientService
          - PatientServiceImpl
        + vaccine
          - VaccineService
          - VaccineServiceImpl
        + veterinarian
          - VeterinarianService
          - VeterinarianServiceImpl
      - AppRun.java
______________________________________________________________________________________________________________________________________________________________________
+ Test için gerekli end pointler ve JSON verileri:

POST --> .../api/v1/customers

```json
{
  "firstName": "Ali",
  "lastName": "Veli",
  "phone": "5551112234",
  "email": "ali.veli@example.com"
}
```


POST --> .../api/v1/patients

```json
{
  "patientName": "Boncuk",
  "species": "Kedi",
  "breed": "British Shorthair",
  "gender": "Erkek",
  "color": "Beyaz",
  "dateOfBirth": "2024-03-10",
  "ownerId": 1
}
```

POST --> .../api/v1/veterinarians

```json
{
  "firstName": "Ayşe",
  "lastName": "Yılmaz"
}
```

POST --> .../api/v1/appointments

```json
{
  "date": "2025-12-01T10:30:00",
  "customerId": 1,
  "patientId": 1,
  "veterinarianId": 1
}
```
______________________________________________________________________________________________________________________________________________________________________
iletişim: hakancg05@gmail.com
