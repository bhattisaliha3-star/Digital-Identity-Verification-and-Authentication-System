package com.identity.verification;
import java.util.ArrayList;
import com.identity.verification.model.Identity;
import com.identity.verification.model.NationalID;

public class IdentityManager {
    private ArrayList<Identity> registeredIdentities;

    public IdentityManager() {
        registeredIdentities = new ArrayList<>();

    }

        public boolean registerIdentity(Identity identity) {

        if (identity == null) {
            return false;
        }

        if (identity instanceof NationalID) {

            NationalID nationalID = (NationalID) identity;
            String cnic = nationalID.getCnicNumber();

            if (cnic == null) {
                return false;

            }
       registeredIdentities.add(identity); 
       
            return true;
        } 
        return false;
        }
    }
    

