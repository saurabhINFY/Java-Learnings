package org.learnings.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.learnings.streams.dto.Employee;
import org.learnings.streams.dto.Tech;

public class StreamOperations {

    private static final Logger logger = Logger.getLogger(StreamOperations.class.getName());

    public static void findOccurrence() {
        /* Count number of Occurrence of given word in the string
        input : "welcome to code decode and code decode welcome you"
        output: {code:2,and:1,to:1,decode:2,welcome:2,you:1}
        */
        /*
         approach 1: Non Stream approach
         String str = "welcome to code decode and code decode welcome you";
         Map<String,Integer> mp = new HashMap<String,Integer>();
         Arrays.stream(str.split(" ")).forEach(s -> {
            if(mp.containsKey(s)){
                mp.put(s,mp.get(s)+1);
            } else {
                mp.put(s,1);
            }
         });
         for(Map.Entry<String,Integer> entry: mp.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
         }
         */
        // Approach 2 using Pure Streams
        String str = "welcome to code decode and code decode welcome you";
        //Function<String,String>fn = Function.identity(); // (S)->S
        //fn.apply("count");
        System.out.println(Arrays.stream(str.split(" "))
                                 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    public static void findDuplicateElement() {
        /*
        input:[10,28,87,10,20,76,28,80]
        output:10,28
        */
        List<Integer> myList = List.of(10, 28, 87, 10, 20, 76, 28, 80);
        Set<Integer> mySet = new HashSet<>();
        myList.stream().filter(item -> !mySet.add(item)).forEach(System.out::println);
    }

    public static void isPrimeNumber(int number) {
        System.out.println(number > 1 && IntStream.range(2, number).noneMatch(n -> number % n == 0));
    }

    public static void doFlatMapOperation(List<Employee> employee) {
        System.out.println(employee.stream().flatMap(emp -> emp.techStacks().stream()).collect(Collectors.toList()));
    }

    private static void findSqrtForFirst10PrimeNumber() {
        List<Double> result = Stream.iterate(1, i -> i + 1)
                                    .filter(num -> num > 1 && IntStream.range(2, num).noneMatch(n -> num % n == 0))
                                    .map(Math::sqrt)
                                    .limit(10)
                                    .collect(Collectors.toList());
        System.out.println(result);
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[]{new Employee(1, "saurabh", "Java",
                List.of(new Tech("React", 4), new Tech("Java", 4), new Tech("angular", 1)), 3456789),
                new Employee(2, "kumar", "Python",
                        List.of(new Tech("Vue", 4), new Tech("Python", 4), new Tech("GO", 1)), 127865),
                new Employee(3, "saurabh kumar", "cpp",
                        List.of(new Tech("CPP", 4), new Tech("DotNet", 4), new Tech("C#", 4)), 674507),
                new Employee(4, "Aditya", "JavaScript",
                        List.of(new Tech("Express", 4), new Tech("Node", 4), new Tech("LoopBack", 1)), 3489645),
                new Employee(5, "firstName", "React",
                        List.of(new Tech("React", 2), new Tech("Java11", 4), new Tech("Electron", 1)), 400786),};
        //System.out.println(Arrays.stream(employees).max((e2, e1)->e2.name().compareTo(e1.name())).get());
        //Arrays.stream(employees).filter((e) -> e.id() > 4).toList().stream()
        //        .map(employee -> employee.id()*2).forEach(System.out::println);
        logger.log(Level.INFO, "*************** Stream commonly asked questions *******************************");
        StreamOperations.findOccurrence();
        StreamOperations.findDuplicateElement();
        StreamOperations.isPrimeNumber(9);
        StreamOperations.findSqrtForFirst10PrimeNumber();
        StreamOperations.doFlatMapOperation(Arrays.asList(employees));
    }
}
