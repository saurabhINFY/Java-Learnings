package org.learnings.designPatterns.BuilderDesignPattern;

public class FloodResistanceBuilder implements Builder{
    @Override
    public Home buildHouse() {
        Home home = new Home();
        home.setWalls("Wallpapers in Wall waterproof");
        home.setDoors("Iron thick door");
        home.setFlooring("Marble");
        return home;
    }
}
