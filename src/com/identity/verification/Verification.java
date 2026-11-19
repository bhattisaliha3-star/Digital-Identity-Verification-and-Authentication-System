
package com.identity.verification;

public class Verification {

    public boolean verifyIdentity(
            String registeredIdentity,
            String enteredIdentity) {

        if (registeredIdentity == null || enteredIdentity == null) {
            return false;
        }

        String registered = registeredIdentity.trim();
        String entered = enteredIdentity.trim();

        // Normalize CNIC formatting
        registered = registered.replace("-", "");
        entered = entered.replace("-", "");

        return registered.equalsIgnoreCase(entered);
    }
}
