package model;

public class Car  extends Vehicle{

    String model;

    public Car(String brand, float price, int picture) {
        super(brand, price, picture);
    }

    public Car(String model, int year) {
      this.model=model;
      this.year=year;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return  brand ;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    int year;




}
