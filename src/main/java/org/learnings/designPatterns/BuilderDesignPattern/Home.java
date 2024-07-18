package org.learnings.designPatterns.BuilderDesignPattern;

/*
    Simple POJO Class
 */
public class Home {
    private String walls;
    private String doors;
    private String flooring;

    public String getWalls() {
        return walls;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getFlooring() {
        return flooring;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }
}
