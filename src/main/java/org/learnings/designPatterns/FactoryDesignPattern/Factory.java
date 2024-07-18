package org.learnings.designPatterns.FactoryDesignPattern;

public class Factory {
    public Profession getRespectiveProfessionObj(String professionName) throws Exception {
        if(professionName.equalsIgnoreCase("teacher")){
            return new Teacher();
        } else if (professionName.equalsIgnoreCase("engineer")){
            return new Engineer();
        } else {
            throw new ClassNotFoundException("Unable to found such class with given type");
        }
    }
}
