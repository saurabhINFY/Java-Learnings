package org.learnings.interviewExperience.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 * Employee record 
 */
public record Employee(int employeeId, String name, String department, double salary, Date hireDate,
        boolean isFullTime, List<String> skills, Map<String, Date> certifications) {
}