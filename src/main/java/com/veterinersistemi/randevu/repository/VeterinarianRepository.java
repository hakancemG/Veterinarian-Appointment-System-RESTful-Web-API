package com.veterinersistemi.randevu.repository;

import com.veterinersistemi.randevu.entity.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
}
