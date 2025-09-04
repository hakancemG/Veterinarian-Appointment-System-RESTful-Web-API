package com.veterinersistemi.randevu.repository;

import com.veterinersistemi.randevu.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
