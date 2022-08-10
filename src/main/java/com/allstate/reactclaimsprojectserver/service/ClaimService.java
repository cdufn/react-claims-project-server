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
    ClaimTransaction getClaimById(Integer id);
    ClaimTransaction add(ClaimControllerDTO claim);
    ClaimTransaction updateClaim(Integer id, Map<String,String> data);
}
