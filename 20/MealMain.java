import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MealMain {
    public static void main(String[] args) {
        // --- Part 1: inner class ---
        Meal meal1 = new Meal("Classic Burger", 8.50);
        meal1.addToppings("lettuce", "tomato", "cheese", "bacon");
        meal1.printMeal();

        System.out.println();

        Meal meal2 = new Meal("Deluxe Burger", 11.00);
        meal2.addToppings("lettuce", "onion", "avocado", "mushroom", "ketchup");
        meal2.printMeal();

        System.out.println();

        // --- Part 2: local and anonymous classes ---
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Hanno", "Kalda",  LocalDate.of(2014, 3, 15)));
        employees.add(new Employee("Lembe", "Laht",   LocalDate.of(2012, 5, 3)));
        employees.add(new Employee("Jenni", "Järv",   LocalDate.of(2012, 7, 22)));
        employees.add(new Employee("Kaarel", "Mets",  LocalDate.of(2016, 11, 8)));
        employees.add(new Employee("Liisi", "Rand",   LocalDate.of(2021, 2, 17)));
        employees.add(new Employee("Pille", "Jõgi",   LocalDate.of(2001, 9, 30)));

        processEmployees(employees);
    }

    static void processEmployees(List<Employee> employees) {
        // local class with calculated fields
        class EmployeeInfo {
            Employee employee;
            String fullName;
            int yearsWorked;

            EmployeeInfo(Employee emp) {
                this.employee = emp;
                fullName = emp.firstName() + " " + emp.lastName();
                int currentYear = LocalDate.now().getYear();
                yearsWorked = currentYear - emp.hireDate().getYear();
            }

            @Override
            public String toString() {
                return fullName + " has been an employee for " + yearsWorked + " years";
            }
        }

        // two separate lists so each sort starts from original insertion order
        List<EmployeeInfo> byName  = new ArrayList<>();
        List<EmployeeInfo> byYears = new ArrayList<>();
        for (Employee emp : employees) {
            EmployeeInfo info = new EmployeeInfo(emp);
            byName.add(info);
            byYears.add(info);
        }

        // anonymous class: sort by full name
        byName.sort(new Comparator<EmployeeInfo>() {
            @Override
            public int compare(EmployeeInfo a, EmployeeInfo b) {
                return a.fullName.compareTo(b.fullName);
            }
        });
        byName.forEach(System.out::println);

        System.out.println();

        // anonymous class: sort by years worked
        byYears.sort(new Comparator<EmployeeInfo>() {
            @Override
            public int compare(EmployeeInfo a, EmployeeInfo b) {
                return Integer.compare(a.yearsWorked, b.yearsWorked);
            }
        });
        byYears.forEach(System.out::println);
    }
}
