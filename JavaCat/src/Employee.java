import java.util.*;

class Employee implements Comparable<Employee> {
     String lastName;
    String firstName;
    String position;
     int age;
    double salary;

    public Employee(String lastName, String firstName, String position, int age, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.position = position;
        this.age = age;
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Employee emp) {
        int lastNameComparison = this.lastName.compareTo(emp.lastName);

        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        // If last names are equal, compare by first name
        return this.firstName.compareTo(emp.firstName);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName +" " + position + ", " + age + " years, " + salary;
    }
}
