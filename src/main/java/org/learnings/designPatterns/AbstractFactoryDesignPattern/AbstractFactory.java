package org.learnings.designPatterns.AbstractFactoryDesignPattern;

/*
    We have abstracted one more layer on factory to decide user to which factory he wants first

 */
public abstract class AbstractFactory{

    public static AbstractFactory getFactory(boolean isTraineeType){
        if(isTraineeType){
            return new TraineeProfessionFactory();
        } else {
            return new ProfessionFactory();
        }
    }
    public abstract Profession getProfession(String professionType) throws ClassNotFoundException;
}
