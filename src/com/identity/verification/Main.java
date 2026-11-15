package com.identity.verification;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter registered CNIC ");
        String registeredCNIString = input.nextLine();

        System.out.println("Enter CNIC to verify ");
        String enteredCNIC = input.nextLine();

        Verification verification = new Verification();
        boolean result = verification.verifyCNIC("42101", "42107");
       if (result) {
    System.out.println("Identity Verified Successfully!");
} else {
    System.out.println("CNIC does not match our records.");
}
    }
    
}
