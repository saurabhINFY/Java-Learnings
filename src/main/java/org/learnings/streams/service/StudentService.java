package org.learnings.streams.service;

public interface StudentService {

    public void getStudentsWhoseNameStartsWithPrefix(String prefix);

    public void groupStudentByDepartmentName(String department);

    public void findTotalStudentCount();

    public void findMaxAgeOfStudent();

    public void findAllDepartmentNames();

    public void findCountOfStudentInEachDepartment();

    public void findListOfStudentWhoseAgeLessThan(int age);

    public void findListOfStudentWhoseAgeGreaterThan(int age);

    public void findListOfStudentRankedBetween(int startingRank, int endingRank);

    public void findAverageAgeOfMaleAndFemaleStudents();

    public void findDepartmentWithMaximumStudents();

    public void findStudentsWhoLivesIn(String city);

    public void findAverageRankInAllDepartments();

    public void findHighestRankInEachDepartment();

    public void findListOfStudentSortedByRank();

    public void findStudentWithSecondRank();

}
