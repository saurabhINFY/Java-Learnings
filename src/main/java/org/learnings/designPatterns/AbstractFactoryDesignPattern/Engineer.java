package org.learnings.designPatterns.AbstractFactoryDesignPattern;

public class Engineer implements Profession{
    @Override
    public void printProfession() {
        System.out.println("I'm Full Fledged Engineer");
    }
}
