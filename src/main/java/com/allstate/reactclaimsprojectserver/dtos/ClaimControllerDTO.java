package com.allstate.reactclaimsprojectserver.dtos;

import com.allstate.reactclaimsprojectserver.domain.ClaimTransaction;

import java.time.LocalDate;

public class ClaimControllerDTO {

    private Integer claimId;
    private Integer policyNumber;
    private String firstName;
    private String lastName;
    private String claimType;
    private String claimStatus;

    public ClaimControllerDTO() {
    }

    public ClaimControllerDTO(ClaimTransaction claimTable) {
        this.claimId = claimTable.getClaimId();
        this.policyNumber = claimTable.getPolicyNumber();
        this.firstName = claimTable.getFirstName();
        this.lastName = claimTable.getLastName();
        this.claimType = claimTable.getClaimType();
        this.claimStatus = claimTable.getClaimStatus();
    }
    public ClaimTransaction toClaimTransaction() {

        ClaimTransaction claimTable = new ClaimTransaction(null,claimId,policyNumber,firstName,
                lastName, claimType, claimStatus);
        if (claimStatus.toLowerCase().equals("New")) {
            claimTable.setClaimStatus("Accepted");

        }

        return claimTable;
    }

    public Integer getClaimId() {
        return claimId;
    }

    public void setClaimId(Integer claimId) {
        this.claimId = claimId;
    }

    public Integer getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Integer policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }
}
