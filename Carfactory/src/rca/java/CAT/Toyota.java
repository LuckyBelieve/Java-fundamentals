package rca.java.CAT;

import java.io.*;

public class Toyota extends Car {
    public Toyota(String color, int numberOfSeats, int minimumHeight, int maximumHeight) {
        super(color, numberOfSeats, minimumHeight, maximumHeight);
    }

     public static void main(String[] args) {
         try{
             Car Toyota1 = new Toyota("blue",50,100,150);
             System.out.println(Toyota1);
             FileOutputStream file = new FileOutputStream("CarObject.ser");
             ObjectOutputStream out = new ObjectOutputStream(file);
             out.writeObject(Toyota1);
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
