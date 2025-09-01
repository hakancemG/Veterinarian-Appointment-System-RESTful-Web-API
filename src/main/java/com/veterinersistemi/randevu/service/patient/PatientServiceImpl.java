package com.veterinersistemi.randevu.service.patient;

import com.veterinersistemi.randevu.dto.patientDTO.PatientCreateDTO;
import com.veterinersistemi.randevu.dto.patientDTO.PatientFullResponseDTO;
import com.veterinersistemi.randevu.dto.patientDTO.PatientLimitedResponseDTO;
import com.veterinersistemi.randevu.dto.patientDTO.PatientUpdateDTO;
import com.veterinersistemi.randevu.entity.Customer;
import com.veterinersistemi.randevu.entity.Patient;
import com.veterinersistemi.randevu.NotFoundException;
import com.veterinersistemi.randevu.mapper.PatientMapper;
import com.veterinersistemi.randevu.repository.CustomerRepository;
import com.veterinersistemi.randevu.repository.PatientRepository;
import com.veterinersistemi.randevu.service.patient.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final CustomerRepository customerRepository;

    public PatientServiceImpl(PatientRepository patientRepository, CustomerRepository customerRepository) {
        this.patientRepository = patientRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public PatientFullResponseDTO createPatient(PatientCreateDTO patientCreateDTO) {
        Customer owner = customerRepository.findById(patientCreateDTO.getOwnerId())
                .orElseThrow(() -> new NotFoundException("Sahibi bulunamadı"));

        Patient patient = PatientMapper.toEntity(patientCreateDTO, owner);
        patientRepository.save(patient);
        return PatientMapper.toFullResponseDTO(patient);
    }

    @Override
    public PatientFullResponseDTO updatePatient(PatientUpdateDTO patientUpdateDTO) {
        Patient existingPatient = patientRepository.findById(patientUpdateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Hasta bulunamadı"));

        Patient updatedPatient = PatientMapper.toEntity(patientUpdateDTO, existingPatient);
        patientRepository.save(updatedPatient);
        return PatientMapper.toFullResponseDTO(updatedPatient);
    }

    @Override
    public PatientFullResponseDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hasta bulunamadı"));
        return PatientMapper.toFullResponseDTO(patient);
    }

    @Override
    public List<PatientLimitedResponseDTO> getAllPatientsLimited() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::toLimitedResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientFullResponseDTO> getAllPatientsFull() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::toFullResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}