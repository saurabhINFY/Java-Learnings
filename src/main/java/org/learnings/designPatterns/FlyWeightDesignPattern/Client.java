package org.learnings.designPatterns.FlyWeightDesignPattern;

public class Client {

    public static void main(String[] args) throws Exception {
        final Animal animal = AnimalFactory.getAnimal("cat");
        animal.printAnimalAttributes();

        final Animal otherAnimal = AnimalFactory.getAnimal("dog");
        otherAnimal.printAnimalAttributes();
    }
}
