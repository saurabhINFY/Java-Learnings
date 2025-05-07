package org.learnings.interviewExperience;

import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.learnings.interviewExperience.dto.Employee;
import org.learnings.interviewExperience.dto.Order;
import org.learnings.interviewExperience.dto.Product;
import org.learnings.interviewExperience.util.TestDataUtil;

public class Practice2 {

    private static final List<Product> products = TestDataUtil.generateTestDataForProduct();
    private static final List<Order> orders = TestDataUtil.generateTestDataForOrder(products);
    private static final List<Employee> employees = TestDataUtil.generateTestDataForEmployee();

    public static void main(String[] args) {
        findExpensiveProductUnderCategory();
        findAveragePriceOfOrderGroupedByDates();
        fetchEmployeeEarningMoreThanGivenSalaryOrderByDate();
        groupEmployeesByDepartment();
        calculateAverageSalaryDepartmentWise();
        topThreeHighestEmployee();
        uniqueSkillsOfEmployee();
        findFirstEmployeeHiredAfter2020();
        employeeSortedByHireDate();
    }

    public static void findExpensiveProductUnderCategory() {
        Map<String, Optional<Product>> expensiveProductsForCategory = products.stream()
                                                                              .collect(Collectors.groupingBy(
                                                                                      Product::category,
                                                                                      Collectors.maxBy(
                                                                                              Comparator.comparingDouble(
                                                                                                      Product::price))));
        expensiveProductsForCategory.forEach((key, value) -> {
            System.out.println(key + " : " + value.get().name());
        });
    }

    public static void findAveragePriceOfOrderGroupedByDates() {
        System.out.println(orders.stream().collect(Collectors.groupingBy(Order::date)));
    }

    /**
     * Problem 1: Find all full-time employees earning more than $75,000 and sort them by hire date.
     */
    private static void fetchEmployeeEarningMoreThanGivenSalaryOrderByDate() {
        List<Employee> result = employees.stream().filter((emp) -> emp.salary() > 75000)
                                         .sorted(Comparator.comparing(Employee::hireDate))
                                         .toList();
        result.forEach(System.out::println);
    }

    /**
     * Problem 2: Group employees by their department.
     */
    private static void groupEmployeesByDepartment() {
        Map<String, List<Employee>> departmentWiseEmployees = employees.stream()
                                                                       .collect(Collectors.groupingBy(
                                                                               Employee::department,
                                                                               Collectors.toList()));
        departmentWiseEmployees.forEach((k, v) -> {
            System.out.println(k + " : " + v.stream().map(Employee::name));
        });
    }

    /**
     * Problem 3: Calculate the average salary of all employees in the "Engineering" department.
     */
    private static void calculateAverageSalaryDepartmentWise() {
        Map<String, Double> departmentWiseAverageSalary = employees.stream()
                                                                   .collect(Collectors.groupingBy(Employee::department,
                                                                           Collectors.averagingDouble(
                                                                                   Employee::salary)));
        departmentWiseAverageSalary.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
    }

    /**
     * Problem 4: Find the top 3 highest-paid employees.
     */
    private static void topThreeHighestEmployee() {
        List<Employee> result = employees.stream()
                                         .sorted(Comparator.comparingDouble(Employee::salary))
                                         .limit(3)
                                         .toList();
        result.forEach(System.out::println);
    }

    /**
     * Problem 5: Extract a list of all unique skills across all employees.
     */
    private static void uniqueSkillsOfEmployee() {
        List<String> uniqueSkills = employees.stream()
                                             .flatMap(employee -> employee.skills().stream())
                                             .distinct()
                                             .toList();
        uniqueSkills.forEach(System.out::println);
    }

    /**
     * Problem 6: Find the first employee hired after 2020.
     */
    private static void findFirstEmployeeHiredAfter2020() {
        Optional<Employee> employee = employees.stream()
                                               .filter(emp -> emp.hireDate()
                                                                 .after(new GregorianCalendar(2020, Calendar.DECEMBER,
                                                                         31).getTime()))
                                               .findFirst();
        employee.ifPresent(System.out::println);
    }

    /**
     * Problem 7: Sort employees by hire date and group them into two categories:
     * "Before 2020" and "After 2020".
     */
    private static void employeeSortedByHireDate() {
        employees.stream()
                 .sorted(Comparator.comparing(Employee::hireDate))
                 .collect(Collectors
                         .partitioningBy((emp) -> emp.hireDate()
                                                     .before(new GregorianCalendar(2020, Calendar.JANUARY,
                                                             1).getTime())))
                 .forEach((k, v) -> System.out.println(k.equals(true) ? "Before 2020"
                         : "After 2020" + " : " + v.stream().map(Employee::name).toList()));
    }
}
