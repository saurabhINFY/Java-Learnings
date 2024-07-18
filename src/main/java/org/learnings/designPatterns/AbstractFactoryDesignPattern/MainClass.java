package org.learnings.designPatterns.AbstractFactoryDesignPattern;
/*
    This is also known as factory of factory
    Abstract Factory patterns lets a class return factory of classes
    this is one higher level than factory patterns as one extra abstraction layer has been added
    Abstract Factory pattern is also known as KIT
 */
public class MainClass {
    public static void main(String[] args) {
        // first we will create the object of abstract factory to get the underlying factory type we want
        AbstractFactory abstractFactory = AbstractFactory.getFactory(false);
        AbstractFactory abstractFactory1 = AbstractFactory.getFactory(true);
        try{
            // after getting the desired factory type we will fetch the object we want from that factory
            Profession profession = abstractFactory.getProfession("teacher");
            profession.printProfession();

            Profession profession1 = abstractFactory1.getProfession("engineer");
            profession1.printProfession();

        } catch (ClassNotFoundException e){
            System.out.println("Something went wrong "+e.getMessage());
        }
    }
}
