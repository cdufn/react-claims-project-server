package com.allstate.reactclaimsprojectserver.service;

import com.allstate.reactclaimsprojectserver.domain.ClaimTransaction;
import com.allstate.reactclaimsprojectserver.dtos.ClaimControllerDTO;

import java.util.List;
import java.util.Map;

public interface ClaimService {

    List<ClaimTransaction> getAll();
    List<ClaimTransaction> getAllTransactions();
    int countTransactions();
    List<ClaimTransaction> findByClaimStatus(String claimStatus);
    public ClaimTransaction getById(int id);
    ClaimTransaction getTransactionById(Integer id);
    ClaimTransaction add(ClaimControllerDTO claim);
    ClaimTransaction updateClaim(Integer claimId, Map<String, String> data);
}
