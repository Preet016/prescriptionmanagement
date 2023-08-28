package com.preet.prescriptionmanagement.repository;

import com.preet.prescriptionmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmailId(String emailId);
}
