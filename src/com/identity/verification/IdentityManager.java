package com.identity.verification;

public class IdentityManager {
    private String registeredCNIC;

    public IdentityManager(String registeredCNIC) {
        this.registeredCNIC = registeredCNIC;
    }

    public boolean verifyIdentity(String enteredCNIC) {
        Verification verification = new Verification();
        return verification.verifyCNIC(registeredCNIC, enteredCNIC);
    }
    
}
