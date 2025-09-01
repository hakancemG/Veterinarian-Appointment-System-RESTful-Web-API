package com.veterinersistemi.randevu.service.customer;

import com.veterinersistemi.randevu.dto.customerDTO.CustomerCreateDTO;
import com.veterinersistemi.randevu.dto.customerDTO.CustomerFullResponseDTO;
import com.veterinersistemi.randevu.dto.customerDTO.CustomerLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.customerDTO.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    CustomerFullResponseDTO createCustomer(CustomerCreateDTO customerCreateDTO);

    CustomerFullResponseDTO updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerFullResponseDTO getCustomerById(Long id);

    List<CustomerLimitedResponseDTO> getAllCustomersLimited();

    List<CustomerFullResponseDTO> getAllCustomersFull();

    void deleteCustomer(Long id);
}