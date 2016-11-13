package com.company;
import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

/**
 * Created by Sai on 11/12/16.
 */
public class DoctorFinderTests {

    private static String Speciality1 = "Speciality1";
    private static String Speciality2 = "Speciality2";

    private static String Address1 = "Address1";
    private static String Address2 = "Address2";
    private static String Address3 = "Address3";
    private static String Address4 = "Address4";

    private static ArrayList<String> InsuranceAccepted1 = new ArrayList<String>(Arrays.asList("insurance1", "insurance2"));
    private static ArrayList<String> InsuranceAccepted2 = new ArrayList<String>(Arrays.asList("insurance2", "insurance3"));
    private static ArrayList<String> InsuranceAccepted3 = new ArrayList<String>(Arrays.asList("insurance4"));
    private static ArrayList<String> InsuranceAccepted4 = new ArrayList<String>(Arrays.asList("insurance2", "insurance4"));

    private static double Review1 = 3;
    private static double Review2 = 3.5;
    private static double Review3 = 5;
    private static double Review4 = 3.7;

    private static Doctor Doctor1;
    private static Doctor Doctor2;
    private static Doctor Doctor3;
    private static Doctor Doctor4;

    private static ArrayList<Doctor> Doctors = new ArrayList<Doctor>();

    private static DoctorFinder doctorFinder;


    @BeforeClass
    public static void SetUp(){
        Doctor1 = new Doctor(Speciality1, Address1, Review1, InsuranceAccepted1);
        Doctor2 = new Doctor(Speciality2, Address2, Review2, InsuranceAccepted2);
        Doctor3 = new Doctor(Speciality1, Address3, Review3, InsuranceAccepted3);
        Doctor4 = new Doctor(Speciality1, Address4, Review4, InsuranceAccepted4);

        Doctors.add(Doctor1);
        Doctors.add(Doctor2);
        Doctors.add(Doctor3);

        doctorFinder = new DoctorFinder(Doctors);
    }

    @Test
    public void CompareSpecialitiesTest(){
        assertEquals(doctorFinder.CompareSpecialities(Doctor1, Doctor2), false);
        assertEquals(doctorFinder.CompareSpecialities(Doctor1, Doctor3), true);
    }

    @Test
    public void CompareRatingsTest(){
        assertEquals(doctorFinder.CompareRatings(Doctor1, Doctor2), true);
        assertEquals(doctorFinder.CompareRatings(Doctor1, Doctor3), false);
    }

    @Test
    public void CompareDistancesTest(){
        //this testcase I would just assert that 2 doctors that I know are less than 25 miles from each other that my function GetDistanceBetweenDoctors will return true;
    }

    @Test
    public void CompareInsurancesAcceptedTest(){
        assertEquals(doctorFinder.CompareInsurancesAccepted(Doctor1, Doctor2), true);
        assertEquals(doctorFinder.CompareInsurancesAccepted(Doctor2, Doctor3), false);
    }

    @Test
    public void FindDoctorsTest(){
        //This test case right now does not work because of the distance abstraction. (the random distance that is generated may not always be gaurenteed to be under 25 miles for those 2 doctors).

        ArrayList<Doctor> foundDoctors = doctorFinder.FindDoctors(Doctor4);
        ArrayList<Doctor> expectedFoundDoctors = new ArrayList<>();
        expectedFoundDoctors.add(Doctor1);
        expectedFoundDoctors.add(Doctor3);

        assertEquals(expectedFoundDoctors, foundDoctors);
    }
}
