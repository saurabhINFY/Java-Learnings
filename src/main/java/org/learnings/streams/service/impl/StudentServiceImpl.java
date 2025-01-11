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

    public StudentServiceImpl( List<Student> students) {
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
        Map<String, Long> result = this.students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
    }

    @Override
    public void findDepartmentWithMaximumStudents() {
        Entry<String, Long> result = this.students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();

    }

    @Override
    public void  findHighestRankInEachDepartment() {
        this.students.stream()
                .collect(Collectors
                        .groupingBy(Student::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Student::getRank)),
                                        student -> student.stream().map(Student::getRank))));
    }

    @Override
    public void findListOfStudentRankedBetween(int startingRank, int endingRank) {
        List<Student> result = this.students.stream()
                .filter(student -> student.getRank() >= startingRank && student.getRank() <= endingRank).toList();
    }

    @Override
    public void findListOfStudentSortedByRank() {

        List<Student> result = this.students.stream().sorted((s1, s2) -> s1.getRank() - s2.getRank()).toList();
    }

    @Override
    public void findListOfStudentWhoseAgeGreaterThan(int age) {
        List<Student> result = this.students.stream().filter(student -> student.getAge() > age).toList();
    }

    @Override
    public void findListOfStudentWhoseAgeLessThan(int age) {
        List<Student> result = this.students.stream().filter(student -> student.getAge() < age).toList();
    }

    @Override
    public void findMaxAgeOfStudent() {
        log.info("started findMaxAgeOfStudent operation");
        long result = this.students.stream().max((s1, s2) -> s1.getAge() - s2.getAge()).get().getAge();
    }

    @Override
    public void findStudentWithSecondRank() {}

    @Override
    public void findStudentsWhoLivesIn(String city) {}

    @Override
    public void findTotalStudentCount() {
        long result = this.students.size();
    }

    @Override
    public void getStudentsWhoseNameStartsWithPrefix(String prefix) {
        List<Student> result = this.students.stream().filter(student -> student.getFirstName().startsWith(prefix)).toList();
    }

    @Override
    public void groupStudentByDepartmentName(String department) {
        Map<String, List<Student>> result = this.students.stream().collect(Collectors.groupingBy(Student::getDepartment));
    }

}
