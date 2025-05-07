package org.learnings.interviewExperience;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice4 {

    public static void main(String[] args) {
        findOccurrence();
        findDuplicateElement();
        isPrimeNumber(7);
        doFlatMapOperation();
        findSqrtForFirst10PrimeNumber();
        findLongestString();
        printPrime();
        mergeTwoListIntoOne();
        intersectionOfTwoList();
        findMissingLetter();
        secondDuplicateFromList();
        findAnagramStrings();
    }

    private static void findAnagramStrings() {
        String[] input = new String[]{"listen", "silent", "enlist", "rat", "tar", "god", "dog"};
        System.out.println(Arrays.stream(input).collect(Collectors.groupingBy((str) -> {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        }, Collectors.toList())));
    }

    public static void findOccurrence() {
        String str = "welcome to code decode and code decode welcome you";
        System.out.println(Arrays.stream(str.split(" "))
                                 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    public static void findDuplicateElement() {
        List<Integer> myList = List.of(10, 28, 87, 10, 20, 76, 28, 80);
        Set<Integer> mySet = new HashSet<>();
        myList.stream().filter(item -> !mySet.add(item)).forEach(System.out::println);
    }

    public static void isPrimeNumber(int number) {
        System.out.println(number > 1 && IntStream.range(2, number).noneMatch(n -> number % n == 0));
    }

    public static void doFlatMapOperation() {
    }

    public static void findSqrtForFirst10PrimeNumber() {
        List<Double> result = Stream.iterate(1, i -> i + 1)
                                    .filter(num -> num > 1 && IntStream.range(2, num).noneMatch(n -> num % n == 0))
                                    .map(Math::sqrt)
                                    .limit(10)
                                    .collect(Collectors.toList());
        System.out.println(result);
    }

    public static void findLongestString() {
        List<String> fruits = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");
        String longestString = fruits.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println(longestString);
    }

    public static void printPrime() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);
        boolean isPrime = numbers.stream().anyMatch((number) ->
                number <= 1 || IntStream.range(2, Integer.parseInt(String.valueOf(Math.sqrt(number))))
                                        .allMatch(x -> number % x != 0));
        System.out.println(isPrime);
    }

    public static void mergeTwoListIntoOne() {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> sortedList = Stream.concat(list1.stream(), list2.stream()).sorted().toList();
        System.out.println(sortedList);
    }

    public static void intersectionOfTwoList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> intersection = list1.stream()
                                          .filter(list2::contains)
                                          .toList();
        System.out.println(intersection);
    }

    public static void findMissingLetter() {
        String input = "Saurabh Shrijan"; // []
        Set<String> englishAlphabets = IntStream.range('a', 'z')
                                                .mapToObj(c -> Character.toString((char) c))
                                                .collect(Collectors.toSet());
        Set<String> keys = Arrays.stream(input.toLowerCase().replaceAll("\\s", "")
                                              .split(""))
                                 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                 .keySet();
        List<String> missingLetters = englishAlphabets.stream().filter((alphabet) -> !keys.contains(alphabet)).toList();
        System.out.println(missingLetters);
        Stream.generate(() -> new Random().nextInt(100)).limit(10).forEach(System.out::println);
    }

    public static void secondDuplicateFromList() {
        int[] input = {5, 3, 8, 3, 2, 1, 8, 7, 2};
        Set<Integer> set = new HashSet<>();
        Arrays.stream(input).filter(ele -> !set.add(ele)).skip(1)
              .findFirst().ifPresentOrElse(
                      (res) -> System.out.println("second duplicate is " + res),
                      () -> System.out.println("No Duplicates"));
    }
}
