package com.preet.prescriptionmanagement.service;

import com.preet.prescriptionmanagement.dto.PatientDto;
import com.preet.prescriptionmanagement.entity.Patient;
import com.preet.prescriptionmanagement.exception.InvalidFieldException;
import com.preet.prescriptionmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient register(PatientDto.Create patient) {

        if(patient.emailId() != null && patientRepository.findByEmailId(patient.emailId()).isPresent()) {
            throw new InvalidFieldException("emailId", "A patient with this email id already exists");
        }

        Patient newPatient = Patient.builder()
                .emailId(patient.emailId())
                .firstName(patient.firstName())
                .lastName(patient.lastName())
                .placeOfBirth(patient.placeOfBirth())
                .build();

        return patientRepository.save(newPatient);

    }

    @Override
    public Patient get(Long id) {
       return patientRepository.findById(id).orElseThrow(() -> new InvalidFieldException("id", "No patient exists with the given id."));
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

}
