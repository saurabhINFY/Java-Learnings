package org.learnings.designPatterns.BuilderDesignPattern;

public class EarthQuakeResistanceBuilder implements Builder{
    @Override
    public Home buildHouse() {
        Home home = new Home();
        home.setDoors("It has Wooden doors");
        home.setFlooring("It has Wooden Flooring");
        home.setWalls("It has Wooden Walls");
        return home;
    }
}
