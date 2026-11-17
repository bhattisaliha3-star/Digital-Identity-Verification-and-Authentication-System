
package com.identity.verification.model;

public class StudentID extends Identity {

    // Student-specific attributes
    private String studentID;
    private String universityName;

    // Constructor
    public StudentID(String fullName, String dateOfBirth,
                     String gender, String studentID,
                     String universityName) {

        super(fullName, dateOfBirth, gender);

        this.studentID = studentID;
        this.universityName = universityName;
    }

    // Getter methods
    public String getStudentID() {
        return studentID;
    }

    public String getUniversityName() {
        return universityName;
    }

    // Setter methods
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    // Identify the type of identity
    @Override
    public String getIdentityType() {
        return "Student Identity";
    }

    // Display student identity details
    @Override
    public void displayIdentityDetails() {

        System.out.println("\n----- Student Identity Details -----");

        System.out.println("Identity Type: " + getIdentityType());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + getDateOfBirth());
        System.out.println("Gender: " + getGender());
        System.out.println("Student ID: " + getStudentID());
        System.out.println("University Name: " + getUniversityName());
    }
}
