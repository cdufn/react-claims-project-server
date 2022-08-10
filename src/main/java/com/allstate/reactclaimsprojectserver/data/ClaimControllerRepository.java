package com.allstate.reactclaimsprojectserver.data;

import com.allstate.reactclaimsprojectserver.domain.ClaimTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClaimControllerRepository extends JpaRepository<ClaimTransaction, Integer> {

    // also add in entries for find by policy number and find by last name
    public List<ClaimTransaction> findAllByNewClaim(String claimStatus);
    public List<ClaimTransaction> findAllForClaimId(String claimId);
    public Optional<ClaimTransaction> findByPolicyNumber(Integer policyNumber);

}
