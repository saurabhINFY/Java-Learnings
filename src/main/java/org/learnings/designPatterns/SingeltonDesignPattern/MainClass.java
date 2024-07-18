package org.learnings.designPatterns.SingeltonDesignPattern;

public class MainClass {

    public static void main(String[] args) {
        SingletonClass singletonClass = SingletonClass.getSingletonClassObj();

        System.out.println(singletonClass);

        SingletonClass singletonClass1 = SingletonClass.getSingletonClassObj();

        System.out.println(singletonClass1);

        // both will print same object hash code
    }

}
