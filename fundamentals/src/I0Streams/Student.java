package I0Streams;

import java.io.*;

public class Student implements Serializable {
    private String name;
    private int id;
    private double marks;

    public Student(String name, int id, double marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [Name: " + name + ", ID: " + id + ", Marks: " + marks + "]";
    }

    public static void main(String[] args) {
        // Creating Student objects
        Student student1 = new Student("John", 1, 85.5);
        Student student2 = new Student("Alice", 2, 92.0);

        // Printing student information
        System.out.println(student1);
        System.out.println(student2);

        // Serialization
        try {
            // Saving Student objects to a file
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.ser"));
            out.writeObject(student1);
            out.writeObject(student2);
            out.close();

            // Loading Student objects from the file
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.ser"));
            Student loadedStudent1 = (Student) in.readObject();
            Student loadedStudent2 = (Student) in.readObject();
            in.close();

            System.out.println("Loaded Student 1: " + loadedStudent1);
            System.out.println("Loaded Student 2: " + loadedStudent2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
