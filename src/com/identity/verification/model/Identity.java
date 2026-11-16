package com.identity.verification.model;

public abstract class Identity {

    // Common attributes of a person
    private String fullName;
    private String dateOfBirth;
    private String gender;

    // Constructor
    public Identity(String fullName, String dateOfBirth, String gender) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    // Getter methods
    public String getFullName() {
        return fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    // Setter methods
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Abstract methods
    public abstract String getIdentityType();

    public abstract void displayIdentityDetails();

}
