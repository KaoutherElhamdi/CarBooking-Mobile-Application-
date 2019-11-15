package com.example.carbooking.Models;


import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("Id")
    private int id;
    @SerializedName("Email")
    private  String email;
    @SerializedName("First Name")
    private String fName;
    @SerializedName("Last Name")
    private String lName;
    @SerializedName("Phone number")
    private String phone;


    public User(String email, String fName, String lName, int id) {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.id = id;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", phone number= '" + phone + '\'' +
                '}';
    }

}
