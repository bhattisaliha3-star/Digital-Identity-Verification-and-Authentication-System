package com.identity.verification.model;

    public class NationalID extends Identity {

    // National identity attribute
    private String cnicNumber;

    // Constructor
    public NationalID(String fullName, String dateOfBirth,
                      String gender, String cnicNumber) {

        super(fullName, dateOfBirth, gender);
        this.cnicNumber = cnicNumber;
    }
    // Getter
    public String getCnicNumber() {
        return cnicNumber;
    }

    // Setter
    public void setCnicNumber(String cnicNumber) {
        this.cnicNumber = cnicNumber;
    }
    // Identify the type of identity
    @Override
    public String getIdentityType() {
        return "National Identity (CNIC)";
    }

    // Display national identity details
    @Override
    public void displayIdentityDetails() {

        System.out.println("\n----- National Identity Details -----");

        System.out.println("Identity Type: " + getIdentityType());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + getDateOfBirth());
        System.out.println("Gender: " + getGender());
        System.out.println("CNIC Number: " + getCnicNumber());
    }
}
