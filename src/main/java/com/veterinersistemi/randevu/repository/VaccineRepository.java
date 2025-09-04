package com.veterinersistemi.randevu.repository;

import com.veterinersistemi.randevu.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findByPatientId(Long patientId);
}
