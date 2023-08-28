package com.preet.prescriptionmanagement.service;

import com.preet.prescriptionmanagement.dto.PatientDto;
import com.preet.prescriptionmanagement.entity.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    Patient register(PatientDto.Create patient);

    Patient get(Long id);

    List<Patient> getAll();
}
