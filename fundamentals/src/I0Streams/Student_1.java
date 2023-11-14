package I0Streams;

import java.io.*;

class Learner_1 implements Serializable {
    public String name;
    public int age;
    public String subject;
    public int marks;

    public Learner_1(String name, int age, String subject, int marks) {
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.marks = marks;
    }
}

public class Student_1 {
    public static void main(String[] args) {
        Learner_1 learner1 = new Learner_1("lucky", 17, "JS", 90);
        Learner_1 learner2 = new Learner_1("John", 16, "Python", 80);
        Learner_1 learner3 = new Learner_1("Doe", 18, "Java", 95);
        Learner_1 learner4 = new Learner_1("Kath", 20, "Physics", 98);

        // Create an array to hold learners
        Learner_1[] learners = {learner1, learner2, learner3, learner4};

        // Serialize learners to a file
        String fileOutput = "object_data.ser";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileOutput))) {
            outputStream.writeObject(learners);
            System.out.println("Serialization successful.");
        } catch (IOException e) {
            System.out.println("An error occurred while serializing: " + e.getMessage());
        }
        // Deserialize learners from the file
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileOutput))) {
            Learner_1[] deserializedLearners = (Learner_1[]) inputStream.readObject();
            for (Learner_1 learner : deserializedLearners) {
                System.out.println("Name: " + learner.name);
                System.out.println("Age: " + learner.age);
                System.out.println("Subject: " + learner.subject);
                System.out.println("Marks: " + learner.marks);
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while deserializing: " + e.getMessage());
        }
    }
}