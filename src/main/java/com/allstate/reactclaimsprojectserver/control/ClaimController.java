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

    // add in business logic to not return entries when a claim is rejected or accepted and paid

    ClaimService claimService;

    @Autowired
    public void setClaimService(ClaimService claimService) {
        this.claimService = claimService;
    }

    // get all the claim
    @GetMapping()
    public List<ClaimTransaction> getAll(@RequestParam(value="claimStatus", required=false) String claimStatus) {
        if (claimStatus != null) {
            return claimService.findByClaimStatus(claimStatus);
        }
        return claimService.getAllTransactions();
    }

    // had to add in id/
    @GetMapping(value="id/{id}",  produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ClaimTransaction getById(@PathVariable Integer id) {
        return claimService.getById(id);
    }


    @GetMapping(value ="/{claimStatus}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<ClaimTransaction> getByClaimStatus(@PathVariable("claimStatus") String claimStatus) {
        return claimService.findByClaimStatus(claimStatus);
    }

    @GetMapping("/volume")
    public Map<String, String> getNumberOfClaims() {
        Integer volume = claimService.countTransactions();
        Map<String, String> results = new HashMap<>();
        results.put("volume", volume.toString());
        return results;
    }

    @PostMapping
    public ClaimTransaction addClaim(@RequestBody ClaimControllerDTO newTransaction) {
        return claimService.add(newTransaction);
    }

    @PutMapping("/update/{id}")
    public ClaimTransaction updateClaim(@PathVariable("id") Integer claimId,
                             @RequestBody Map<String, String> data){
        return claimService.updateClaim(claimId, data);
    }
}
