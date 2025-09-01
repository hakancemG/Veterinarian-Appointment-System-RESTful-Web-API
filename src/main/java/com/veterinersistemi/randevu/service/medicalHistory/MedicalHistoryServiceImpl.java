package com.veterinersistemi.randevu.service.medicalHistory;

import com.veterinersistemi.randevu.dto.medicalHistoryDTO.MedicalHistoryCreateDTO;
import com.veterinersistemi.randevu.dto.medicalHistoryDTO.MedicalHistoryFullResponseDTO;
import com.veterinersistemi.randevu.dto.medicalHistoryDTO.MedicalHistoryUpdateDTO;
import com.veterinersistemi.randevu.entity.MedicalHistory;
import com.veterinersistemi.randevu.entity.Patient;
import com.veterinersistemi.randevu.entity.Veterinarian;
import com.veterinersistemi.randevu.NotFoundException;
import com.veterinersistemi.randevu.mapper.MedicalHistoryMapper;
import com.veterinersistemi.randevu.repository.MedicalHistoryRepository;
import com.veterinersistemi.randevu.repository.PatientRepository;
import com.veterinersistemi.randevu.repository.VeterinarianRepository;
import com.veterinersistemi.randevu.service.medicalHistory.MedicalHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    private final MedicalHistoryRepository medicalHistoryRepository;
    private final PatientRepository patientRepository;
    private final VeterinarianRepository veterinarianRepository;

    public MedicalHistoryServiceImpl(
            MedicalHistoryRepository medicalHistoryRepository,
            PatientRepository patientRepository,
            VeterinarianRepository veterinarianRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
        this.patientRepository = patientRepository;
        this.veterinarianRepository = veterinarianRepository;
    }

    @Override
    public MedicalHistoryFullResponseDTO createMedicalHistory(MedicalHistoryCreateDTO createDTO) {
        Patient patient = patientRepository.findById(createDTO.getPatientId())
                .orElseThrow(() -> new NotFoundException("Hasta bulunamadı."));
        Veterinarian veterinarian = veterinarianRepository.findById(createDTO.getVeterinarianId())
                .orElseThrow(() -> new NotFoundException("Veteriner bulunamadı."));

        MedicalHistory medicalHistory = MedicalHistoryMapper.toEntity(createDTO, patient, veterinarian);
        medicalHistoryRepository.save(medicalHistory);
        return MedicalHistoryMapper.toFullResponseDTO(medicalHistory);
    }

    @Override
    public MedicalHistoryFullResponseDTO updateMedicalHistory(MedicalHistoryUpdateDTO updateDTO) {
        MedicalHistory existingMedicalHistory = medicalHistoryRepository.findById(updateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Hasta geçmişi kaydı bulunamadı."));

        MedicalHistory updatedMedicalHistory = MedicalHistoryMapper.toEntity(
                updateDTO,
                existingMedicalHistory.getPatient(),
                existingMedicalHistory.getVeterinarian()
        );
        medicalHistoryRepository.save(updatedMedicalHistory);
        return MedicalHistoryMapper.toFullResponseDTO(updatedMedicalHistory);
    }

    @Override
    public void deleteMedicalHistory(Long id) {
        medicalHistoryRepository.deleteById(id);
    }

    @Override
    public MedicalHistoryFullResponseDTO getMedicalHistoryById(Long id) {
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hasta geçmişi kaydı bulunamadı."));
        return MedicalHistoryMapper.toFullResponseDTO(medicalHistory);
    }

    @Override
    public List<MedicalHistoryFullResponseDTO> getMedicalHistoriesByPatientId(Long patientId) {
        List<MedicalHistory> medicalHistories = medicalHistoryRepository.findByPatientId(patientId);
        return medicalHistories.stream()
                .map(MedicalHistoryMapper::toFullResponseDTO)
                .collect(Collectors.toList());
    }
}