package model;

public class Bike extends Vehicle {
    public Bike(String brand, float price, int picture) {
        super(brand, price, picture);
    }

    public Bike(String bikeType){
        this.bikeType=bikeType;

    }
    String bikeType;

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }
}
