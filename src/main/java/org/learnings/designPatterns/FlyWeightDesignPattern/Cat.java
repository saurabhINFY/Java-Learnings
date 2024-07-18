package org.learnings.designPatterns.FlyWeightDesignPattern;

public class Cat implements Animal{

    private String name = null;
    Cat(String name){
        setName(name);
    }

    @Override public String toString() {
        return "Animal{" +
                "name='" + name + '\'' + Cat.class +
                '}';
    }

    @Override public void setName(String name) {
        this.name = name;
    }

    @Override public void printAnimalAttributes() {
        System.out.println("Number of eyes animal having is "+ CommonSharableAttribute.eyes);
        System.out.println("Number of nose animal having is "+ CommonSharableAttribute.nose);
        System.out.println("Number of legs animal having is "+ CommonSharableAttribute.legs);
        System.out.println("Number of tail animal having is "+ CommonSharableAttribute.tail);
    }
}
