package org.learnings.designPatterns.FlyWeightDesignPattern;

public class Dog implements Animal{

    private String name = null;
    Dog(String name){
        setName(name);
    }
    @Override public void setName(String name) {
        this.name = name;
    }

    @Override public void printAnimalAttributes() {
        System.out.println("Name of Animal is " + this.name);
        System.out.println("Number of eyes animal having is "+ CommonSharableAttribute.eyes);
        System.out.println("Number of nose animal having is "+ CommonSharableAttribute.nose);
        System.out.println("Number of legs animal having is "+ CommonSharableAttribute.legs);
        System.out.println("Number of tail animal having is "+ CommonSharableAttribute.tail);
    }
}
