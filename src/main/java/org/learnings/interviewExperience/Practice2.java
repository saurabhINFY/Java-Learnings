package org.learnings.interviewExperience;

import org.learnings.interviewExperience.dto.Employee;
import org.learnings.interviewExperience.dto.Order;
import org.learnings.interviewExperience.dto.Product;
import org.learnings.interviewExperience.util.TestDataUtil;

import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice2 {

    private static final List<Product> products = TestDataUtil.generateTestDataForProduct();
    private static final List<Order> orders = TestDataUtil.generateTestDataForOrder(products);
    private static final List<Employee> employees = TestDataUtil.generateTestDataForEmployee();

    public static void main(String[] args) {
        findExpensiveProductUnderCategory();
        findAveragePriceOfOrderGroupedByDates();
        calculateAveragePriceOfProductByCategory();
        findExpensiveProductByNameForEachCategory();
        ordersWithBabyCategoryProduct();
        averagePriceOfOrderGroupByOrderDate();
        fetchEmployeeEarningMoreThanGivenSalaryOrderByDate();
        groupEmployeesByDepartment();
        calculateAverageSalaryDepartmentWise();
        topThreeHighestEmployee();
        uniqueSkillsOfEmployee();
        findFirstEmployeeHiredAfter2020();
        employeeSortedByHireDate();

        // New Complex Problems
        findDepartmentWithHighestTotalSalaryAndSkillDiversity();
        calculateEmployeePerformanceScore();
        findMostValuableEmployeesPerDepartment();
        analyzeSkillGapsInDepartments();
        calculateProductProfitabilityMatrix();
        findOptimalProductRecommendations();
        detectSalaryAnomaliesInDepartments();
        calculateDepartmentTurnoverRisk();
        findSkillBasedTeamCombinations();
        analyzeEmployeeCertificationTrends();
    }

    /**
     * Problem 1: Find the most expensive product in each category.
     */
    public static void findExpensiveProductUnderCategory() {
        System.out.println("Find the most expensive product in each category");
        products.stream().collect(Collectors.groupingBy(Product::category,
                        Collectors.maxBy(Comparator.comparingDouble(Product::price))))
                .forEach((String k, Optional<Product> v) -> {
                    System.out.println(k + ":" + (v.isPresent() ? v.get() : "no product found"));
                });

    }

    /**
     * Problem 2: Find the average price of orders grouped by date.
     */
    public static void findAveragePriceOfOrderGroupedByDates() {
        System.out.println(orders.stream().collect(Collectors.groupingBy(Order::date, Collectors
                .flatMapping(order -> order.products().stream(), Collectors.averagingDouble(Product::price)))));

    }

    public static void calculateAveragePriceOfProductByCategory() {
        products.stream().collect(Collectors.groupingBy(Product::category, Collectors.averagingDouble(Product::price)))
                .forEach((k, v) -> {
                    System.out.println(k + ": " + v);
                });
    }

    /**
     * Problem 3: Find all full-time employees earning more than $75,000 and sort
     * them by hire date.
     */
    private static void fetchEmployeeEarningMoreThanGivenSalaryOrderByDate() {
        System.out.println(employees.stream().filter((employee -> employee.salary() > 75000))
                .sorted(Comparator.comparing(Employee::hireDate)).toList());
    }

    /**
     * Problem 4: Group employees by their department.
     */
    private static void groupEmployeesByDepartment() {
        employees.stream().collect(Collectors.groupingBy(Employee::department)).forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }

    /**
     * Problem 5: Calculate the average salary of all employees in the "Engineering"
     * department.
     */
    private static void calculateAverageSalaryDepartmentWise() {
        System.out.println("Calculate average salary by department");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.summarizingDouble(Employee::salary)))
                .forEach((k, v) -> {
                    System.out.println(k + ": " + v.getAverage());
                });
    }

    /**
     * Problem 6: Find the top 3 highest-paid employees.
     */
    private static void topThreeHighestEmployee() {
        System.out.println("Find top 3 highest-paid employees");
        System.out.println(employees.stream().sorted(Comparator.comparingDouble(Employee::salary)).limit(3).toList());
    }

    /**
     * Problem 7: Extract a list of all unique skills across all employees.
     */
    private static void uniqueSkillsOfEmployee() {
        System.out.println(employees.stream().flatMap((employee -> employee.skills().stream())).distinct().toList());
    }

    /**
     * Problem 8: Find the first employee hired after 2020.
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
     * Problem 9: Sort employees by hire date and group them into two categories:
     * "Before 2020" and "After 2020".
     */
    private static void employeeSortedByHireDate() {
        employees.stream().sorted(Comparator.comparing(Employee::hireDate)).collect(Collectors.partitioningBy(
                        (employee -> employee.hireDate().before(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime()))))
                .entrySet().forEach((booleanListEntry -> {
                    System.out.println(booleanListEntry.getKey() ? "before_2020" : "after_2020" + ": " + booleanListEntry.getValue());
                }));
    }

    /**
     * Problem 10: Find the most expensive product by name for each category.
     */
    private static void findExpensiveProductByNameForEachCategory() {
        products.stream().collect(
                        Collectors.groupingBy(Product::category, Collectors.collectingAndThen(Collectors.toList(), (lst) -> {
                            return lst.stream().max(Comparator.comparingDouble(Product::price))
                                    .map(Product::name).orElse("No product found");
                        })))
                .forEach((k, v) -> System.out.println(k + ": " + v));
    }

    /**
     * Problem 11: Find the average price of orders grouped by order date.
     */
    private static void averagePriceOfOrderGroupByOrderDate() {
        System.out.println(orders.stream().collect(Collectors.groupingBy(Order::date, Collectors.flatMapping((order -> order.products().stream()),
                Collectors.averagingDouble(Product::price)))));
    }

    /**
     * Problem 12: Returns a list of orders that contain at least one product in the "Baby" category using flatMap.
     */
    private static void ordersWithBabyCategoryProduct() {
        System.out.println(orders.stream().filter(order -> order.products().stream()
                        .anyMatch(product -> "Baby".equals(product.category())))
                .collect(Collectors.toList()));
    }

    /**
     * PROBLEM 1: Advanced Department Analysis
     * Find the department with the highest combined salary budget AND highest skill diversity.
     * Return a map with department name as key and a custom object containing:
     * - Total salary budget
     * - Number of unique skills
     * - Skill diversity score (unique skills / total employees)
     * - Average years of experience
     */
    private static void findDepartmentWithHighestTotalSalaryAndSkillDiversity() {
        Map<String, Map<String, Object>> departmentWiseAnalysis = employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.collectingAndThen(Collectors.toList(), deptEmployees -> {
            double totalSalary = deptEmployees.stream().mapToDouble(Employee::salary).sum();
            long uniqueSkills = deptEmployees.stream().flatMap(emp -> emp.skills().stream()).distinct().count();
            double skillDiversity = (double) uniqueSkills / deptEmployees.size();
            double avgExperience = deptEmployees.stream().mapToInt(Employee::yearsOfExperience).average().orElse(0);
            Map<String, Object> analysis = new LinkedHashMap<>();
            analysis.put("totalSalary", totalSalary);
            analysis.put("uniqueSkills", uniqueSkills);
            analysis.put("skillDiversity", skillDiversity);
            analysis.put("averageExperience", avgExperience);
            return analysis;
        })));
        departmentWiseAnalysis.entrySet().stream()
                .max(Comparator.comparingDouble((Map.Entry<String, Map<String, Object>> entry) -> ((Number) entry.getValue().get("totalSalary")).doubleValue())
                        .thenComparingDouble(entry -> ((Number) entry.getValue().get("skillDiversity")).doubleValue()))
                .ifPresent(entry -> System.out.println("Department with highest salary and skill diversity: " + entry.getKey()));
    }

    /**
     * PROBLEM 2: Employee Performance Scoring
     * Calculate a performance score for each employee based on:
     * - Salary percentile within department (30% weight)
     * - Number of skills (25% weight)
     * - Years of experience (20% weight)
     * - Number of certifications (25% weight)
     * Return top 5 performers across all departments
     */
    private static void calculateEmployeePerformanceScore() {
        Map<String, List<Map.Entry<String, Double>>> result = employees.stream().collect(Collectors.groupingBy(Employee::department,
                Collectors.collectingAndThen(Collectors.toList(), departmentEmployees -> {
                    double maxSalary = departmentEmployees.stream().mapToDouble(Employee::salary).max().orElse(0);
                    return departmentEmployees.stream().map(depEmployee -> {
                        double salaryPercentile = 0.30 * (depEmployee.salary() / maxSalary);
                        double skillScore = 0.25 * (depEmployee.skills().size());
                        double yoeScore = 0.20 * (depEmployee.yearsOfExperience());
                        double certificationScore = 0.25 * (depEmployee.yearsOfExperience());
                        double performanceScore = Double.valueOf(salaryPercentile + skillScore + yoeScore + certificationScore).intValue();
                        return Map.entry(depEmployee.name(), performanceScore);
                    }).toList().stream().sorted(Comparator.comparingDouble(Map.Entry::getValue)).limit(5).toList();
                })));
        System.out.println("Top 5 performer across all departments");
        result.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }

    /**
     * PROBLEM 3: Multi-Criteria Employee Ranking
     * Find the most "valuable" employee in each department based on:
     * - Highest salary
     * - Most skills
     * - Most recent hire (if tie in above criteria)
     * Return a map where key is department and value is the most valuable employee
     */
    private static void findMostValuableEmployeesPerDepartment() {
        Map<String, Optional<Employee>> result = employees.stream().collect(Collectors.groupingBy(Employee::department,
                Collectors.maxBy(Comparator.comparing(Employee::salary).thenComparing(employee -> employee.skills().size()).thenComparing(Employee::hireDate)
                )));
        System.out.println("Most Valuable Employee in departments");
        result.forEach((k, v) -> {
            System.out.println(k + ": " + v.get().name());
        });
    }

    /**
     * PROBLEM 4: Skill Gap Analysis
     * For each department, find:
     * - Skills that are missing (present in other departments but not in this one)
     * - Skill redundancy (skills that more than 50% of department employees have)
     * - Recommended skills to acquire (top 3 missing skills)
     * Return a complex nested map structure
     */
    private static void analyzeSkillGapsInDepartments() {
        Set<String> allCompanySkills = employees.stream().flatMap(employee -> employee.skills().stream()).collect(Collectors.toSet());
        Map<String, Long> allSkillFrequencies = employees.stream()
                .flatMap(employee -> employee.skills().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Map<String, Object>> result = employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.collectingAndThen(Collectors.toList(), (List<Employee> deptEmployees) -> {
            Set<String> departmentSkill = deptEmployees.stream().flatMap(deptEmployee -> deptEmployee.skills().stream()).collect(Collectors.toSet());
            // a. skills that are missing
            Set<String> missingSkills = new HashSet<>(allCompanySkills);
            missingSkills.removeAll(departmentSkill);

            int departmentEmployeeSize = deptEmployees.size();
            // b. skills which are redundant
            List<String> redundantSkills = deptEmployees.stream().flatMap(dep -> dep.skills().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream().filter(skillFreqEntry -> skillFreqEntry.getValue() > departmentEmployeeSize / 2)
                    .map(Map.Entry::getKey)
                    .toList();
            // c. top 3 recommended skills
            List<String> recommendedSkills = deptEmployees.stream().flatMap(dep -> dep.skills().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream().sorted(Comparator.comparing(allSkillFrequencies::get).reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
            // d. putting all together
            Map<String, Object> analysis = new LinkedHashMap<>();
            analysis.put("missingSkills", missingSkills);
            analysis.put("skillRedundancy", redundantSkills);
            analysis.put("recommendedSkills", recommendedSkills);
            return analysis;
        })));
        System.out.println(result);
    }

    /**
     * PROBLEM 5: Product Profitability Matrix
     * Create a profitability analysis matrix showing:
     * - Revenue per product category
     * - Order frequency per category
     * - Average order value per category
     * - Profit margin estimation (assume 30% margin on high-value items >500, 15% on others)
     * Return a map with category as key and profitability metrics as value
     */
    private static void calculateProductProfitabilityMatrix() {
        // TODO: Implement profitability matrix calculation
        // Hint: Use groupingBy with downstream collectors
        // Consider custom collector for complex calculations
    }

    /**
     * PROBLEM 6: Product Recommendation Engine
     * Based on order history, recommend products for each customer:
     * - Find products frequently bought together (market basket analysis)
     * - Exclude products already purchased by the customer
     * - Rank recommendations by popularity and price similarity
     * Return top 3 recommendations per customer
     */
    private static void findOptimalProductRecommendations() {
        // TODO: Implement recommendation algorithm
        // Hint: Use combinations, flatMap, and correlation analysis
        // Consider using custom collectors for co-occurrence calculation
    }

    /**
     * PROBLEM 7: Salary Anomaly Detection
     * Detect salary anomalies in each department:
     * - Find employees whose salary is >2 standard deviations from department mean
     * - Identify potential underpaid employees (bottom 10% with high skill count)
     * - Flag overpaid employees (top 10% with low skill count)
     * Return a map with anomaly type as key and list of employees as value
     */
    private static void detectSalaryAnomaliesInDepartments() {
        // TODO: Implement anomaly detection
        // Hint: Calculate statistics using summarizing collectors
        // Consider using mathematical functions for standard deviation
    }

    /**
     * PROBLEM 8: Department Turnover Risk Calculation
     * Calculate turnover risk for each department based on:
     * - Average tenure (higher tenure = lower risk)
     * - Salary satisfaction (salary vs department average)
     * - Skill utilization (are high-skilled employees in appropriate roles?)
     * - Age distribution (too many senior employees = higher retirement risk)
     * Return risk score (0-100) for each department
     */
    private static void calculateDepartmentTurnoverRisk() {
        // TODO: Implement turnover risk calculation
        // Hint: Use multiple metrics and weighted scoring
        // Consider age calculation from hire date
    }

    /**
     * PROBLEM 9: Optimal Team Formation
     * Find optimal team combinations where:
     * - Team has 3-5 members
     * - Combined skills cover at least 8 different skill areas
     * - Total salary is within budget range (300k-500k)
     * - At least one member from each of 2 different departments
     * Return all possible valid team combinations
     */
    private static void findSkillBasedTeamCombinations() {
        // TODO: Implement team formation algorithm
        // Hint: Use combinations, filtering, and complex validation
        // Consider recursive or iterative approach for combinations
    }

    /**
     * PROBLEM 10: Certification Trend Analysis
     * Analyze certification trends:
     * - Find certifications that are trending (acquired in last 2 years)
     * - Calculate certification ROI (salary increase correlation)
     * - Identify certification gaps by department
     * - Predict future certification needs based on industry trends
     * Return comprehensive certification analytics
     */
    private static void analyzeEmployeeCertificationTrends() {
        // TODO: Implement certification trend analysis
        // Hint: Use date comparisons, correlation analysis
        // Consider time-based grouping and trend calculation
    }
}
