package model;

import java.io.Serializable;

public class Vehicle implements Comparable, Serializable {



    String brand;
    public Vehicle()
    {

    }
    public Vehicle( String brand, float price, int picture)
    {

        this.brand = brand;
        this.price = price;
        this.picture = picture;
    }

    float price;
    int picture;

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }


    @Override
    public String toString()
    {
        return  brand;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
