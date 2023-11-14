package rca.java.CAT;
import java.io.*;
interface RadioTv {
    void watchTelevision();

    void playRadio();
}

interface AirConditioner {
    void manageTemperature();
}

class SeatNumberException extends RuntimeException {
    public SeatNumberException(String message) {
        super(message);
    }
}

public  class Car implements RadioTv,Serializable {
    private String color;
    private int numberOfSeats;
    private int minimumHeight;
    private int maximumHeight;

    public Car(String color, int numberOfSeats, int minimumHeight, int maximumHeight) {
        this.color = color;
        this.numberOfSeats = numberOfSeats;
        this.minimumHeight = minimumHeight;
        this.maximumHeight = maximumHeight;

        if (numberOfSeats > 100) {
            throw new SeatNumberException("The number of seats is beyond 100");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getMinimumHeight() {
        return minimumHeight;
    }

    public void setMinimumHeight(int minimumHeight) {
        this.minimumHeight = minimumHeight;
    }

    public int getMaximumHeight() {
        return maximumHeight;
    }

    public void setMaximumHeight(int maximumHeight) {
        this.maximumHeight = maximumHeight;
    }

    @Override
    public void watchTelevision() {
        System.out.println("Watching television...");
    }

    @Override
    public void playRadio() {
        System.out.println("Playing radio...");
    }
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", minimumHeight=" + minimumHeight +
                ", maximumHeight=" + maximumHeight +
                '}';
    }
}

