package org.learnings.designPatterns.BuilderDesignPattern;

public class Director {
    public Builder getAppropriateBuilder(String builderType) throws ClassNotFoundException {
        if(builderType.equalsIgnoreCase("earthquake-builder")){
            return new EarthQuakeResistanceBuilder();
        } else if(builderType.equalsIgnoreCase("flood-builder")){
            return new FloodResistanceBuilder();
        } else throw new ClassNotFoundException("The Appropriate builder type not exist");
    }

    public void buildTheHouse(Builder builder){
        Home builtHouse = builder.buildHouse();
        System.out.println("The House is build now ");
        System.out.println(builtHouse.getFlooring());
        System.out.println(builtHouse.getDoors());
        System.out.println(builtHouse.getWalls());
    }
}
