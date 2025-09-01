package com.veterinersistemi.randevu.mapper;

import com.veterinersistemi.randevu.dto.customerDTO.CustomerCreateDTO;
import com.veterinersistemi.randevu.dto.customerDTO.CustomerFullResponseDTO;
import com.veterinersistemi.randevu.dto.customerDTO.CustomerLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.customerDTO.CustomerUpdateDTO;
import com.veterinersistemi.randevu.entity.Customer;

public class CustomerMapper {

    // DTO'dan Entity'ye Dönüşüm Metotları
    public static Customer toEntity(CustomerCreateDTO customerCreateDTO) {
        if (customerCreateDTO == null) {
            return null;
        }
        return Customer.builder()
                .firstName(customerCreateDTO.getFirstName())
                .lastName(customerCreateDTO.getLastName())
                .phone(customerCreateDTO.getPhone())
                .email(customerCreateDTO.getEmail())
                .build();
    }

    public static Customer toEntity(CustomerUpdateDTO customerUpdateDTO) {
        if (customerUpdateDTO == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(customerUpdateDTO.getId());
        customer.setFirstName(customerUpdateDTO.getFirstName());
        customer.setLastName(customerUpdateDTO.getLastName());
        customer.setPhone(customerUpdateDTO.getPhone());
        customer.setEmail(customerUpdateDTO.getEmail());
        return customer;
    }

    // Entity'den DTO'ya Dönüşüm Metotları
    public static CustomerFullResponseDTO toFullResponseDTO(Customer customer) {
        if (customer == null) {
            return null;
        }
        return CustomerFullResponseDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .build();
    }

    public static CustomerLimitedResponseDTO toLimitedResponseDTO(Customer customer) {
        if (customer == null) {
            return null;
        }
        return CustomerLimitedResponseDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }
}