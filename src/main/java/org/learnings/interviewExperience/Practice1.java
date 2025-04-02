package org.learnings.interviewExperience;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.learnings.interviewExperience.util.TestDataUtil;

public class Practice1 {

    private static List<String> fruits = TestDataUtil.generateListOfStrings();
    private static List<Integer> duplicateNumbers = TestDataUtil.generateIntegerList();

    public static void groupByLengthAndCounting() {
        System.out.println(fruits.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
    }

    public static void findStringWithMaximumLength() {
        System.out.println(fruits.stream().max(Comparator.comparing(String::length)));
    }

    public static void uniqueNumbers() {
        System.out.println(
                duplicateNumbers.stream().filter((num) -> Collections.frequency(duplicateNumbers, num) == 1).toList());
    }

    public static void maximumNumber() {
        System.out.println(duplicateNumbers.stream().max(Integer::compareTo).get());
    }

    public static void printNumberAndTheirFrequency() {
        System.out.println(
                duplicateNumbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    public static void findDuplicateNumberFromList() {
        System.out.println(duplicateNumbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter((entry) -> entry.getValue() > 1)
                .map((entry) -> entry.getKey())
                .toList());
    }

    public static void findNumberOccuringOnceFromList() {
        System.out.println(duplicateNumbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter((entry) -> entry.getValue() == 1)
                .map((entry) -> entry.getKey())
                .toList());
    }

    public static void main(String[] args) {
        // groupByLengthAndCounting();
        findStringWithMaximumLength();
        // uniqueNumbers();
        // maximumNumber();
        // printNumberAndTheirFrequency();
        // findDuplicateNumberFromList();
        // findNumberOccuringOnceFromList();
    }
}
