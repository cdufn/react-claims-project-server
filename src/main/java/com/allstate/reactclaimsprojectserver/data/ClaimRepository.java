package com.allstate.reactclaimsprojectserver.data;

import com.allstate.reactclaimsprojectserver.domain.ClaimTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClaimRepository extends JpaRepository<ClaimTransaction, Integer> {

    public List<ClaimTransaction> findAllByNewClaim(String claimStatus);
    public List<ClaimTransaction> findAllForClaimId(String claimId);
    public List<ClaimTransaction> findAllByPolicyNumber(String policyNumber);
    public List<ClaimTransaction> findAllByLastName(String lastName);

}
