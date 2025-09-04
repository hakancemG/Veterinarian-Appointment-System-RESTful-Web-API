package com.veterinersistemi.randevu.repository;

import com.veterinersistemi.randevu.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
