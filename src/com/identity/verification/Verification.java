
package com.identity.verification;

public class Verification {

    public boolean verifyIdentity(String registeredIdentity,
                                  String enteredIdentity) {

        if (registeredIdentity == null || enteredIdentity == null) {
            return false;
        }

        return registeredIdentity.equals(enteredIdentity);
    }
}
