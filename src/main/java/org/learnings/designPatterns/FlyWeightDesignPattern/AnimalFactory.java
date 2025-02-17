package org.learnings.designPatterns.FlyWeightDesignPattern;

import java.util.Arrays;
import java.util.HashMap;

public class AnimalFactory {

    private static final HashMap<String, Animal> animalHashMap = new HashMap<>();

    private static final String[] animals = { "cat", "dog" };

    public static Animal getAnimal(String animalName) throws Exception {
        String matchedAnimal = Arrays.stream(animals)
                .filter(name -> name.equalsIgnoreCase(animalName))
                .findFirst()
                .orElseThrow(() -> new Exception("No animals with such name exist in factory"));
        final boolean animalExists = animalHashMap.containsKey(matchedAnimal);
        if (animalExists) {
            return animalHashMap.get(matchedAnimal);
        } else {
            String animalType = matchedAnimal;
            if (animalType.equals("cat")) {
                final Cat cat = new Cat("cat");
                animalHashMap.put(animals[0], cat);
                return cat;
            } else {
                final Dog dog = new Dog("dog");
                animalHashMap.put(animals[0], dog);
                return dog;
            }
        }
    }
}
