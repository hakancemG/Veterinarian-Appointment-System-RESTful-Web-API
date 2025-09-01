package com.veterinersistemi.randevu.service.vaccine;

import com.veterinersistemi.randevu.dto.vaccineDTO.VaccineCreateDTO;
import com.veterinersistemi.randevu.dto.vaccineDTO.VaccineFullResponseDTO;
import com.veterinersistemi.randevu.dto.vaccineDTO.VaccineUpdateDTO;
import com.veterinersistemi.randevu.entity.Patient;
import com.veterinersistemi.randevu.entity.Vaccine;
import com.veterinersistemi.randevu.NotFoundException;
import com.veterinersistemi.randevu.mapper.VaccineMapper;
import com.veterinersistemi.randevu.repository.PatientRepository;
import com.veterinersistemi.randevu.repository.VaccineRepository;
import com.veterinersistemi.randevu.service.vaccine.VaccineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;
    private final PatientRepository patientRepository;

    public VaccineServiceImpl(VaccineRepository vaccineRepository, PatientRepository patientRepository) {
        this.vaccineRepository = vaccineRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public VaccineFullResponseDTO createVaccine(VaccineCreateDTO createDTO) {
        Patient patient = patientRepository.findById(createDTO.getPatientId())
                .orElseThrow(() -> new NotFoundException("Hasta bulunamadı."));

        Vaccine vaccine = VaccineMapper.toEntity(createDTO, patient);
        vaccineRepository.save(vaccine);
        return VaccineMapper.toFullResponseDTO(vaccine);
    }

    @Override
    public VaccineFullResponseDTO updateVaccine(VaccineUpdateDTO updateDTO) {
        Vaccine existingVaccine = vaccineRepository.findById(updateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Aşı kaydı bulunamadı."));

        Patient patient = patientRepository.findById(existingVaccine.getPatient().getId())
                .orElseThrow(() -> new NotFoundException("Aşının hastası bulunamadı."));

        Vaccine updatedVaccine = VaccineMapper.toEntity(updateDTO, patient);
        vaccineRepository.save(updatedVaccine);
        return VaccineMapper.toFullResponseDTO(updatedVaccine);
    }

    @Override
    public void deleteVaccine(Long id) {
        vaccineRepository.deleteById(id);
    }

    @Override
    public VaccineFullResponseDTO getVaccineById(Long id) {
        Vaccine vaccine = vaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Aşı kaydı bulunamadı."));
        return VaccineMapper.toFullResponseDTO(vaccine);
    }

    @Override
    public List<VaccineFullResponseDTO> getVaccinesByPatientId(Long patientId) {
        List<Vaccine> vaccines = vaccineRepository.findByPatientId(patientId);
        return vaccines.stream()
                .map(VaccineMapper::toFullResponseDTO)
                .collect(Collectors.toList());
    }
}