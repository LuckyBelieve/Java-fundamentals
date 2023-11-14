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

    private String color;
    private int numberOfSeats;
    private int minimumHeight;
    private int maximumHeight;

    public Car(String color, int numberOfSeats, int minimumHeight, int maximumHeight) {
        this.color = color;
        this.numberOfSeats = numberOfSeats;
        this.minimumHeight = minimumHeight;
        this.maximumHeight = maximumHeight;
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
        System.out.println("Watching television in the car.");
    }

    @Override
    public void playRadio() {
        System.out.println("Playing radio in the car.");
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

class Toyota extends Car {
    public Toyota(String color, int numberOfSeats, int minimumHeight, int maximumHeight) {
        super(color, numberOfSeats, minimumHeight, maximumHeight);
    }
}

class Benz extends Car implements AirConditioner {
    public Benz(String color, int numberOfSeats, int minimumHeight, int maximumHeight) throws SeatNumberException {
        super(color, numberOfSeats, minimumHeight, maximumHeight);
        if (numberOfSeats > 100) {
            throw new SeatNumberException("The number of seats is beyond 100");
        }
    }

    @Override
    public void manageTemperature() {
        System.out.println("Managing temperature");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create objects
        Car car = new Car("Blue", 5, 150, 300);
        Toyota toyota = new Toyota("Red", 4, 140, 280);
        try {
            Benz benz = new Benz("Black", 100, 200, 500);
            // Handle SeatNumberException
        } catch (SeatNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Serialize and write to file
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("car.ser"))) {
            objectOutputStream.writeObject(car);
            objectOutputStream.writeObject(toyota);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read from file and display content
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("car.ser"))) {
            while (true) {
                try {
                    Car readCar = (Car) objectInputStream.readObject();
                    System.out.println(readCar);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
