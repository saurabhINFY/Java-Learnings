package org.learnings.streams.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.learnings.streams.dto.Student;
import org.learnings.streams.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private static Logger log = LogManager.getLogger(StudentServiceImpl.class.getName());

    private final List<Student> students;

    public StudentServiceImpl(List<Student> students) {
        this.students = students;
    }

    @Override
    public void findAllDepartmentNames() {
        log.info("started findAllDepartmentNames operation");
        List<String> result = this.students.stream().map(Student::getDepartment).toList();
        log.info("all departments are {}", result);
    }

    @Override
    public void findAverageAgeOfMaleAndFemaleStudents() {
        Map<String, Double> result = this.students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
    }

    @Override
    public void findAverageRankInAllDepartments() {
        Map<String, Double> result = this.students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.averagingInt(Student::getRank)));
    }

    @Override
    public void findCountOfStudentInEachDepartment() {
        log.info("Started findCountOfStudentInEachDepartment");
        Map<String, Long> result = this.students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        printHashMap(result);
    }

    @Override
    public void findDepartmentWithMaximumStudents() {
        log.info("started findDepartmentWithMaximumStudents");
        Entry<String, Long> result = this.students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();
        log.info(result.getKey() + ":- " + result.getValue());
    }

    @Override
    public void findHighestRankInEachDepartment() {
        this.students.stream()
                .collect(Collectors
                        .groupingBy(Student::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Student::getRank)),
                                        student -> student.stream().map(Student::getRank))));
    }

    @Override
    public void findListOfStudentRankedBetween(int startingRank, int endingRank) {
        log.info("started findListOfStudentRankedBetween");
        List<Student> result = this.students.stream()
                .filter(student -> student.getRank() >= startingRank && student.getRank() <= endingRank).toList();
        log.info("Students ranked between {} and {} are: {}", startingRank, endingRank, result.toArray().toString());
    }

    @Override
    public void findListOfStudentSortedByRank() {
        log.info("started findListOfStudentSortedByRank");
        List<Student> result = this.students.stream().sorted((s1, s2) -> s1.getRank() - s2.getRank()).toList();
        log.info("Students sorted by ranks are {} ", result.toArray().toString());
    }

    @Override
    public void findListOfStudentWhoseAgeGreaterThan(int age) {
        log.info("started findListOfStudentWhoseAgeGreaterThan");
        List<Student> result = this.students.stream().filter(student -> student.getAge() > age).toList();
        log.info("Student whose age greater than {} is {} ", age, result.toString());
    }

    @Override
    public void findListOfStudentWhoseAgeLessThan(int age) {
        log.info(" started findListOfStudentWhoseAgeLessThan");
        List<Student> result = this.students.stream().filter(student -> student.getAge() < age).toList();
        log.info("Student whose age less than {} is {} ", age, result.toString());
    }

    @Override
    public void findMaxAgeOfStudent() {
        log.info("started findMaxAgeOfStudent operation");
        long result = this.students.stream().max(Comparator.comparingInt(Student::getAge)).get().getAge();
        log.info("Max Age of Student is {}", result);
    }

    @Override
    public void findStudentWithSecondRank() {
        log.info("started findMaxAgeOfStudent operation");
        long result = this.students.stream().max(Comparator.comparingInt(Student::getRank)).get().getRank();
        log.info("Max Age of Student is {}", result);
    }

    @Override
    public void findStudentsWhoLivesIn(String city) {
    }

    @Override
    public void findTotalStudentCount() {
        log.info("started findTotalStudentCount");
        long result = this.students.size();
        log.info("Total student count:- {}", result);
    }

    @Override
    public void getStudentsWhoseNameStartsWithPrefix(String prefix) {
        List<Student> result = this.students.stream().filter(student -> student.getFirstName().startsWith(prefix))
                .toList();
    }

    @Override
    public void groupStudentByDepartmentName(String department) {
        Map<String, List<Student>> result = this.students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
    }

    private void printHashMap(Map<?, ?> map) {
        map.forEach((key, value) -> log.info("{}:- {}", key, value));
    }

}
