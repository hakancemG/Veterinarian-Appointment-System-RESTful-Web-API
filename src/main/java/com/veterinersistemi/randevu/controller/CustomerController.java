package com.veterinersistemi.randevu.controller;

import com.veterinersistemi.randevu.dto.customerDTO.CustomerCreateDTO;
import com.veterinersistemi.randevu.dto.customerDTO.CustomerFullResponseDTO;
import com.veterinersistemi.randevu.dto.customerDTO.CustomerLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.customerDTO.CustomerUpdateDTO;
import com.veterinersistemi.randevu.service.customer.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerFullResponseDTO> createCustomer(@Valid @RequestBody CustomerCreateDTO customerCreateDTO) {
        CustomerFullResponseDTO createdCustomer = customerService.createCustomer(customerCreateDTO);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerFullResponseDTO> updateCustomer(@Valid @RequestBody CustomerUpdateDTO customerUpdateDTO) {
        CustomerFullResponseDTO updatedCustomer = customerService.updateCustomer(customerUpdateDTO);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerFullResponseDTO> getCustomerById(@PathVariable Long id) {
        CustomerFullResponseDTO customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/limited")
    public ResponseEntity<List<CustomerLimitedResponseDTO>> getAllCustomersLimited() {
        List<CustomerLimitedResponseDTO> customers = customerService.getAllCustomersLimited();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/full")
    public ResponseEntity<List<CustomerFullResponseDTO>> getAllCustomersFull() {
        List<CustomerFullResponseDTO> customers = customerService.getAllCustomersFull();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}