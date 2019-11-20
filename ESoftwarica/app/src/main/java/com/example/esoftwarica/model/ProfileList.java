package com.example.esoftwarica.model;

public class ProfileList {
    private String fullName, address, gender;
    private int age, imageID;

    public ProfileList(String fullName, String address, String gender, int age, int imageID){
        this.fullName = fullName;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.imageID = imageID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
