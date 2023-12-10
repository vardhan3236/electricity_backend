package com.electricity.connectionservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionDTO {


    private Long id;

    private String applicantName;

    private String gender;

    private String district;

    private String state;

    private String pincode;

    private String ownership;

    private String govtIdType;

    private String idNumber;

    private String category;

    private Integer loadApplied;

    private LocalDate dateOfApplication;

    private LocalDate dateOfApproval;

    private LocalDate modifiedDate;

    private String status;

    private Integer reviewerId;

    private String reviewerName;

    private String reviewerComments;
}
