package com.preet.prescriptionmanagement.dto;

import java.time.LocalDate;

public class PrescriptionDto {
    public record Create(

            String disease,

            String medicine,

            LocalDate date,

            String description
    ) { }
}
