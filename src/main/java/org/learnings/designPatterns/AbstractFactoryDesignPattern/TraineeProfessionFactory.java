package org.learnings.designPatterns.AbstractFactoryDesignPattern;

/*
    Factory class which return us the trainee professions
 */
public class TraineeProfessionFactory extends AbstractFactory {
    @Override
    public Profession getProfession(String professionType) throws ClassNotFoundException {
        if(professionType.equalsIgnoreCase("teacher")){
            return new TraineeTeacher();
        } else if( professionType.equalsIgnoreCase("engineer")) {
            return new TraineeEngineer();
        } else {
            throw new ClassNotFoundException("The requested class type for trainee does not exist");
        }
    }
}
