package com.example.heshan;

public class Supply {
    public String name;
    public int litres;
    public int meter;
    public String date;
    public double weight;
    public int upNumber;

    public Supply() {
    }

    public Supply(String date,int litres, int meter, double weight) {
        this.date = date;
        this.litres = litres;
        this.meter = meter;
        this.weight = weight;
    }

    public Supply(int upNumber,int litres, int meter,  double weight, String date) {
        this.litres = litres;
        this.meter = meter;
        this.weight = weight;
        this.upNumber = upNumber;
        this.date = date;
    }

    public Supply(String name, int litres, int meter, double weight, String date) {
        this.name = name;
        this.litres = litres;
        this.meter = meter;
        this.date = date;
        this.weight = weight;
    }

    public int getUpNumber() {
        return upNumber;
    }

    public void setUpNumber(int upNumber) {
        this.upNumber = upNumber;
    }

    public String getName() {
        return name;
    }

    public int getLitres() {
        return litres;
    }

    public int getMeter() {
        return meter;
    }

    public String getDate() {
        return date;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLitres(int litres) {
        this.litres = litres;
    }

    public void setMeter(int meter) {
        this.meter = meter;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
