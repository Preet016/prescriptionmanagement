package com.preet.prescriptionmanagement.service;

import com.preet.prescriptionmanagement.dto.PrescriptionDto;
import com.preet.prescriptionmanagement.entity.Patient;
import com.preet.prescriptionmanagement.entity.Prescription;
import com.preet.prescriptionmanagement.exception.InvalidFieldException;
import com.preet.prescriptionmanagement.repository.PatientRepository;
import com.preet.prescriptionmanagement.repository.prescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    private com.preet.prescriptionmanagement.repository.prescriptionRepository prescriptionRepository;

    @Override
    public Prescription create(Long patientId, PrescriptionDto.Create prescription) {

        Optional<Patient> patient = patientRepository.findById(patientId);

        if(!patient.isPresent()) {
            throw new InvalidFieldException("id", "No patient exists with the given id.");
        }

        Prescription newPrescription = Prescription.builder()
                .patient(patient.get())
                .disease(prescription.disease())
                .medicine(prescription.medicine())
                .description(prescription.description())
                .date(LocalDate.now())
                .build();

        prescriptionRepository.save(newPrescription);

        List<Prescription> prescriptionList = patient.get().getPrescriptions();
        prescriptionList.add(newPrescription);

        patientRepository.save(patient.get());

        return newPrescription;

    }

    @Override
    public Prescription get(Long id) {
        return prescriptionRepository.findById(id).orElseThrow(() -> new InvalidFieldException("id", "No prescription found for the given id"));
    }
}
