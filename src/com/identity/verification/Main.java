
package com.identity.verification;

import java.util.Scanner;

import com.identity.verification.model.Identity;
import com.identity.verification.model.NationalID;
import com.identity.verification.model.StudentID;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println(" DIGITAL IDENTITY VERIFICATION SYSTEM");
        System.out.println("======================================");

        // Choose identity type
        System.out.println("1. National ID (CNIC)");
        System.out.println("2. Student ID");

        System.out.print("Choose identity type: ");
        String choice = input.nextLine();

        // Enter common identity details
        System.out.print("Enter full name: ");
        String fullName = input.nextLine();

        System.out.print("Enter date of birth: ");
        String dateOfBirth = input.nextLine();

        System.out.print("Enter gender: ");
        String gender = input.nextLine();

        Identity registeredIdentity;

        // Create National ID object
        if (choice.equals("1")) {

            System.out.print("Enter registered CNIC: ");
            String cnicNumber = input.nextLine();

            registeredIdentity = new NationalID(
                fullName, dateOfBirth, gender, cnicNumber
            );

        }

        // Create Student ID object
        else if (choice.equals("2")) {

            System.out.print("Enter registered Student ID: ");
            String studentID = input.nextLine();

            System.out.print("Enter university name: ");
            String universityName = input.nextLine();

            registeredIdentity = new StudentID(
                fullName, dateOfBirth, gender,
                studentID, universityName
            );

        } else {

            System.out.println("Invalid identity type selected.");
            input.close();
            return;
        }

        // Register identity
        IdentityManager manager = new IdentityManager();

        boolean registered = manager.registerIdentity(registeredIdentity);

        if (!registered) {
            System.out.println("Identity registration failed.");
            input.close();
            return;
        }

        // Display registered identity
        System.out.println("\n--- Registered Identity ---");
        registeredIdentity.displayIdentityDetails();

        // Verify identity
        System.out.print("\nEnter identity number to verify: ");
        String enteredIdentity = input.nextLine();

        Verification verification = new Verification();

        String registeredNumber;

        if (registeredIdentity instanceof NationalID) {

            registeredNumber =
                ((NationalID) registeredIdentity).getCnicNumber();

        } else {

            registeredNumber =
                ((StudentID) registeredIdentity).getStudentID();
        }

        boolean result = verification.verifyIdentity(
            registeredNumber, enteredIdentity
        );

        if (result) {
            System.out.println("\nIdentity Verified Successfully!");
        } else {
            System.out.println("\nIdentity verification failed.");
        }

        input.close();
    }
}
