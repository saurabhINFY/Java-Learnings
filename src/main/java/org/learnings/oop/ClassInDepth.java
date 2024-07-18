package org.learnings.oop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/*
    We have various types of classes
    1. Concrete class
    2. Abstract class
    3. Nested class (static nested , Inner class(local, member)
    4. Anonymous class
 */
class Outer {

    private static final Logger logger = Logger.getLogger(Outer.class.getName());

    final int a = 10;
    static int b = 20;

    void display() {
        logger.log(Level.INFO, "Value of A = {} and B = {} ", new Object[]{a, b});
    }

    // this is simply called as static nested class not inner class
    static class Inner {

        int c = 30;
        static int d = 40;

        void print() {
            // " A = "+ a will throw error as non-static cannot be reference from static context
            logger.log(Level.INFO, "Inner::print -> C = {} D = {} B = {}", new Object[]{c, d, b});
            // display() will throw error as non-static cannot be reference from static context
        }
    }

    // this is inner class because Outer class object is required to instantiate this
    class MemberInnerClass {

        int p = 50;
        static int q = 60;

        void print() {
            logger.log(Level.INFO, "MemberInnerClass::print -> p = {} q = {} ", new Object[]{p, q});
            new Inner().print();
        }
    }

    boolean demoLocalInnerClasses(String firstName, String lastName) {
        firstName = firstName.toUpperCase();
        lastName = lastName.toUpperCase();
        class LocalInnerClass {

            private final String firstName;
            private final String lastName;

            LocalInnerClass(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            public String getFirstName() {
                return firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public boolean testFirstNameValidation() {
                return !firstName.isEmpty() && Arrays.stream(firstName.split(""))
                                                     .collect(Collectors.groupingBy(Function.identity(),
                                                             Collectors.counting()))
                                                     .size() != 1;
            }

            public boolean testLastNameValidation() {
                return !lastName.isEmpty() && this.testFirstNameValidation();
            }
        }
        LocalInnerClass localInnerClass = new LocalInnerClass(firstName, lastName);
        return localInnerClass.testFirstNameValidation() && localInnerClass.testLastNameValidation();
    }
}

public class ClassInDepth {

    private static final Logger logger = Logger.getLogger(ClassInDepth.class.getName());

    public static void main(String[] args) {
        // instantiating Concrete class
        Outer outer = new Outer();

        logger.log(Level.INFO, "****static Inner class behaviour********");
        logger.log(Level.INFO,
                "Printing Outer class member variable from main method  X:- {} static member variable Y:- {}",
                new Object[]{outer.a, Outer.b});

        Outer.Inner inner = new Outer.Inner();
        inner.print();
        logger.log(Level.INFO, "ClassInDepth -> Inner -> C:- {} D:-{}", new Object[]{inner.c, Outer.Inner.d});

        logger.log(Level.INFO, "*****Member Inner class behaviour********");
        Outer.MemberInnerClass memberInnerClass = outer.new MemberInnerClass();
        memberInnerClass.print();

        logger.log(Level.INFO, "*****Local Member Inner class behaviour********");
        Map<String, String> map = new HashMap<>();
        map.put("John", "Doe");
        map.put("Jane", "Doe");
        map.forEach((k, v) -> logger.log(Level.INFO, (
                "Name :- [" + k + " " + v + "]" + " validity:- " + outer.demoLocalInnerClasses(k, v))));
    }
}
