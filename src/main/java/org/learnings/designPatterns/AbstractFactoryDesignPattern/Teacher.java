package org.learnings.designPatterns.AbstractFactoryDesignPattern;

/*
    concrete class for teacher
 */
public class Teacher implements Profession{
    @Override
    public void printProfession() {
        System.out.println("I'm full fledged teacher");
    }
}
