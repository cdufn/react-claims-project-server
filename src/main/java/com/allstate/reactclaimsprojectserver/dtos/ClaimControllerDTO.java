package com.allstate.reactclaimsprojectserver.dtos;

import com.allstate.reactclaimsprojectserver.domain.ClaimTransaction;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

public class ClaimControllerDTO {

     String claimId;
     String policyNumber;
     String firstName;
     String lastName;
     LocalDate claimDate;
     String claimType;
     String claimStatus;
     String costOfClaim;
     String claimReason;
     String description;
     String city;
     String street;
     String zip;
     String makeOfVehicle;
     String modelOfVehicle;
     String yearOfVehicle;
     String petType;
     String petBreed;
     LocalDate dateOfEvent;
     String eventDetails;

    public ClaimControllerDTO() {
    }

    public ClaimControllerDTO(ClaimTransaction claimTable) {
        this.claimId = claimTable.getClaimId();
        this.policyNumber = claimTable.getPolicyNumber();
        this.firstName = claimTable.getFirstName();
        this.lastName = claimTable.getLastName();
        this.claimDate = claimTable.getClaimDate();
        this.claimType = claimTable.getClaimType();
        this.claimStatus = claimTable.getClaimStatus();
        this.costOfClaim = claimTable.getCostOfClaim();
        this.claimReason = claimTable.getClaimReason();
        this.description = claimTable.getDescription();
        this.city = claimTable.getCity();
        this.street = claimTable.getStreet();
        this.zip = claimTable.getZip();
        this.makeOfVehicle = claimTable.getMakeOfVehicle();
        this.modelOfVehicle = claimTable.getModelOfVehicle();
        this.yearOfVehicle = claimTable.getYearOfVehicle();
        this.petType = claimTable.getPetType();
        this.petBreed = claimTable.getPetBreed();
        this.dateOfEvent = claimTable.getDateOfEvent();
        this.eventDetails = claimTable.getEventDetails();
    }
    public ClaimTransaction toClaimTransaction() {

        return new ClaimTransaction (null, claimId, policyNumber, firstName,
                lastName, claimDate, claimType, claimStatus, costOfClaim, claimReason, description, city,
                street, zip, makeOfVehicle, modelOfVehicle, yearOfVehicle, petType, petBreed, dateOfEvent,
                eventDetails);
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

    public LocalDate getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(LocalDate dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }
}
