package com.allstate.reactclaimsprojectserver.service;

import com.allstate.reactclaimsprojectserver.data.ClaimControllerRepository;
import com.allstate.reactclaimsprojectserver.domain.ClaimTransaction;
import com.allstate.reactclaimsprojectserver.dtos.ClaimControllerDTO;
import com.allstate.reactclaimsprojectserver.exceptions.InvalidNewTransactionException;
import com.allstate.reactclaimsprojectserver.exceptions.TransactionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimControllerRepository claimControllerRepository;

    @Override
    public List<ClaimTransaction> getAllTransactions() {
        return claimControllerRepository.findAll();
    }

    @Override
    public int countTransactions() {
        return claimControllerRepository.findAll().size();
    }

    @Override
    public List<ClaimTransaction> getAllNewClaims(String claimStatus) {

//        return creditCardTransactionRepository.findAll()
//                .stream().filter( trans -> trans.getCountry().equals(country))
//                .collect(Collectors.toList());

        return claimControllerRepository.findAllByNewClaim(claimStatus);
    }

    @Override
    public List<ClaimTransaction> getClaimByPolicyNumber(String policyNumber) {
        return claimControllerRepository.findAllByPolicyNumber(policyNumber);
    }

    @Override
    public List<ClaimTransaction> getClaimByLastname(String lastName) {
        return claimControllerRepository.findAllByLastName(lastName);
    }

    @Override
    public List<ClaimTransaction> getAllTransactionsForClaimId(String claimId) {
        return claimControllerRepository.findAllForClaimId(claimId);
    }

    @Override
    public ClaimTransaction getClaimById(Integer id) {
        Optional<ClaimTransaction> optionalCCT =  claimControllerRepository.findById(id);
        if (optionalCCT.isPresent()) {
            return optionalCCT.get();
        }
        throw new TransactionNotFoundException("There is no transaction with an ID of " + id);
    }

    @Override
    public ClaimTransaction addClaim(ClaimControllerDTO claimDTO) {
        ClaimTransaction claim = claimDTO.toClaimTransaction();

        if(claim.getClaimId() == null) {
            throw new InvalidNewTransactionException("Claim Id must be provided");
        }
        try {
            return claimControllerRepository.save(claim);
        }
        catch (Exception e) {
            throw new InvalidNewTransactionException("We were unable to save your transaction");
        }
    }

    @Override
    public ClaimTransaction updateClaim(Integer id, Map<String, String> data) {
        ClaimTransaction claim = getClaimById(id);
        if (data.containsKey("policyNumber")) claim.setPolicyNumber(data.get("policyNumber"));
        if (data.containsKey("firstName")) claim.setFirstName(data.get("firstName"));
        if (data.containsKey("lastName")) claim.setLastName(data.get("lastName"));
        if (data.containsKey("claimType")) claim.setClaimType(data.get("claimType"));
        if (data.containsKey("claimStatus")) claim.setClaimStatus(data.get("claimStatus"));
        if (data.containsKey("claimDate")) claim.setPolicyNumber(data.get("claimDate"));
        if (data.containsKey("costOfClaim")) claim.setFirstName(data.get("costOfClaim"));
        if (data.containsKey("claimReason")) claim.setLastName(data.get("claimReason"));
        if (data.containsKey("description")) claim.setClaimType(data.get("city"));
        if (data.containsKey("street")) claim.setClaimStatus(data.get("street"));
        if (data.containsKey("zip")) claim.setLastName(data.get("zip"));
        if (data.containsKey("makeOfVehicle")) claim.setClaimType(data.get("makeOfVehicle"));
        if (data.containsKey("modelOfVehicle")) claim.setClaimStatus(data.get("modelOfVehicle"));
        if (data.containsKey("yearOfVehicle;")) claim.setClaimType(data.get("yearOfVehicle;"));
        if (data.containsKey("petType")) claim.setClaimStatus(data.get("petType"));
        if (data.containsKey("petBreed")) claim.setLastName(data.get("petBreed"));
        if (data.containsKey("dateOfEvent")) claim.setClaimType(data.get("dateOfEvent"));
        if (data.containsKey("eventDetails")) claim.setClaimStatus(data.get("eventDetails"));
        return claimControllerRepository.save(claim);
    }
}
