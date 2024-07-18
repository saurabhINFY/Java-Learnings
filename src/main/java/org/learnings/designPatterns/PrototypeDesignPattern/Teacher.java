package org.learnings.designPatterns.PrototypeDesignPattern;

public class Teacher extends Profession {
    @Override
    public void printProfession() {
        System.out.println("I'm Teacher with id "+this.getId());
    }
}
