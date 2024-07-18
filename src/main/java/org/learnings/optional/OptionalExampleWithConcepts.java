package org.learnings.optional;/*
ref:- https://www.baeldung.com/java-optional
code-decode YT channel:- https://www.youtube.com/watch?v=3BSrJDI-nLQ&list=PLyHJZXNdCXsdeusn4OM33415DCMQ6sUKy&index=22
 */

import java.util.Optional;

public class OptionalExampleWithConcepts {

    private static void optionalChaining() {
        /* we can apply filter and map with optional to simplify complex logic
           filter takes predicate and returns optional with value if it satisfies the condition otherwise returns optional with null values
           map is used to apply transformation and is used to return the transformed optional with data
         */
        String password = "some password";
        Optional.of(password)
                .map(String::trim)
                .filter((s) -> s.length() > 3)
                .ifPresentOrElse((s) -> System.out.println(s.toUpperCase()),
                        () -> System.out.println("invalid password")); // SOME PASSWORD
    }

    private static String getDefaultTextIfNull() {
        return "Default text";
    }

    public static void main(String[] args) {
        /*
            we could combine multiple null checks over object using filter map or even in streams
         */
        optionalChaining();

        /*
            we can create optional in many ways
            static method of() but argument passed should be non-null value otherwise it throws null pointer exception
         */

        Optional.of(null); // this line will give null pointer exception due to empty optional object
        Optional<String> optional1 = Optional.of("some value");

        /*
        we can get the value inside optional object using get() but get() works the way it excepts to have non-null value in optional
        otherwise will throw NoSuchElementException
         */
        System.out.println(optional1.get()); // "some value"
        Optional.ofNullable(null).get(); // will result in no such element exception

        // for storing null values in optional object we can use ofNullable()

        Optional<String> optional2 = Optional.ofNullable(null);
        //since it allows null value as well before performing get() we can apply isPresent() or isEmpty() [from java 11 onwards] check so the code won't break
        // by passing null value to ofNullable() it returns us empty optional object
        if (optional2.isPresent()) { // or  !optional2.isEmpty()
            System.out.println("getting data from ofNullable() " + optional2.get());
        } else {
            System.out.println("null is present");
        }

        //since we need to execute some tasks if optional is non-empty we can attach method like ifPresent()
        // ifPresent() takes consumer which executes (apply()) if optional is non-Empty
        optional2.ifPresent(String::length);

        // we can have Default Values as well if ifPresent() does not execute i.e executing else relate logic
        // we have orElse, orElseGet

        // orElse method will get the optional value if preset otherwise executes and return its argument
        System.out.println(optional2.orElse("null has been found")); // null has been found

        // orElseGet() on the other hand takes a supplier interface which executes if empty value is found in optional
        System.out.println(optional2.orElseGet(() -> "some null value found")); // some null value found

        /*
         both orElse and orElseGet() behaves same way if optional is having null value but when they have value the result is as follows:-
         1. if we give any method is orElse() no matter value is present in optional or not it simply executes the method
         */
        System.out.println(optional1.orElse(
                getDefaultTextIfNull())); // since optional1 has non-null value still the function call of getDefaultTextIfNull will take place

        /*
           2. in case of orElseGet() if it found non-null value in optional it does not execute its supplier at all
              which saves redundant fn calls lets say if getDefaultTextIfNull is having multiple db calls orElse will degrade performance
         */
        System.out.println(optional1.orElseGet(
                OptionalExampleWithConcepts::getDefaultTextIfNull)); // here the supplier won't execute at all

        // we can also throw exception using orElseThrow which takes to overloaded format either supplier one or single string
        // from java 10 the contract of orElseThrow() if we don't pass any supplier it will default throw NoSuchElementException
        optional2.orElseThrow(IllegalArgumentException::new);

        Optional<String> optional3 = Optional.ofNullable(null);
        optional3.orElseThrow(() -> new NullPointerException("no value present"));
        System.out.println(optional3.get());

    }
}
