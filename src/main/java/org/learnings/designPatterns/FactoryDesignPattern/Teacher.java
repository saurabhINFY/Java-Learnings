package org.learnings.designPatterns.FactoryDesignPattern;

public class Teacher implements Profession {
    @Override
    public void printProfession() {
        System.out.println("I'm Teacher");
    }
}
