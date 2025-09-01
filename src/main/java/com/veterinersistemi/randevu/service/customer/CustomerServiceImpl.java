package com.veterinersistemi.randevu.service.customer;

import com.veterinersistemi.randevu.dto.customerDTO.CustomerCreateDTO;
import com.veterinersistemi.randevu.dto.customerDTO.CustomerFullResponseDTO;
import com.veterinersistemi.randevu.dto.customerDTO.CustomerLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.customerDTO.CustomerUpdateDTO;
import com.veterinersistemi.randevu.entity.Customer;
import com.veterinersistemi.randevu.NotFoundException;
import com.veterinersistemi.randevu.mapper.CustomerMapper;
import com.veterinersistemi.randevu.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerFullResponseDTO createCustomer(CustomerCreateDTO customerCreateDTO) {
        Customer customer = CustomerMapper.toEntity(customerCreateDTO);
        customerRepository.save(customer);
        return CustomerMapper.toFullResponseDTO(customer);
    }

    @Override
    public CustomerFullResponseDTO updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        Customer existingCustomer = customerRepository.findById(customerUpdateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Müşteri bulunamadı"));
        Customer updatedCustomer = CustomerMapper.toEntity(customerUpdateDTO);
        updatedCustomer.setCreatedAt(existingCustomer.getCreatedAt());
        customerRepository.save(updatedCustomer);
        return CustomerMapper.toFullResponseDTO(updatedCustomer);
    }

    @Override
    public CustomerFullResponseDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Müşteri bulunamadı"));
        return CustomerMapper.toFullResponseDTO(customer);
    }

    @Override
    public List<CustomerLimitedResponseDTO> getAllCustomersLimited() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerMapper::toLimitedResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerFullResponseDTO> getAllCustomersFull() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerMapper::toFullResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}