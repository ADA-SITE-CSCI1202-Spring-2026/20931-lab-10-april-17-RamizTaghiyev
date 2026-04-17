import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() { 
        return firstName; 
    }
    public String getLastName() { 
        return lastName; 
    }
    public double getSalary() { 
        return salary; 
    }
}

public class EmployeeMapping {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Emp1", "Surname1", 850010.0));
        employees.add(new Employee("Emp2", "Surname2", 920300.50));
        employees.add(new Employee("Emp3", "Surname3", 780300.0));

        Function<Employee, String> formatCard = e -> 
            "Name: [" + e.getLastName() + ", " + e.getFirstName() + "] - Salary: $" + e.getSalary();

        Function<Employee, Double> salaryPicker = Employee::getSalary;

        for (Employee emp : employees) {
            String card = formatCard.apply(emp);
            Double salary = salaryPicker.apply(emp);
            
            System.out.println(card);
            System.out.println("salary: " + salary);
        }
    }
}