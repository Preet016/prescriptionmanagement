package com.preet.prescriptionmanagement.repository;

import com.preet.prescriptionmanagement.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface prescriptionRepository extends JpaRepository<Prescription, Long> {
}
