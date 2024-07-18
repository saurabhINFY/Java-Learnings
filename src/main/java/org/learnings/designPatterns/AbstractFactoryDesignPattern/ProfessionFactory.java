package org.learnings.designPatterns.AbstractFactoryDesignPattern;

/*
    Factory class which returns us Actual Profession Type
 */
public class ProfessionFactory extends AbstractFactory {
    public Profession getProfession(String professionType) throws ClassNotFoundException {
        if(professionType.equalsIgnoreCase("teacher")){
            return new Teacher();
        } else if( professionType.equalsIgnoreCase("engineer")) {
            return new Engineer();
        } else {
            throw new ClassNotFoundException("The requested class type does not exist");
        }
    }
}
