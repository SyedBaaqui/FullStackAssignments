package com.ClaimInsurance;

import java.io.Serializable;

public class ClaimBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String policyNumber;
    private String claimAmount;
    private String description;

    // Getters and Setters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(String claimAmount) {
        this.claimAmount = claimAmount;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    } 
}