/**
        * nob The group of classes on collections
        */
        package nob;

import java.util.Objects;

/**
 * the student class with compareTo method to facilitate sorting, hashCode , equals overriden
 * The student has details information about names and identification
 */

public class Student implements Comparable{
    /**
     * Student email
     */
    private String email;
    /**
     * Unique code for student
     */
    private Integer id;
    /**
     * A private student first name
     */
    private String firstName;

    /**
     *
     * @param email for constructor
     * @param id for constructor
     * @param firstName for constructor
     * Parameterised constructor to initialise a student during object creation
     */

    public Student(String email, Integer id, String firstName) {
        this.email = email;
        this.id = id;
        this.firstName = firstName;
    }

    /**
     *
     * @return the email of the student
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email for setter
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return the code/Id of the student
     */

    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id for setter
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return the first name of the student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName for setter
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//    public boolean equals(Object obj) {
//        Student student = (Student) obj;
//        return this.id.equals(student.id) && this.firstName.equals(student.firstName) && this.email.equals(student.email);
//    }
//    public int hashCode(){
//        return this.id.hashCode()+this.firstName.hashCode()+this.email.hashCode();
//    }

    /**
     *
     * @param o for verifying the equality of objects
     * @return the unrepeated variables of the class
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(email, student.email) && Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName);
    }
    /**
     *
     * @return the unrepeated variables
     */
    @Override
    public int hashCode() {
        return Objects.hash(email, id, firstName);
    }

    /**
     *
     * @param o the object to be compared.
     * @return the results of the comparison
     */
    @Override
    public int compareTo(Object o) {
        Student st = (Student)o;
        if (this.id.compareTo(st.id) != 0)
            return this.id.compareTo(st.id);
        if (this.firstName.compareTo(st.firstName) != 0)
            return this.firstName.compareTo(st.firstName);

        return this.email.compareTo(st.email);
    }
}