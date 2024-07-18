package org.learnings.designPatterns.FactoryDesignPattern;

public class Engineer implements Profession{
    @Override
    public void printProfession() {
        System.out.println("I'm an Engineer");
    }
}
