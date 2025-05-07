package org.learnings.interviewExperience;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.learnings.interviewExperience.dto.Student;
import org.learnings.interviewExperience.util.City;
import org.learnings.interviewExperience.util.Department;
import org.learnings.interviewExperience.util.TestDataUtil;

public class Practice3 {

    private static final List<Student> students = TestDataUtil.prepareStudentData();

    public static void main(String[] args) {
        groupStudentByDepartmentName(Department.COMPUTER_SCIENCE.value);
        findMaxAgeOfStudent();
        findDepartmentWithMaximumStudents();
        findStudentsWhoLivesIn(City.DELHI.value);
        findAverageAgeOfMaleAndFemaleStudents();
        findAverageRankInAllDepartments();
        findHighestRankInEachDepartment();
        findListOfStudentSortedByRank();
    }

    public static void findAllDepartmentNames() {

        System.out.println(students.stream().map(Student::department).toList());
    }

    public static void findAverageAgeOfMaleAndFemaleStudents() {
        System.out.println(students.stream()
                                   .collect(Collectors.groupingBy(Student::gender,
                                           Collectors.averagingInt(Student::age))));
    }

    public static void findAverageRankInAllDepartments() {
        System.out.println(students.stream()
                                   .collect(Collectors.groupingBy(Student::department,
                                           Collectors.averagingInt(Student::rank))));
    }

    public static void findCountOfStudentInEachDepartment() {
        System.out.println(
                students.stream().collect(Collectors.groupingBy(Student::department, Collectors.counting())));
    }

    public static void findDepartmentWithMaximumStudents() {
        Entry<String, Long> result = students.stream()
                                             .collect(Collectors.groupingBy(Student::department, Collectors.counting()))
                                             .entrySet()
                                             .stream()
                                             .max(Map.Entry.comparingByValue())
                                             .get();
    }

    public static void findHighestRankInEachDepartment() {
        System.out.println(students.stream()
                                   .collect(Collectors.groupingBy(
                                           Student::department,
                                           Collectors.collectingAndThen(
                                                   Collectors.maxBy(Comparator.comparingInt(Student::rank)),
                                                   optional -> optional.map(Student::rank).orElse(0)))));
    }

    public static void findListOfStudentRankedBetween(int startingRank, int endingRank) {
        System.out.println(students.stream()
                                   .filter(student -> student.rank() >= startingRank && student.rank() <= endingRank)
                                   .toList());
    }

    public static void findListOfStudentSortedByRank() {
        System.out.println(students.stream().sorted(Comparator.comparing(Student::rank)).toList());
    }

    public static void findListOfStudentWhoseAgeGreaterThan(int age) {
        System.out.println(students.stream().filter(student -> student.age() > age).toList());
    }

    public static void findListOfStudentWhoseAgeLessThan(int age) {
        System.out.println(students.stream().filter(student -> student.age() < age).toList());
    }

    public static void findMaxAgeOfStudent() {
        System.out.println(students.stream().max(Comparator.comparingInt(Student::age)).get().age());
    }

    public static void findStudentWithSecondRank() {
        System.out.println(students.stream().max(Comparator.comparingInt(Student::rank)).get().rank());
    }

    public static void findStudentsWhoLivesIn(String city) {
        System.out.println(students.stream().filter((student) -> city.equals(student.city())).findFirst()
                                   .map((matchedStudent) -> matchedStudent.firstName()
                                                                          .concat(" " + matchedStudent.lastName()))
                                   .orElse("No Student with matching city found"));
    }

    public static void findTotalStudentCount() {
        long result = students.size();
    }

    public static void getStudentsWhoseNameStartsWithPrefix(String prefix) {
        System.out.println(students.stream().filter(student -> student.firstName().startsWith(prefix))
                                   .toList());
    }

    public static void groupStudentByDepartmentName(String department) {
        Map<String, List<Student>> result = students.stream()
                                                    .collect(Collectors.groupingBy(Student::department));
        result.forEach((k, v) -> {
            System.out.println(k + " : " + v.stream().map(Student::firstName));
        });
    }

}
