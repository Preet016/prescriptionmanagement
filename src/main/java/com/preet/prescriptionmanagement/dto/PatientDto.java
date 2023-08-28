package com.preet.prescriptionmanagement.dto;

import javax.persistence.Column;

public class PatientDto{
    public record Create (
            String emailId,

            String firstName,

            String lastName,

            String placeOfBirth
    ) { }
}
