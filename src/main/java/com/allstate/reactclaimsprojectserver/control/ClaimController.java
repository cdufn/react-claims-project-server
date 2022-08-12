package com.allstate.reactclaimsprojectserver.control;

import com.allstate.reactclaimsprojectserver.domain.ClaimTransaction;
import com.allstate.reactclaimsprojectserver.dtos.ClaimControllerDTO;
import com.allstate.reactclaimsprojectserver.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public List<ClaimTransaction> getAll(@RequestParam(value="policyNumber", required=false) String policyNumber,
                                         @RequestParam(value="lastName", required=false) String lastName,
                                         @RequestParam(value="claimStatus", required=false) String claimStatus) {
        if (policyNumber != null) {
            return claimService.getClaimByPolicyNumber(policyNumber);
        }
        else if (lastName != null) {
            return claimService.getClaimByLastname(lastName);
        }
        else if (claimStatus != null) {
            return claimService.getAllNewClaims(claimStatus);
        }

        return claimService.getAllTransactions();

    }

    @GetMapping(value ="/{id}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ClaimTransaction getById(@PathVariable("id") Integer id) {
        return claimService.getClaimById(id);
    }

    @GetMapping("/volume")
    public Map<String, String> getNumberOfPayments() {
        Integer volume = claimService.countTransactions();
        Map<String, String> results = new HashMap<>();
        results.put("volume", volume.toString());
        return results;
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
