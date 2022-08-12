package com.allstate.reactclaimsprojectserver.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="claimstransactions")
public class ClaimTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="claimId")
    private String claimId;
    @Column(name="policyNumber")
    private String policyNumber;
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    private LocalDate claimDate;
    private String claimType;
    @Column(name="claimStatus")
    private String claimStatus;
    private String costOfClaim;
    private String claimReason;
    private String description;
    private String city;
    private String street;
    private String zip;
    private String makeOfVehicle;
    private String modelOfVehicle;
    private String yearOfVehicle;
    private String petType;
    private String petBreed;
    private Date dateOfEvent;
    private String eventDetails;

    public ClaimTransaction() {
    }

    public ClaimTransaction(Integer id, String claimId, String policyNumber, String firstName, String lastName, LocalDate claimDate,  String claimType, String claimStatus, String costOfClaim, String claimReason, String description, String city, String street, String zip, String makeOfVehicle, String modelOfVehicle, String yearOfVehicle, String petType, String petBreed, Date dateOfEvent, String eventDetails) {
        this.id = id;
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.claimDate = claimDate;
        this.claimType = claimType;
        this.claimStatus = claimStatus;
        this.costOfClaim = costOfClaim;
        this.claimReason = claimReason;
        this.description = description;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.makeOfVehicle = makeOfVehicle;
        this.modelOfVehicle = modelOfVehicle;
        this.yearOfVehicle = yearOfVehicle;
        this.petType = petType;
        this.petBreed = petBreed;
        this.dateOfEvent = dateOfEvent;
        this.eventDetails = eventDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
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

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
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

    public String getCostOfClaim() {
        return costOfClaim;
    }

    public void setCostOfClaim(String costOfClaim) {
        this.costOfClaim = costOfClaim;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getMakeOfVehicle() {
        return makeOfVehicle;
    }

    public void setMakeOfVehicle(String makeOfVehicle) {
        this.makeOfVehicle = makeOfVehicle;
    }

    public String getModelOfVehicle() {
        return modelOfVehicle;
    }

    public void setModelOfVehicle(String modelOfVehicle) {
        this.modelOfVehicle = modelOfVehicle;
    }

    public String getYearOfVehicle() {
        return yearOfVehicle;
    }

    public void setYearOfVehicle(String yearOfVehicle) {
        this.yearOfVehicle = yearOfVehicle;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public Date getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(Date dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }


    @Override
    public String toString() {
        return "ClaimTransaction{" +
                "id=" + id +
                ", claimId=" + claimId + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName + '\'' +
                ", claimDate=" + claimDate +
                ", claimType='" + claimType + '\'' +
                ", claimStatus=" + claimStatus + '\'' +
                ", costOfClaim=" + costOfClaim + '\'' +
                ", claimReason=" + claimReason + '\'' +
                ", description=" + description + '\'' +
                ", city='" + city + '\'' +
                ", street=" + street + '\'' +
                ", zip=" + zip + '\'' +
                ", makeOfVehicle=" + makeOfVehicle + '\'' +
                ", modelOfVehicle=" + modelOfVehicle + '\'' +
                ", yearOfVehicle=" + yearOfVehicle + '\'' +
                ", petType=" + petType + '\'' +
                ", petBreed=" + petBreed + '\'' +
                ", dateOfEvent='" + dateOfEvent + '\'' +
                ", eventDetails=" + eventDetails + '\'' +
                '}';
    }
}
