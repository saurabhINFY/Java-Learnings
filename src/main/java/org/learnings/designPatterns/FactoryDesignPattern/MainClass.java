package org.learnings.designPatterns.FactoryDesignPattern;

public class MainClass {
    public static void main(String[] args) throws Exception {
        // we created a factory which return us respective object
        // instead we explicitly create the Doctor and Engineer, we hide the creation logic from the client hence its also called Virtual Constructor pattern
        Factory factory = new Factory();

        Profession profession = factory.getRespectiveProfessionObj("engineer");
        profession.printProfession();

        Profession profession1 = factory.getRespectiveProfessionObj("teacher");
        profession1.printProfession();

    }

}
