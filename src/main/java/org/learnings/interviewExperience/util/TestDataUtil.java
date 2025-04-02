package org.learnings.interviewExperience.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.learnings.interviewExperience.dto.Employee;
import org.learnings.interviewExperience.dto.Order;
import org.learnings.interviewExperience.dto.Product;
import org.learnings.interviewExperience.dto.Student;

public class TestDataUtil {
        public static List<Product> generateTestDataForProduct() {
                Product product1 = new Product(1001, "shirt", "Mens", 300.00);
                Product product2 = new Product(1002, "pant", "Mens", 514.45);
                Product product3 = new Product(1003, "watch", "Mens", 900.67);
                Product product4 = new Product(1005, "shoes", "Mens", 276.42);
                Product product5 = new Product(1005, "belt", "Mens", 319.57);
                Product product6 = new Product(1006, "jacket", "women", 718.25);
                Product product7 = new Product(1007, "glasses", "Mens", 494.37);
                Product product8 = new Product(1008, "shirt", "women", 890.90);
                Product product9 = new Product(1009, "belt", "women", 124.32);
                Product product10 = new Product(1010, "shoes", "women", 10340.23);
                List<Product> products = List.of(product1, product2, product3, product4, product5, product6, product7,
                                product8,
                                product9, product10);
                return products;
        }

        public static List<Order> generateTestDataForOrder(List<Product> products) {
                Order order1 = new Order(3001, products.subList(0, 3), "2024-04-12");
                Order order2 = new Order(3001, products.subList(4, 6), "2025-04-23");
                List<Order> orders = List.of(order1, order2);
                return orders;
        }

        public static List<Employee> generateTestDataForEmployee() {
                List<String> skills1 = Arrays.asList("Java", "Python", "Team Leadership");
                List<String> skills2 = Arrays.asList("C++", "Embedded Systems", "Problem-Solving");
                List<String> skills3 = Arrays.asList("Data Analysis", "SQL", "Machine Learning");
                List<String> skills4 = Arrays.asList("Marketing", "Communication", "SEO");
                List<String> skills5 = Arrays.asList("UI/UX Design", "Prototyping", "Graphic Design");

                // Example certifications for reuse
                Map<String, Date> certifications1 = new HashMap<>();
                certifications1.put("PMP", new GregorianCalendar(2019, Calendar.MARCH, 15).getTime());
                certifications1.put("AWS Certified Developer",
                                new GregorianCalendar(2020, Calendar.SEPTEMBER, 8).getTime());

                Map<String, Date> certifications2 = new HashMap<>();
                certifications2.put("Embedded Systems Specialist",
                                new GregorianCalendar(2018, Calendar.JUNE, 1).getTime());
                certifications2.put("Data Science Mastery",
                                new GregorianCalendar(2021, Calendar.FEBRUARY, 18).getTime());

                Map<String, Date> certifications3 = new HashMap<>();
                certifications3.put("Digital Marketing Expert",
                                new GregorianCalendar(2020, Calendar.DECEMBER, 10).getTime());
                certifications3.put("Certified UX Designer", new GregorianCalendar(2023, Calendar.MAY, 5).getTime());

                // Create 15 Employee objects
                List<Employee> employees = new ArrayList<>();

                employees.add(new Employee(1, "John Doe", "Engineering", 75000,
                                new GregorianCalendar(2019, Calendar.JANUARY, 15).getTime(), true, skills1,
                                certifications1));
                employees.add(new Employee(2, "Jane Smith", "Marketing", 65000,
                                new GregorianCalendar(2020, Calendar.MAY, 20).getTime(), true, skills4,
                                certifications3));
                employees.add(new Employee(3, "Alice Johnson", "R&D", 90000,
                                new GregorianCalendar(2018, Calendar.APRIL, 10).getTime(), true, skills2,
                                certifications2));
                employees.add(new Employee(4, "Robert Brown", "Data Science", 85000,
                                new GregorianCalendar(2022, Calendar.FEBRUARY, 25).getTime(), false, skills3,
                                certifications1));
                employees.add(new Employee(5, "Emily Clark", "Design", 68000,
                                new GregorianCalendar(2021, Calendar.JUNE, 15).getTime(), true, skills5,
                                certifications3));
                employees.add(new Employee(6, "Michael Wilson", "HR", 60000,
                                new GregorianCalendar(2017, Calendar.NOVEMBER, 5).getTime(), true,
                                Arrays.asList("Recruiting", "Conflict Resolution"), new HashMap<>()));
                employees.add(new Employee(7, "Sarah Davis", "Engineering", 77000,
                                new GregorianCalendar(2023, Calendar.JANUARY, 10).getTime(), true, skills1,
                                certifications1));
                employees.add(new Employee(8, "David Martinez", "R&D", 92000,
                                new GregorianCalendar(2020, Calendar.DECEMBER, 3).getTime(), false, skills2,
                                certifications2));
                employees.add(new Employee(9, "Jennifer Lewis", "Marketing", 63000,
                                new GregorianCalendar(2019, Calendar.AUGUST, 12).getTime(), true, skills4,
                                certifications3));
                employees.add(new Employee(10, "William Walker", "Data Science", 88000,
                                new GregorianCalendar(2021, Calendar.MARCH, 9).getTime(), true, skills3,
                                certifications2));
                employees.add(new Employee(11, "Jessica Hall", "Design", 70000,
                                new GregorianCalendar(2023, Calendar.JULY, 19).getTime(), false, skills5,
                                certifications3));
                employees.add(new Employee(12, "Thomas Young", "Engineering", 80000,
                                new GregorianCalendar(2016, Calendar.SEPTEMBER, 7).getTime(), true, skills1,
                                certifications1));
                employees.add(new Employee(13, "Linda Scott", "HR", 59000,
                                new GregorianCalendar(2018, Calendar.OCTOBER, 27).getTime(), false,
                                Arrays.asList("Employee Relations", "Payroll Management"), new HashMap<>()));
                employees.add(new Employee(14, "Charles Hernandez", "R&D", 94000,
                                new GregorianCalendar(2022, Calendar.MARCH, 15).getTime(), true, skills2,
                                certifications2));
                employees.add(new Employee(15, "Patricia Martinez", "Design", 72000,
                                new GregorianCalendar(2017, Calendar.AUGUST, 30).getTime(), true, skills5,
                                certifications3));

                return employees;
        }

        public static List<Integer> generateIntegerList() {
                return List.of(1, 2, 3, 4, 5, 6, 3, 4, 1, 2);
        }

        public static List<Integer> generateUniqueIntegers() {
                return List.of(1, 2, 3, 4, 5, 6);
        }

        public static List<String> generateListOfStrings() {
                return Arrays.asList("banana", "apple", "orange", "guava", "grapes", "blueberry");
        }

        public static List<Student> perpareStudentData() {
                return Arrays.asList(
                                new Student(1, "Rohit", "Mall", 30, "Male", Department.COMPUTER_SCIENCE.value, 2015,
                                                City.MUMBAI.value,
                                                122),
                                new Student(2, "Pulkit", "Singh", 56, "Male", Department.COMPUTER_SCIENCE.value, 2018,
                                                City.DELHI.value,
                                                67),
                                new Student(3, "Ankit", "Patil", 25, "Female", Department.MECHANICAL_ENGINEERING.value,
                                                2019, "Kerala",
                                                164),
                                new Student(4, "Satish Ray", "Malaghan", 30, "Male",
                                                Department.MECHANICAL_ENGINEERING.value, 2014,
                                                "Kerala", 26),
                                new Student(5, "Roshan", "Mukd", 23, "Male", Department.BIOTECH_ENGINEERING.value, 2022,
                                                City.MUMBAI.value, 12),
                                new Student(6, "Chetan", "Star", 24, "Male", Department.MECHANICAL_ENGINEERING.value,
                                                2023,
                                                City.BANAGLORE.value, 90),
                                new Student(7, "Arun", "Vittal", 26, "Male", Department.ELECTRONICS_ENGINEERING.value,
                                                2014,
                                                City.BANAGLORE.value, 324),
                                new Student(8, "Naman", "Dev", 31, "Male", Department.COMPUTER_SCIENCE.value, 2014,
                                                City.BANAGLORE.value,
                                                433),
                                new Student(9, "Sonu", "Shankar", 27, "Female", Department.COMPUTER_SCIENCE.value, 2018,
                                                City.NOIDA.value, 7),
                                new Student(10, "Shubham", "Pandey", 26, "Male",
                                                Department.INSTRUMENTATION_ENGINEERING.value, 2017,
                                                City.MUMBAI.value, 98));

        }

}
