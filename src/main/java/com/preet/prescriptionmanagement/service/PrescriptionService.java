package com.preet.prescriptionmanagement.service;

import com.preet.prescriptionmanagement.dto.PrescriptionDto;
import com.preet.prescriptionmanagement.entity.Prescription;

public interface PrescriptionService {
    Prescription create(Long patientId, PrescriptionDto.Create prescription);

    Prescription get(Long id);
}
