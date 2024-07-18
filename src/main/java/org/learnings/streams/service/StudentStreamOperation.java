package org.learnings.streams.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.learnings.streams.dto.Student;

public interface StudentStreamOperation {

    List<Student> getStudentsWhoseNameStartsWithPrefix(String prefix);
    Map<String,List<Student>> groupStudentByDepartmentName(String department);
    long findTotalStudentCount();
    long findMaxAgeOfStudent();
    List<String> findAllDepartmentNames();
    Map<String,Long> findCountOfStudentInEachDepartment();
    List<Student> findListOfStudentWhoseAgeLessThan(int age);
    List<Student> findListOfStudentWhoseAgeGreaterThan(int age);
    List<Student> findListOfStudentRankedBetween(int startingRank, int endingRank);
    Map<String,Long> findAverageAgeOfMaleAndFemaleStudents();
    Entry<String,Long> findDepartmentWithMaximumStudents();
    List<Student> findStudentsWhoLivesIn(String city);
    Map<String,Double> findAverageRankInAllDepartments();
    Map<String,Student> findHighestRankInEachDepartment();
    List<Student> findListOfStudentSortedByRank();
    Student findStudentWithSecondRank();

}
