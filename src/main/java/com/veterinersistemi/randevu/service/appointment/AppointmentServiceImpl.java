package com.veterinersistemi.randevu.service.appointment;

import com.veterinersistemi.randevu.dto.appointmentDTO.AppointmentCreateDTO;
import com.veterinersistemi.randevu.dto.appointmentDTO.AppointmentFullResponseDTO;
import com.veterinersistemi.randevu.dto.appointmentDTO.AppointmentUpdateDTO;
import com.veterinersistemi.randevu.entity.Appointment;
import com.veterinersistemi.randevu.entity.Customer;
import com.veterinersistemi.randevu.entity.Patient;
import com.veterinersistemi.randevu.entity.Veterinarian;
import com.veterinersistemi.randevu.NotFoundException;
import com.veterinersistemi.randevu.mapper.AppointmentMapper;
import com.veterinersistemi.randevu.repository.AppointmentRepository;
import com.veterinersistemi.randevu.repository.CustomerRepository;
import com.veterinersistemi.randevu.repository.PatientRepository;
import com.veterinersistemi.randevu.repository.VeterinarianRepository;
import com.veterinersistemi.randevu.service.appointment.AppointmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CustomerRepository customerRepository;
    private final PatientRepository patientRepository;
    private final VeterinarianRepository veterinarianRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  CustomerRepository customerRepository,
                                  PatientRepository patientRepository,
                                  VeterinarianRepository veterinarianRepository) {
        this.appointmentRepository = appointmentRepository;
        this.customerRepository = customerRepository;
        this.patientRepository = patientRepository;
        this.veterinarianRepository = veterinarianRepository;
    }

    @Override
    public AppointmentFullResponseDTO createAppointment(AppointmentCreateDTO createDTO) {
        Customer customer = customerRepository.findById(createDTO.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Müşteri bulunamadı."));
        Patient patient = patientRepository.findById(createDTO.getPatientId())
                .orElseThrow(() -> new NotFoundException("Hasta bulunamadı."));
        Veterinarian veterinarian = veterinarianRepository.findById(createDTO.getVeterinarianId())
                .orElseThrow(() -> new NotFoundException("Veteriner bulunamadı."));

        Appointment appointment = AppointmentMapper.toEntity(createDTO, customer, patient, veterinarian);
        appointmentRepository.save(appointment);
        return AppointmentMapper.toFullResponseDTO(appointment);
    }

    @Override
    public AppointmentFullResponseDTO updateAppointment(AppointmentUpdateDTO updateDTO) {
        Appointment existingAppointment = appointmentRepository.findById(updateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Randevu bulunamadı."));

        Appointment updatedAppointment = AppointmentMapper.toEntityForUpdate(updateDTO, existingAppointment);
        appointmentRepository.save(updatedAppointment);
        return AppointmentMapper.toFullResponseDTO(updatedAppointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public AppointmentFullResponseDTO getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Randevu bulunamadı."));
        return AppointmentMapper.toFullResponseDTO(appointment);
    }

    @Override
    public List<AppointmentFullResponseDTO> getAppointmentsByDateAndVeterinarianId(LocalDate date, Long veterinarianId) {
        List<Appointment> appointments = appointmentRepository.findByDateAndVeterinarianId(date.atStartOfDay(), veterinarianId);
        return AppointmentMapper.toFullResponseDTOList(appointments);
    }
}