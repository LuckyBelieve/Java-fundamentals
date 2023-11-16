package rca.java;

import java.io.*;

interface RadioTelevision {
    void watchTelevision();
    void playRadio();
}

interface AirConditioner {
    void manageTemperature();
}

class SeatNumberException extends Exception {
    public SeatNumberException(String message) {
        super(message);
    }
}

class Car implements RadioTelevision, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String color;
    private final int numberOfSeats;
    private final int minimumHeight;
    private final int maximumHeight;

    public Car(String color, int numberOfSeats, int minimumHeight, int maximumHeight) {
        this.color = color;
        this.numberOfSeats = numberOfSeats;
        this.minimumHeight = minimumHeight;
        this.maximumHeight = maximumHeight;
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getMinimumHeight() {
        return minimumHeight;
    }

    public int getMaximumHeight() {
        return maximumHeight;
    }

    @Override
    public void watchTelevision() {
        System.out.println("Watch television in the car.");
    }

    @Override
    public void playRadio() {
        System.out.println("Play radio in the car.");
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", minimumHeight=" + minimumHeight +
                ", maximumHeight=" + maximumHeight +
                '}';
    }
}



//toyota class
class Toyota extends Car {
    public Toyota(String color, int numberOfSeats, int minimumHeight, int maximumHeight) {
        super(color, numberOfSeats, minimumHeight, maximumHeight);
    }
    public String toString() {
        return "Toyota{" +
                "color='" + super.getColor() + '\'' +
                ", numberOfSeats=" + super.getNumberOfSeats() +
                ", minimumHeight=" + super.getMinimumHeight() +
                ", maximumHeight=" + super.getMaximumHeight() +
                '}';
    }
}


//benz class

class Benz extends Car implements AirConditioner {
    public Benz(String color, int numberOfSeats, int minimumHeight, int maximumHeight) throws SeatNumberException {
        super(color, numberOfSeats, minimumHeight, maximumHeight);
        if (numberOfSeats > 100) {
            throw new SeatNumberException("The number of seats of benz is beyond 100");
        }
    }
    public String toString() {
        return "Benz{" +
                "color='" + super.getColor() + '\'' +
                ", numberOfSeats=" + super.getNumberOfSeats() +
                ", minimumHeight=" + super.getMinimumHeight() +
                ", maximumHeight=" + super.getMaximumHeight() +
                '}';
    }

    @Override
    public void manageTemperature() {
        System.out.println("Managing temperature");
    }
}



//main class

public class Main {
    public static void main(String[] args) {
        // Create objects
        Car car = new Car("Blue", 115, 150, 300);
        Toyota toyota = new Toyota("Red", 124, 140, 280);
        Benz Benz1 = null;
        try {
            Benz1 = new Benz("Black", 130, 200,500);
        } catch (SeatNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Serialize and write to file
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("carObject.ser"))) {
            objectOutputStream.writeObject(car);
            objectOutputStream.writeObject(toyota);
            if (Benz1 != null){
                objectOutputStream.writeObject(Benz1);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Read from file and display content
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("carObject.ser"))) {
            while (true) {
                try {
                    Car readCar = (Car) objectInputStream.readObject();
                    System.out.println(readCar);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
