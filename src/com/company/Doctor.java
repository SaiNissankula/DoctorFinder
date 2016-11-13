package com.company;
import java.util.ArrayList;

/**
 * Created by Sai on 11/12/16.
 */
public class Doctor {
    String speciality;
    String address;
    double reviewScore; //out of 5
    ArrayList<String> insuranceAccepted;

    Doctor(String speciality, String address, double reviewScore, ArrayList<String> insuranceAccepted){
        this.speciality = speciality;
        this.address = address;
        this.reviewScore = reviewScore;
        this.insuranceAccepted = insuranceAccepted; //I believe this would be an important attribute to track but I am not too familiar how Health Insurance works and how much variation there is between what doctors accept.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;

        Doctor doctor = (Doctor) o;

        if (Double.compare(doctor.reviewScore, reviewScore) != 0) return false;
        if (!speciality.equals(doctor.speciality)) return false;
        if (!address.equals(doctor.address)) return false;
        return insuranceAccepted.equals(doctor.insuranceAccepted);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = speciality.hashCode();
        result = 31 * result + address.hashCode();
        temp = Double.doubleToLongBits(reviewScore);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + insuranceAccepted.hashCode();
        return result;
    }
}
