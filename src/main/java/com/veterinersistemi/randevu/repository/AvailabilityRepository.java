package com.veterinersistemi.randevu.repository;

import com.veterinersistemi.randevu.entity.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByVeterinarianIdAndAppointmentDate(Long veterinarianId, LocalDate appointmentDate);
}
