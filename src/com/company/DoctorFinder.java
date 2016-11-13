package com.company;
import java.util.ArrayList;

/**
 * Created by Sai on 11/12/16.
 */
public class DoctorFinder {
    private ArrayList<Doctor> AllDoctors;

    DoctorFinder(ArrayList<Doctor> allDoctors){
        this.AllDoctors = allDoctors;
    }

    ArrayList<Doctor> FindDoctors(Doctor doctor){
        ArrayList<Doctor> foundDoctors = new ArrayList<Doctor>();

        for(Doctor doc : AllDoctors){
            boolean HasSameSpeciality = CompareSpecialities(doc, doctor);
            boolean AcceptsAtleastOneSameInsurance = CompareInsurancesAccepted(doc, doctor);
            boolean HasSimilarRating = CompareRatings(doc, doctor);
            boolean IsDoctorClose = CompareDistances(doc, doctor);

            if(HasSameSpeciality && AcceptsAtleastOneSameInsurance && HasSimilarRating && IsDoctorClose){
                foundDoctors.add(doc);
            }
        }

        return foundDoctors;
    }

    //The following functions will return comparisons on the Doctor's member variables.

    boolean CompareSpecialities(Doctor doc1, Doctor doc2){
        if(doc1.speciality == doc2.speciality){
            return true;
        }

        return false;
    }

    boolean CompareInsurancesAccepted(Doctor doc1, Doctor doc2){
        //I am assuming that if a doctor accepts at least 1 one of the same insurances they are considered "similiar".

        for (String insurance : doc2.insuranceAccepted){
            if (doc1.insuranceAccepted.contains(insurance)){
                return true;
            }
        }

        return false;
    }

    boolean CompareRatings(Doctor doc1, Doctor doc2){
        //I am assuming that the rating of a doctor should be within a point (out of 5) to consider a doctor to be "similar".

        if(Math.abs(doc1.reviewScore - doc2.reviewScore) < 1){
            return true;
        }

        return false;
    }

    boolean CompareDistances(Doctor doc1, Doctor doc2){
        if(GetDistanceBetweenDoctors(doc1.address, doc2.address) < 25){ //I assume that a person will want to find a doctor thats less than 25 miles away.
            return true;
        }

        return false;
    }


    private double GetDistanceBetweenDoctors(String addressDoc1, String addressDoc2){
        //to keep things simple I am abstracting out the finding the closest doctors.
        //If I were to fully implement this, I would use Google Maps API to determine the distances.
        //For a stub, this function will just return a random number (in miles lets say)
        return Math.random()*100;
    }
}
