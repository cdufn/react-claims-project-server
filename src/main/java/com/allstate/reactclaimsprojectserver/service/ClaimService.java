package com.allstate.reactclaimsprojectserver.service;

import com.allstate.reactclaimsprojectserver.domain.ClaimTransaction;
import com.allstate.reactclaimsprojectserver.dtos.ClaimControllerDTO;

import java.util.List;
import java.util.Map;

public interface ClaimService {

    List<ClaimTransaction> getAllTransactions();
    int countTransactions();
    List<ClaimTransaction> getAllNewClaims(String claimStatus);
    List<ClaimTransaction> getAllTransactionsForClaimId(String claimId);
    List<ClaimTransaction> getClaimByPolicyNumber(String policyNumber);
    List<ClaimTransaction> getClaimByLastname(String lastName);
    ClaimTransaction getClaimById(Integer id);
    ClaimTransaction addClaim(ClaimControllerDTO claim);
    ClaimTransaction updateClaim(Integer id, Map<String,String> data);
}
