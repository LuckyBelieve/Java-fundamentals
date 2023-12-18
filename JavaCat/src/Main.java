import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Mugisha", "Mike", "Software Engineer", 20, 3000);
        Employee emp2 = new Employee("Mugisha", "Marc", "Database Administrator", 18, 2000);
        Employee emp3 = new Employee("Mugisha", "Moses", "Software Enginner", 20, 3000);
        Employee emp4 = new Employee("Iradukunda", "Sandra", "Database Administrator", 20, 3000);
        Employee emp5 = new Employee("Iradukunda", "Gael", "Software Engineer", 20, 3000);
//        Employee emp6 = new Employee("Iradukunda", "Agael", "Software Engineer", 20, 3000);

        Set<Employee> employees = new TreeSet<>();

        // Adding sample data to the treeSet
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
//        employees.add(emp6);

        // Displaying sorted employees to the console
        System.out.println("Sorted Employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}