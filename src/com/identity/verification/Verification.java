package com.identity.verification;

public class Verification {
    
  public boolean verifyCNIC( String registeredCNIC ,String enteredCNIC) {


    if(registeredCNIC == null || enteredCNIC == null) {
        return false;


    }

    return registeredCNIC.equals(enteredCNIC);
  }




}
