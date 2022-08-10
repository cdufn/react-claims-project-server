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
    public ClaimTransaction add(ClaimControllerDTO claimDTO) {
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
        if (data.containsKey("policyNumber")) claim.setPolicyNumber(Integer.parseInt(data.get("policyNumber")));
        if (data.containsKey("firstName")) claim.setFirstName(data.get("firstName"));
        if (data.containsKey("lastName")) claim.setLastName(data.get("lastName"));
        if (data.containsKey("claimType")) claim.setClaimType(data.get("claimType"));
        if (data.containsKey("claimStatus")) claim.setClaimStatus(data.get("claimStatus"));
        return claimControllerRepository.save(claim);
    }
}
