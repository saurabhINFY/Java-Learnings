package org.learnings.interviewExperience;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.learnings.interviewExperience.util.TestDataUtil;

public class Practice1 {

    private static final List<String> fruits = TestDataUtil.generateListOfStrings();
    private static final List<Integer> duplicateNumbers = TestDataUtil.generateIntegerList();

    public static void groupByLengthAndCounting() {
        System.out.println("Group fruits by their length and count occurrences");
        fruits.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())).forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

    }

    public static void findStringWithMaximumLength() {
        System.out.println("Find the string with maximum length from fruits list");
        fruits.stream().max(Comparator.comparingInt(String::length)).ifPresent((s) -> {
            System.out.println("fruits with maximum length is: " + s);
        });
        ;
    }

    public static void uniqueNumbers() {
        System.out.println("Find numbers that occur only once in the duplicateNumbers list");
        System.out.println(
                duplicateNumbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream().filter((entry) -> entry.getValue() == 1)
                        .map((entry) -> entry.getKey()).collect(Collectors.toList()));
    }

    public static void maximumNumber() {
        System.out.println("Find the maximum number from duplicateNumbers list");
        System.out.println(
                "Maximum number is: " + duplicateNumbers.stream().max(Comparator.comparingInt((s) -> s)).get());
    }

    public static void printNumberAndTheirFrequency() {
        System.out.println("Print each number and its frequency from duplicateNumbers list");
        duplicateNumbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> {
                    System.out.println(k + ":" + v);
                });
    }

    public static void findDuplicateNumberFromList() {
        System.out.println("Find all numbers that occur more than once in duplicateNumbers list");
        System.out.println(
                duplicateNumbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream().filter((entry) -> entry.getValue() != 1)
                        .map((entry) -> entry.getKey())
                        .collect(Collectors.toList()));
    }

    public static void findNumberOccurringOnceFromList() {
        System.out.println("Find the first number that occurs more than once");
        System.out.println(
                duplicateNumbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream().filter((entry) -> entry.getValue() > 1)
                        .findFirst()
                        .map((entry) -> entry.getKey()).get());
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.out.println("Merge two sorted arrays nums1 and nums2 into a single sorted array");
        // Remove zeros, sort, and remove duplicates
        System.out.println(Stream.concat(Arrays.stream(nums1).boxed(), Arrays.stream(nums2).boxed()).distinct()
                .filter(num -> num != 0)
                .sorted()
                .collect(Collectors.toList()));
    }

    public static void printNumbersFromThread() {
        System.out.println("TODO: Implement thread-based number printing");
        // Create 3 threads to print numbers in some pattern
        Object lock = new Object();
        int[] counter = {2};
        Thread t1 = new Thread(() -> {
            while (counter[0] < 10) {
                synchronized (lock) {
                    if (counter[0] % 3 == 0) {
                        System.out.println("Thread 1: " + counter[0]);
                        counter[0]++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (counter[0] <= 10) {
                synchronized (lock) {
                    if (counter[0] % 2 == 0) {
                        System.out.println("Thread 2: " + counter[0]);
                        counter[0]++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (counter[0] <= 10) {
                synchronized (lock) {
                    if (counter[0] % 5 == 0) {
                        System.out.println("Thread 3: " + counter[0]);
                        counter[0]++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });
        Thread t4 = new Thread(() -> {
            while (counter[0] <= 10) {
                synchronized (lock) {
                    if (counter[0] % 7 == 0) {
                        System.out.println("Thread 4: " + counter[0]);
                        counter[0]++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public static void main(String[] args) {
        // groupByLengthAndCounting();
        // findStringWithMaximumLength();
        // uniqueNumbers();
        // maximumNumber();
        // printNumberAndTheirFrequency();
        // findDuplicateNumberFromList();
        // findNumberOccurringOnceFromList();
        // merge(new int[] { 7, 8, 9, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
        printNumbersFromThread();
    }
}
