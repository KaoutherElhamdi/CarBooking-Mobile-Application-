package com.example.carbooking.Models;

public class CarModel {
    private int id;
    private  String carname;
    private int price;
    private int rate;
    private int nbpers;
    private  int nbdoors;
    private String availability;

    public CarModel(){

    }

    public CarModel(int id, String carname, int price, int rate, int nbpers, int nbdoors, String availability) {
        this.id = id;
        this.carname = carname;
        this.price = price;
        this.rate = rate;
        this.nbpers = nbpers;
        this.nbdoors = nbdoors;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getNbpers() {
        return nbpers;
    }

    public void setNbpers(int nbpers) {
        this.nbpers = nbpers;
    }

    public int getNbdoors() {
        return nbdoors;
    }

    public void setNbdoors(int nbdoors) {
        this.nbdoors = nbdoors;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
