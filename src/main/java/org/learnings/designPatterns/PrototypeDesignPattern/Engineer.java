package org.learnings.designPatterns.PrototypeDesignPattern;


public class Engineer extends Profession {
    @Override
    public void printProfession() {
        System.out.println("I'm Full Fledged Engineer with id "+this.getId());
    }
}
