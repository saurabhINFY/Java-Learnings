package org.learnings.designPatterns.PrototypeDesignPattern;

/*
    Profession type
 */
public abstract class Profession implements Cloneable{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void printProfession();

    @Override
    public Profession clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (Profession) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
