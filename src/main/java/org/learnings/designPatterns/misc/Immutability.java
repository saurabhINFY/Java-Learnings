package org.learnings.designPatterns.misc;

import java.util.logging.Level;
import java.util.logging.Logger;

final class ImmutableDemo {

    private int a;
    private int b;

    ImmutableDemo(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class SingletonDesignPattern {

    private static SingletonDesignPattern sb;

    private SingletonDesignPattern() {}

    public static synchronized SingletonDesignPattern createSingletonDesignPattern() {
        if (sb == null) {
            sb = new SingletonDesignPattern();
        }
        return sb;
    }
}

public class Immutability {

    private static final Logger logger = Logger.getLogger(Immutability.class.getName());

    public static void main(String[] args) {
        /*
            To create an immutable version of class
             1. Declare all method as private and final.
             2. class should be final so that it cannot be extended.
             3. do not provide the setter method to change the fields directly but could have getter methods.
             4. all initialization should be done at constructor level while object creation.
         */
        ImmutableDemo obj1 = new ImmutableDemo(10, 20);

        /*
        For Creating a Singleton class
         1. create a private constructor.
         2. create a static final variable of class type and a static method.
         3. return the static field value from the above method.
         */
        SingletonDesignPattern singletonDesignPattern = SingletonDesignPattern.createSingletonDesignPattern();
        logger.log(Level.INFO, "First HashCode value of object {}", singletonDesignPattern.hashCode());
        SingletonDesignPattern singletonDesignPattern1 = SingletonDesignPattern.createSingletonDesignPattern();
        logger.log(Level.INFO, "Second HashCode value of object {}", singletonDesignPattern1.hashCode());
    }
}
