package org.learnings.streams.Enum;

public enum Department {
    COMPUTER_SCIENCE("Computer Science"),
    MECHANICAL_ENGINEERING("Mechanical Engineering"),
    BIOTECH_ENGINEERING("Biotech Engineering"),
    ELECTRONICS_ENGINEERING("Electronics Engineering"),
    INSTRUMENTATION_ENGINEERING("Instrumentation Engineering");

    public final String value;
    Department(String value){
        this.value = value;
    }
}
