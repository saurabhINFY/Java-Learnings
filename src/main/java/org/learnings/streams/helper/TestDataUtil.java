package org.learnings.streams.helper;

import java.util.Arrays;
import java.util.List;

import org.learnings.streams.Enum.City;
import org.learnings.streams.Enum.Department;
import org.learnings.streams.dto.Student;

public final class TestDataUtil {
    TestDataUtil() {
    }

    public static List<Student> perpareStudentData() {
        return Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", Department.COMPUTER_SCIENCE.value, 2015, City.MUMBAI.value,
                        122),
                new Student(2, "Pulkit", "Singh", 56, "Male", Department.COMPUTER_SCIENCE.value, 2018, City.DELHI.value,
                        67),
                new Student(3, "Ankit", "Patil", 25, "Female", Department.MECHANICAL_ENGINEERING.value, 2019, "Kerala",
                        164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", Department.MECHANICAL_ENGINEERING.value, 2014,
                        "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", Department.BIOTECH_ENGINEERING.value, 2022,
                        City.MUMBAI.value, 12),
                new Student(6, "Chetan", "Star", 24, "Male", Department.MECHANICAL_ENGINEERING.value, 2023,
                        City.BANAGLORE.value, 90),
                new Student(7, "Arun", "Vittal", 26, "Male", Department.ELECTRONICS_ENGINEERING.value, 2014,
                        City.BANAGLORE.value, 324),
                new Student(8, "Naman", "Dev", 31, "Male", Department.COMPUTER_SCIENCE.value, 2014,
                        City.BANAGLORE.value,
                        433),
                new Student(9, "Sonu", "Shankar", 27, "Female", Department.COMPUTER_SCIENCE.value, 2018,
                        City.NOIDA.value, 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", Department.INSTRUMENTATION_ENGINEERING.value, 2017,
                        City.MUMBAI.value, 98));

    }
}
