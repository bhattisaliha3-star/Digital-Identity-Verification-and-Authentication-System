package main.java;
public class Main {

    public static void main(String[] args) {

       Verification verification = new Verification();

       boolean result = verification.verifyCNIC("42101", "42107");

       System.out.println(result);
    }
}