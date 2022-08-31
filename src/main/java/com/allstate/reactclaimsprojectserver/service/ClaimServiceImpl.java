package com.allstate.reactclaimsprojectserver.service;

import com.allstate.reactclaimsprojectserver.data.ClaimRepository;
import com.allstate.reactclaimsprojectserver.domain.ClaimTransaction;
import com.allstate.reactclaimsprojectserver.dtos.ClaimControllerDTO;
import com.allstate.reactclaimsprojectserver.exceptions.InvalidNewTransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Date;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository ClaimRepository;

    @Override
    public List<ClaimTransaction> getAll() {

        return ClaimRepository.findAll();
    }

    @Override
    public List<ClaimTransaction> getAllTransactions() {
        return ClaimRepository.findAll();
    }

    @Override
    public int countTransactions() {
        return ClaimRepository.findAll().size();
    }

    @Override
    public List<ClaimTransaction> findByClaimStatus(String claimStatus) {
        return ClaimRepository.findByClaimStatus(claimStatus);
    }

    @Override
    public ClaimTransaction getTransactionById(Integer id) {
        Optional<ClaimTransaction> optionalCCT =  ClaimRepository.findById(id);
        if (optionalCCT.isPresent()) {
            return optionalCCT.get();
        }

        throw new InvalidNewTransactionException("There is no transaction with an ID of " + id);
    }


    @Override
    public ClaimTransaction add(ClaimControllerDTO claimDTO) {
        ClaimTransaction claim = claimDTO.toClaimTransaction();

        if(claim.getClaimId() == null) {
            throw new InvalidNewTransactionException("Claim Id must be provided");
        }
        try {
            return ClaimRepository.save(claim);
        }
        catch (Exception e) {
            throw new InvalidNewTransactionException("We were unable to save your transaction");
        }
    }

    @Override
    public ClaimTransaction updateClaim(Integer id, Map<String, String> data) {
        ClaimTransaction claim = getTransactionById(id);
        if (data.containsKey("policyNumber")) claim.setPolicyNumber(data.get("policyNumber"));
        if (data.containsKey("firstName")) claim.setFirstName(data.get("firstName"));
        if (data.containsKey("lastName")) claim.setLastName(data.get("lastName"));
        if (data.containsKey("claimType")) claim.setClaimType(data.get("claimType"));
        if (data.containsKey("claimStatus")) claim.setClaimStatus(data.get("claimStatus"));
        if (data.containsKey("claimDate")) claim.setClaimDate(LocalDate.parse(data.get("claimDate")));
        if (data.containsKey("costOfClaim")) claim.setCostOfClaim(data.get("costOfClaim"));
        if (data.containsKey("claimReason")) claim.setClaimReason(data.get("claimReason"));
        if (data.containsKey("street")) claim.setStreet(data.get("street"));
        if (data.containsKey("zip")) claim.setZip(data.get("zip"));
        if (data.containsKey("makeOfVehicle")) claim.setMakeOfVehicle(data.get("makeOfVehicle"));
        if (data.containsKey("modelOfVehicle")) claim.setModelOfVehicle(data.get("modelOfVehicle"));
        if (data.containsKey("yearOfVehicle;")) claim.setYearOfVehicle(data.get("yearOfVehicle;"));
        if (data.containsKey("petType")) claim.setPetType(data.get("petType"));
        if (data.containsKey("petBreed")) claim.setPetBreed(data.get("petBreed"));
        if (data.containsKey("dateOfEvent")) claim.setDateOfEvent(LocalDate.parse(data.get("dateOfEvent")));
        if (data.containsKey("eventDetails")) claim.setEventDetails(data.get("eventDetails"));
        return ClaimRepository.save(claim);
    }
}
