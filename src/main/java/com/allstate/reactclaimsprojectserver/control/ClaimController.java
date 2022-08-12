package com.allstate.reactclaimsprojectserver.control;

import com.allstate.reactclaimsprojectserver.domain.ClaimTransaction;
import com.allstate.reactclaimsprojectserver.dtos.ClaimControllerDTO;
import com.allstate.reactclaimsprojectserver.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/claim")

public class ClaimController {

    ClaimService claimService;

    @Autowired
    public void setClaimService(ClaimService claimService) {
        this.claimService = claimService;
    }


    @GetMapping()
    public List<ClaimTransaction> getAll(@RequestParam(value="claimStatus", required=false) String claimStatus,
                                         @RequestParam(value="claimId", required=false) String claimId) {
        if (claimStatus != null) {
            return claimService.getAllNewClaims(claimStatus);
        }
        else if (claimId != null) {
            return claimService.getAllTransactionsForClaimId(claimId);
        }

        return claimService.getAllTransactions();

    }


    @PostMapping
    public ClaimTransaction addClaim(@RequestBody ClaimControllerDTO newTransaction) {
        return claimService.addClaim(newTransaction);
    }

    @PutMapping("/{id}")
    public ClaimTransaction updateClaim(@PathVariable("id") Integer id,
                                                   @RequestBody Map<String, String> data) {

        return claimService.updateClaim(id, data);
    }
}
