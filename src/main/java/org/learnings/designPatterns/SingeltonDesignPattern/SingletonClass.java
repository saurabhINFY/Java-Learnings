package org.learnings.designPatterns.SingeltonDesignPattern;

public class SingletonClass {

    private static final SingletonClass singletonClass = new SingletonClass();

    private SingletonClass() {}

    public static SingletonClass getSingletonClassObj() {
        return singletonClass;
    }
}
