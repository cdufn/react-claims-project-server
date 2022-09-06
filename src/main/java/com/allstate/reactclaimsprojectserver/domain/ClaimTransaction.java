package com.allstate.reactclaimsprojectserver.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="claimstransactions")
public class ClaimTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="claim_id")
    private String claimId;

    @Column(name="policy_number")
    private String policyNumber;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="claim_date")
    private LocalDate claimDate;

    @Column(name="claim_type")
    private String claimType;

    @Column(name="claim_status")
    private String claimStatus;

    @Column(name="cost_of_claim")
    private String costOfClaim;

    @Column(name="claim_reason")
    private String claimReason;

    @Column(name="description")
    private String description;

    @Column(name="city")
    private String city;

    @Column(name="street")
    private String street;

    @Column(name="zip")
    private String zip;

    @Column(name="make_of_vehicle")
    private String makeOfVehicle;

    @Column(name="model_of_vehicle")
    private String modelOfVehicle;

    @Column(name="year_of_vehicle")
    private String yearOfVehicle;

    @Column(name="pet_type")
    private String petType;

    @Column(name="pet_breed")
    private String petBreed;

    @Column(name="date_of_event")
    private LocalDate dateOfEvent;

    @Column(name="event_details")
    private String eventDetails;

    public ClaimTransaction() {
    }

    public ClaimTransaction(Integer id, String claimId, String policyNumber, String firstName, String lastName, LocalDate claimDate,  String claimType, String claimStatus, String costOfClaim, String claimReason, String description, String city, String street, String zip, String makeOfVehicle, String modelOfVehicle, String yearOfVehicle, String petType, String petBreed, LocalDate dateOfEvent, String eventDetails) {
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

    public String getPolicyNumber() { return policyNumber; }

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

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
