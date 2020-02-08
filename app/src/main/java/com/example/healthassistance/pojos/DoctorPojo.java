package com.example.healthassistance.pojos;

public class DoctorPojo {

    private String doctorID;
    private String doctorName;
    private String hospitalName;
    private String phoneNumber;

    public DoctorPojo() {
        //fireBase_Required_empty_constractor
    }

    public DoctorPojo(String doctorID, String doctorName, String hospitalName, String phoneNumber) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.hospitalName = hospitalName;
        this.phoneNumber = phoneNumber;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
