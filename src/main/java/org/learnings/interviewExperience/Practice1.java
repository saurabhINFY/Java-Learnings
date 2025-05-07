package org.learnings.interviewExperience;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.learnings.interviewExperience.util.TestDataUtil;

public class Practice1 {

    private static final List<String> fruits = TestDataUtil.generateListOfStrings();
    private static final List<Integer> duplicateNumbers = TestDataUtil.generateIntegerList();

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
        duplicateNumbers.stream().max(Integer::compareTo).ifPresentOrElse(System.out::println, () -> {
            System.out.println("No such number");
        });
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
                                           .map(Entry::getKey)
                                           .toList());
    }

    public static void findNumberOccurringOnceFromList() {
        duplicateNumbers.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() > 1)
                        .findFirst()
                        .ifPresent(System.out::println);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        Stream<Integer> stream1 = Arrays.stream(nums1).boxed();
        Stream<Integer> stream2 = Arrays.stream(nums2).boxed();
        System.out.println(Stream.concat(stream1, stream2).filter((e) -> e != 0).sorted().distinct().toList());

    }

    public static void printNumbersFromThread() {


        Thread t1 = new Thread(()->{});
        Thread t2 = new Thread(()->{});
        Thread t3 = new Thread(()->{});

        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String[] args) {
        //        groupByLengthAndCounting();
        //        findStringWithMaximumLength();
        //        uniqueNumbers();
        //        maximumNumber();
        //        printNumberAndTheirFrequency();
        //        findDuplicateNumberFromList();
        //        findNumberOccurringOnceFromList();
        //        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        printNumbersFromThread();
    }
}
