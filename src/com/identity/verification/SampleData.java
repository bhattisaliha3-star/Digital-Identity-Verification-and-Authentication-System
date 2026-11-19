package com.identity.verification;

import com.identity.verification.model.NationalID;
import com.identity.verification.model.StudentID;

public class SampleData {

    public static void load(IdentityManager manager) {

        manager.registerIdentity(new NationalID(
                "Ayesha Khan", "12-05-2002", "Female", "42101-1234567-1"));

        manager.registerIdentity(new NationalID(
                "Ali Raza", "03-11-2001", "Male", "4210198765432"));

        manager.registerIdentity(new StudentID(
                "Ayesha Khan", "12-05-2002", "Female",
                "CS-2023-001", "University of Karachi"));

        manager.registerIdentity(new StudentID(
                "Ali Raza", "03-11-2001", "Male",
                "SE-2022-014", "NED University"));
    }
}