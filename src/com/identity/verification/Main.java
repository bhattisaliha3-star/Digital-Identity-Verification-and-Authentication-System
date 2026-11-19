
package com.identity.verification;

import java.util.Scanner;
import java.util.ArrayList;

import com.identity.verification.model.Identity;
import com.identity.verification.model.NationalID;
import com.identity.verification.model.StudentID;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create manager only once
        IdentityManager manager = new IdentityManager();

        boolean running = true;

        while (running) {

            System.out.println("\n======================================");
            System.out.println(" DIGITAL IDENTITY VERIFICATION SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Register New Identity");
            System.out.println("2. Verify Existing Identity");
            System.out.println("3. Display Registered Identities");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");
            String choice = input.nextLine().trim();

            switch (choice) {

                case "1":
                    registerIdentity(input, manager);
                    break;

                case "2":
                    verifyIdentity(input, manager);
                    break;

                case "3":
                    displayIdentities(manager);
                    break;

                case "4":
                    running = false;
                    System.out.println("\nThank you for using our system!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Try again.");
            }
        }

        input.close();
    }

    // Register a new identity
    private static void registerIdentity(
            Scanner input, IdentityManager manager) {

        System.out.println("\n--- NEW IDENTITY REGISTRATION ---");

        System.out.println("1. National ID (CNIC)");
        System.out.println("2. Student ID");

        System.out.print("Choose identity type: ");
        String choice = input.nextLine().trim();

        System.out.print("Enter full name: ");
        String fullName = input.nextLine().trim();

        System.out.print("Enter date of birth: ");
        String dateOfBirth = input.nextLine().trim();

        System.out.print("Enter gender: ");
        String gender = input.nextLine().trim();

        if (fullName.isEmpty()
                || dateOfBirth.isEmpty()
                || gender.isEmpty()) {

            System.out.println("Registration failed: "
                    + "Required details cannot be empty.");
            return;
        }

        Identity identity;

        if (choice.equals("1")) {

            System.out.print("Enter CNIC (13 digits): ");
            String cnic = input.nextLine().trim();

            identity = new NationalID(
                    fullName, dateOfBirth, gender, cnic);

        } else if (choice.equals("2")) {

            System.out.print("Enter Student ID: ");
            String studentID = input.nextLine().trim();

            System.out.print("Enter university name: ");
            String university = input.nextLine().trim();

            identity = new StudentID(
                    fullName, dateOfBirth, gender,
                    studentID, university);

        } else {

            System.out.println("Invalid identity type.");
            return;
        }

        boolean registered = manager.registerIdentity(identity);

        if (registered) {

            System.out.println("\nIdentity registered successfully!");

            System.out.println("\n--- REGISTERED DETAILS ---");
            identity.displayIdentityDetails();

        } else {

            System.out.println("\nIdentity registration failed.");
            System.out.println(
                    "Invalid details or identity already registered.");
        }
    }

    // Verify an existing identity
    private static void verifyIdentity(
            Scanner input, IdentityManager manager) {

        System.out.println("\n--- IDENTITY VERIFICATION ---");

        System.out.println("1. National ID (CNIC)");
        System.out.println("2. Student ID");

        System.out.print("Choose identity type: ");
        String choice = input.nextLine().trim();

        Verification verification = new Verification();

        if (choice.equals("1")) {

            System.out.print("Enter CNIC to verify: ");
            String cnic = input.nextLine().trim();

            NationalID registered = manager.findByCNIC(cnic);

            if (registered == null) {

                System.out.println(
                        "\nIdentity not registered. Please register first.");
                return;
            }

            boolean result = verification.verifyIdentity(
                    registered.getCnicNumber(), cnic);

            if (result) {
                System.out.println(
                        "\nNational ID verified successfully!");
            } else {
                System.out.println("\nIdentity verification failed.");
            }

        } else if (choice.equals("2")) {

            System.out.print("Enter Student ID: ");
            String studentID = input.nextLine().trim();

            System.out.print("Enter university name: ");
            String university = input.nextLine().trim();

            StudentID registered =
                    manager.findByStudentID(studentID, university);

            if (registered == null) {

                System.out.println(
                        "\nIdentity not registered. Please register first.");
                return;
            }

            boolean result = verification.verifyIdentity(
                    registered.getStudentID(), studentID);

            if (result) {
                System.out.println(
                        "\nStudent ID verified successfully!");
            } else {
                System.out.println("\nIdentity verification failed.");
            }

        } else {

            System.out.println("Invalid identity type.");
        }
    }

    // Display all registered identities
    private static void displayIdentities(IdentityManager manager) {

        ArrayList<Identity> identities =
                manager.getRegisteredIdentities();

        System.out.println("\n--- REGISTERED IDENTITIES ---");

        if (identities.isEmpty()) {
            System.out.println("No identities registered yet.");
            return;
        }

        for (int i = 0; i < identities.size(); i++) {

            System.out.println("\nIdentity " + (i + 1));

            identities.get(i).displayIdentityDetails();
        }

        System.out.println("\nTotal registered identities: "
                + manager.getTotalRegisteredIdentities());
    }
}
