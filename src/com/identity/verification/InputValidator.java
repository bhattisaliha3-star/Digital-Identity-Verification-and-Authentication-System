package com.identity.verification;

public class InputValidator {

    public static boolean isValidCNIC(String cnic) {
        if (cnic == null) {
            return false;
        }
        return cnic.trim().matches("\\d{13}|\\d{5}-\\d{7}-\\d");
    }

    public static boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}