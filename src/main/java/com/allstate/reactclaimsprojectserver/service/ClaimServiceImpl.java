package com.allstate.reactclaimsprojectserver.service;

import com.allstate.reactclaimsprojectserver.data.ClaimRepository;
import com.allstate.reactclaimsprojectserver.domain.ClaimTransaction;
import com.allstate.reactclaimsprojectserver.dtos.ClaimControllerDTO;
import com.allstate.reactclaimsprojectserver.exceptions.InvalidNewTransactionException;
import com.allstate.reactclaimsprojectserver.exceptions.TransactionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

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

    public ClaimTransaction getById(int id) {
        Optional<ClaimTransaction> ccTrans = ClaimRepository.findById(id);
        if (ccTrans.isPresent()) {
            return ccTrans.get();
        }
        else {
            return null;
        }
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
    public ClaimTransaction updateClaim(Integer claimId, Map<String, String> data) {
        ArrayList<String> validValues = new ArrayList<>(Arrays.asList("New", "Assessed", "closed", "Rejected"));

        ClaimTransaction clmUpdate = getById(claimId);

        if(data.containsKey("claimStatus") && data.get("claimStatus") != null
                && validValues.contains(data.get("claimStatus").toLowerCase())) {
            clmUpdate.setClaimStatus(data.get("claimStatus"));
        }else if(data.containsKey("claimStatus") && data.get("claimStatus") != null){
            throw new TransactionNotFoundException("Claim status invalid: ("
                    + data.get("claimStatus")
                    + ") valid values are: "
                    + validValues.toString());
        }

        if(data.containsKey("claimId")){

                clmUpdate.setClaimId(data.get("claimId"));

        }

        if(data.containsKey("policyNumber")){

            clmUpdate.setPolicyNumber(data.get("policyNumber"));

        }

        if(data.containsKey("firstName")){

                clmUpdate.setFirstName(data.get("firstName"));

        }

        if(data.containsKey("lastName")){

                clmUpdate.setLastName(data.get("lastName"));

        }

        if(data.containsKey("costOfClaim")){

                clmUpdate.setCostOfClaim(data.get("costOfClaim"));

        }

        if(data.containsKey("claimStatus")){

                clmUpdate.setClaimStatus(data.get("claimStatus"));

        }

        return ClaimRepository.save(clmUpdate);
    }

}
