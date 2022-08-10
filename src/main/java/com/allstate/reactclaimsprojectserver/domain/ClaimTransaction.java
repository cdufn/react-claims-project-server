package com.allstate.reactclaimsprojectserver.domain;

import javax.persistence.*;

@Entity
@Table(name="claimstransactions")
public class ClaimTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="claimId")
    private Integer claimId;
    private Integer policyNumber;
    private String firstName;
    private String lastName;

    private String claimType;

    @Column(name="claimStatus")
    private String claimStatus;

    public ClaimTransaction() {
    }

    public ClaimTransaction(Integer id, Integer claimId, Integer policyNumber, String firstName, String lastName, String claimType, String claimStatus) {
        this.id = id;
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.claimType = claimType;
        this.claimStatus = claimStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ClaimTransaction{" +
                "id=" + id +
                ", claimId=" + claimId +
                ", policyNumber='" + policyNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName +
                ", claimType='" + claimType + '\'' +
                ", claimStatus=" + claimStatus +
                '}';
    }

}
