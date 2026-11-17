package com.identity.verification;

import java.util.ArrayList;

import com.identity.verification.model.Identity;
import com.identity.verification.model.NationalID;
import com.identity.verification.model.StudentID;

public class IdentityManager {

    private ArrayList<Identity> registeredIdentities;

    // Constructor
    public IdentityManager() {
        registeredIdentities = new ArrayList<>();
    }

    // Register National ID or Student ID
    public boolean registerIdentity(Identity identity) {

        if (identity == null) {
            return false;
        }

        // Prevent registering the same object twice
        if (registeredIdentities.contains(identity)) {
            return false;
        }

        // National ID registration
        if (identity instanceof NationalID) {

            NationalID nationalID = (NationalID) identity;

            String cnic = normalizeCNIC(
                    nationalID.getCnicNumber());

            if (cnic == null) {
                return false;
            }

            // Prevent duplicate CNIC registration
            if (findByCNIC(cnic) != null) {
                return false;
            }
        }

        // Student ID registration
        else if (identity instanceof StudentID) {

            StudentID student = (StudentID) identity;

            String studentID = normalizeID(
                    student.getStudentID());

            String university = normalizeID(
                    student.getUniversityName());

            if (studentID == null || university == null) {
                return false;
            }

            // Prevent duplicate Student ID
            if (findByStudentID(studentID, university) != null) {
                return false;
            }
        }

        else {
            return false;
        }

        // Register identity after successful validation
        registeredIdentities.add(identity);

        return true;
    }

    // Validate and normalize CNIC
    private String normalizeCNIC(String cnic) {

        if (cnic == null) {
            return null;
        }

        cnic = cnic.trim();

        if (!cnic.matches("\\d{13}|\\d{5}-\\d{7}-\\d")) {
            return null;
        }

        return cnic.replace("-", "");
    }

    // Normalize Student ID and University Name
    private String normalizeID(String value) {

        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        return value.trim();
    }

    // Find National ID using CNIC
    public NationalID findByCNIC(String cnic) {

        String searchCNIC = normalizeCNIC(cnic);

        if (searchCNIC == null) {
            return null;
        }

        for (Identity identity : registeredIdentities) {

            if (identity instanceof NationalID) {

                NationalID nationalID = (NationalID) identity;

                String registeredCNIC =
                        normalizeCNIC(nationalID.getCnicNumber());

                if (searchCNIC.equals(registeredCNIC)) {
                    return nationalID;
                }
            }
        }

        return null;
    }

    // Verify National ID
    public boolean verifyCNIC(String cnic) {

        return findByCNIC(cnic) != null;
    }

    // Find Student ID using ID and university
    public StudentID findByStudentID(
            String studentID, String universityName) {

        String searchID = normalizeID(studentID);
        String searchUniversity = normalizeID(universityName);

        if (searchID == null || searchUniversity == null) {
            return null;
        }

        for (Identity identity : registeredIdentities) {

            if (identity instanceof StudentID) {

                StudentID student = (StudentID) identity;

                if (searchID.equalsIgnoreCase(
                        normalizeID(student.getStudentID()))
                        && searchUniversity.equalsIgnoreCase(
                        normalizeID(student.getUniversityName()))) {

                    return student;
                }
            }
        }

        return null;
    }

    // Verify Student ID
    public boolean verifyStudentID(
            String studentID, String universityName) {

        return findByStudentID(studentID, universityName) != null;
    }

    // Remove National ID
    public boolean removeNationalID(String cnic) {

        NationalID nationalID = findByCNIC(cnic);

        if (nationalID == null) {
            return false;
        }

        return registeredIdentities.remove(nationalID);
    }

    // Remove Student ID
    public boolean removeStudentID(
            String studentID, String universityName) {

        StudentID student =
                findByStudentID(studentID, universityName);

        if (student == null) {
            return false;
        }

        return registeredIdentities.remove(student);
    }

    // Return all registered identities
    public ArrayList<Identity> getRegisteredIdentities() {

        return new ArrayList<>(registeredIdentities);
    }

    // Count registered identities
    public int getTotalRegisteredIdentities() {

        return registeredIdentities.size();
    }

    // Check whether manager is empty
    public boolean isEmpty() {

        return registeredIdentities.isEmpty();
    }
}