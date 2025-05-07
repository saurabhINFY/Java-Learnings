package org.learnings.interviewExperience.dto;

public record Student(int id, String firstName, String lastName, int age, String gender, String department,
                      int joinedYear,
                      String city, int rank) {

    @Override public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", joinedYear=" + joinedYear +
                ", city='" + city + '\'' +
                ", rank=" + rank +
                '}';
    }
}
