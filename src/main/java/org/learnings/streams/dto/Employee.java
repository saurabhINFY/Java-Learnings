package org.learnings.streams.dto;

import java.util.List;

public record Employee(int id, String name, String dept, List<Tech> techStacks, double salary) {

    private static int COUNT = 0;

    public static void createEmployeeEntry() {
        COUNT++;
    }
    public Employee(int id, String name, String dept, List<Tech> techStacks, double salary) {
        if (COUNT > 100) {
            throw new IllegalArgumentException("Cannot create more Employees");
        } else if (id <= 0) {
            throw new IllegalArgumentException("Id cannot be negative or 0");
        } else if (name.length() > 100) {
            throw new IllegalArgumentException("name cannot be more than 100 chars");
        } else {
            this.name = name;
            this.dept = dept;
            this.id = id;
            this.techStacks = techStacks;
            this.salary = salary;
            createEmployeeEntry();
        }

    }
}
