package com.electricity.connectionservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "electricity_data1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Applicant_Name")
    private String applicantName;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "District")
    private String district;

    @Column(name = "State")
    private String state;

    @Column(name = "Pincode")
    private String pincode;

    @Column(name = "Ownership")
    private String ownership;

    @Column(name = "GovtID_Type")
    private String govtIdType;

    @Column(name = "ID_Number")
    private String idNumber;

    @Column(name = "Category")
    private String category;

    @Column(name = "Load_Applied")
    private Integer loadApplied;

    @Column(name = "Date_of_Application")
    private LocalDate dateOfApplication;

    @Column(name = "Date_of_Approval")
    private LocalDate dateOfApproval;

    @Column(name = "Modified_Date")
    private LocalDate modifiedDate;

    @Column(name = "Status")
    private String status;

    @Column(name = "Reviewer_ID")
    private Integer reviewerId;

    @Column(name = "Reviewer_Name")
    private String reviewerName;

    @Column(name = "Reviewer_Comments")
    private String reviewerComments;

}
