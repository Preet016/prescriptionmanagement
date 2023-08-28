package com.preet.prescriptionmanagement.controller;

import com.preet.prescriptionmanagement.dto.PatientDto;
import com.preet.prescriptionmanagement.dto.PrescriptionDto;
import com.preet.prescriptionmanagement.entity.Patient;
import com.preet.prescriptionmanagement.entity.Prescription;
import com.preet.prescriptionmanagement.service.PatientService;
import com.preet.prescriptionmanagement.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    PrescriptionService prescriptionService;

    @PostMapping("/patients/register")
    public ResponseEntity<Patient> register(@RequestBody PatientDto.Create patient) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.register(patient));
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.get(id));
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getPatient() {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getAll());
    }

    @PostMapping("/patients/{id}/prescriptions")
    public ResponseEntity<Prescription> register(@PathVariable Long id, @RequestBody PrescriptionDto.Create prescription) {
        return ResponseEntity.status(HttpStatus.CREATED).body(prescriptionService.create(id, prescription));
    }

    @GetMapping("/prescriptions/{id}")
    public ResponseEntity<Prescription> getPrescription(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(prescriptionService.get(id));
    }
}
