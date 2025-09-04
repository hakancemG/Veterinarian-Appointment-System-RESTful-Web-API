package com.veterinersistemi.randevu.repository;

import com.veterinersistemi.randevu.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDateAndVeterinarianId(LocalDateTime date, Long veterinarianId);
}
