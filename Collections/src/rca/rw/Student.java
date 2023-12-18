/**
 * rca.rw the group about the classes anf collections
 */
package rca.rw;
import java.util.Objects;

/**
 * the student class with compareTo method to facilitate sorting and hashcode
 * @author lucky
 */
public class Student implements Comparable {
    /**
     * code Unique code for student
     */
    Integer code;
    /**
     * firstname  Private name for student
     */
    String firstname;
    /**
     * email Private email for student
     */
    String Email;

    /**
     *
     * @param code of student
     * @param firstname religious name of a student
     * @param email associated with the student
     */
    public Student(Integer code,String firstname,String email){
        this.code = code;
        this.firstname = firstname;
        this.Email = email;
    }

    /**
     *
     * @return to code
     */
    public Integer getCode() {
        return code;
    }

    /**
     *
     * @param code to set the student code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     *
     * @return the student firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param firstname to set the student's firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *
     * @return the email of the student
     */
    public String getEmail() {
        return Email;
    }

    /**
     *
     * @param email to set the student's email
     */
    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "rca.rw.Student{" +
                "code=" + code +
                ", firstname='" + firstname + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        rca.rw.Student student = (rca.rw.Student) o;
//        return this.code.equals(student.code)  && Objects.equals(firstname, student.firstname) && Objects.equals(Email, student.Email);
//    }
//
//    @Override
//    public int hashCode() {
//        return this.code.hashCode()+this.firstname.hashCode()+this.Email.hashCode();
//    }

    /**
     *
     * @param o to compare to the student instances
     * @return the boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(code, student.code) && Objects.equals(firstname, student.firstname) && Objects.equals(Email, student.Email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, firstname, Email);
    }

    /**
     *
     * <h2>compareTO method</h2> compares this object with the object representing a student p
     * object is casted first as
     */

    public int compareTo(Object o) {
        Student st = (Student) o;
        if (this.code.compareTo(st.code) != 0)
            return this.code.compareTo(st.code);
        if (this.firstname.compareTo(st.firstname) != 0)
            return this.firstname.compareTo(st.firstname);

        return -this.Email.compareTo(st.Email);

    }
}
