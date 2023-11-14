package rca.java.CAT;

import java.io.*;

public class Benz extends Car implements AirConditioner {

    public Benz(String color, int numberOfSeats, int minimumHeight, int maximumHeight) {
        super(color, numberOfSeats, minimumHeight, maximumHeight);
        setMinimumHeight(200);
        setMaximumHeight(500);
    }

    @Override
    public void manageTemperature() {
        System.out.println("Manage temperature...");
    }

    public static void main(String[] args) {
//         this is the block of codes for inserting the data into the file

        try{
            Car Benz1 = new Benz("blue",50,100,150);
            System.out.println(Benz1);
            FileOutputStream file = new FileOutputStream("CarObject.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(Benz1);
        }catch (SeatNumberException e){
            System.out.println(e.getMessage());
        }
        catch (Exception objectStream){
            System.out.println("the error related to objectOutputStream");
        }

//        this is the block of codes for reading the data from the file and output them to the console

        try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream("carObject.ser"))) {
            while (true) {
                try {
                    Car returnedBenz= (Car) objectInput.readObject();
                    System.out.println(returnedBenz);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
